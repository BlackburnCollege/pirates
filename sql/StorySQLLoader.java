package sql;

import gui.Music;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.ACEObject;
import world.Action;
import world.Challenge;
import world.Choice;
import world.Conditional;
import world.Event;

/**
 *
 * @author lucas.burdell
 */
public class StorySQLLoader {

    private SQLDatabaseManager manager = SQLDatabaseManager.getManager("storyDB");
    private Connection connection = manager.getConnection();
    private HashMap<Integer, ArrayList<ACEScaffold>> awaitingMap = new HashMap<>();
    private ACEScaffold[] objectArray;
    //private Hash<Integer> awaitingIds = new ArrayList<>();

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private static enum ACEType {
        ACTION, CHOICE, CONDITIONAL, EVENT, CHALLENGE;
    }

    private static class ACEScaffold<T extends ACEObject> {

        private final T object;
        private final int id;
        private final ACEType type;

        public ACEScaffold(T object, ACEType type) {
            this.object = object;
            this.id = object.getID();
            this.type = type;
        }

        /**
         * @return the object
         */
        public T getObject() {
            return object;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @return the type
         */
        public ACEType getType() {
            return type;
        }

        @Override
        public String toString() {
            return id + " " + type.toString();
        }
    }

    private ACEScaffold<Event> loadEvent(int id) {
        System.out.println("loading event " + id);
        try {
            Event object = new Event(id);
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "event WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet events = statement.executeQuery();
            if (events.isBeforeFirst()) {
                events.next();
                object.setText(events.getString("text"));
                if (object.getText() == null) {
                    throw new RuntimeException("Event with id " + id + " has no text!");
                }
                try {
                    object.setMusic(Music.valueOf(events.getString("music")));
                } catch (NullPointerException npe) {
                    object.setMusic(null);
                }
                object.setPicture(events.getString("backgroundname"));
            } else {
                throw new RuntimeException("Event with id " + id + " not found "
                        + "in event table");
            }
            ACEScaffold<Event> scaffold = new ACEScaffold<>(object, ACEType.EVENT);
            return scaffold;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleEventNeededIds(ACEScaffold<Event> event) {
        try {
            objectArray[event.getId()] = event;
            checkAwaiting(event);
            //attachIds(event);

            // check actions
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE eventid=?");
            statement.setInt(1, event.getId());
            ResultSet set = statement.executeQuery();
            boolean isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("actionid");
                /*
                if (id > event.getId()) {
                    addNeededId(event, id);
                }
                 */
                attachIds(event, id);
            }
            if (isEmpty) {
                System.err.println("WARNING: " + event + " has no associated actions!");
            }

            // check choices
            statement = getConnection().prepareStatement("SELECT * FROM "
                    + "choice WHERE eventid=?");
            statement.setInt(1, event.getId());
            set = statement.executeQuery();
            isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("id");
                /*
                if (id > event.getId()) {
                    addNeededId(event, id);
                }
                 */
                attachIds(event, id);
            }

            if (isEmpty) {
                System.err.println("WARNING: " + event + " has no associated choices!");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Action> loadAction(int id) {
        System.out.println("loading action " + id);
        try {
            Action object = new Action(id);
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "actions WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet actions = statement.executeQuery();
            if (actions.isBeforeFirst()) {
                actions.next();
                object.setText(actions.getString("text"));
            } else {
                throw new RuntimeException("Action with id " + id + " not found "
                        + "in action table");
            }
            ACEScaffold<Action> scaffold = new ACEScaffold<>(object, ACEType.ACTION);
            return scaffold;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleActionNeededIds(ACEScaffold<Action> action) {
        try {
            objectArray[action.getId()] = action;
            checkAwaiting(action);

            // check events
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE actionid=?");
            statement.setInt(1, action.getId());
            ResultSet set = statement.executeQuery();
            boolean isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("eventid");
                attachIds(action, id);
                /*
                if (id > action.getId()) {
                    addNeededId(action, id);
                }
                 */
            }

            if (isEmpty) {
                throw new RuntimeException(action + " has no associated events!");
            }

            // check choices
            statement = getConnection().prepareStatement("SELECT * FROM "
                    + "choice WHERE actionid=?");
            statement.setInt(1, action.getId());
            set = statement.executeQuery();
            isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("id");
                attachIds(action, id);
                /*
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
                 */

            }

            if (isEmpty) {
                System.err.println(action + " has no associated choices!");
            }

            // check challenges
            statement = getConnection().prepareStatement("SELECT * FROM "
                    + "actions WHERE id=?");
            statement.setInt(1, action.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("challengeid");
                if (id == 0) {
                    action.getObject().setChallenge(null);
                } else {
                    attachIds(action, id);
                }
            }

            // check conditionals 
            statement = getConnection().prepareStatement("SELECT * FROM "
                    + "conditional WHERE attachedid=?");
            statement.setInt(1, action.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("id");
                attachIds(action, id);
                /*
                if (id > action.getId()) {
                    addNeededId(action, id);
                }
                 */
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Choice> loadChoice(int id) {
        System.out.println("loading choice " + id);
        try {
            Choice object = new Choice(id);
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "choice WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet choices = statement.executeQuery();
            if (choices.isBeforeFirst()) {
                choices.next();
                object.setText(choices.getString("text"));
                if (object.getText() == null) {
                    throw new RuntimeException("Choice with id " + id + " has no text!");
                }
            } else {
                throw new RuntimeException("Event with id " + id + " not found "
                        + "in event table");
            }
            ACEScaffold<Choice> scaffold = new ACEScaffold<>(object, ACEType.CHOICE);
            return scaffold;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleChoiceNeededIds(ACEScaffold<Choice> choice) {
        try {
            objectArray[choice.getId()] = choice;
            checkAwaiting(choice);

            // check events
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "choice WHERE id=?");
            statement.setInt(1, choice.getId());
            ResultSet set = statement.executeQuery();
            boolean isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("eventid");
                /*
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
                 */
                attachIds(choice, id);
            }
            if (isEmpty) {
                System.err.println(choice + " has no associated events!");
            }

            // check actions
            statement = getConnection().prepareStatement("SELECT * FROM "
                    + "choice WHERE id=?");
            statement.setInt(1, choice.getId());
            set = statement.executeQuery();
            isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("actionid");
                attachIds(choice, id);
                /*
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
                 */

            }

            if (isEmpty) {
                System.err.println(choice + " has no associated actions!");
            }

            // check conditionals 
            statement = getConnection().prepareStatement("SELECT * FROM "
                    + "conditional WHERE attachedid=?");
            statement.setInt(1, choice.getId());
            set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                attachIds(choice, id);
                /*
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
                 */
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Challenge> loadChallenge(int id) {
        System.out.println("loading challenge " + id);
        try {
            Challenge object = new Challenge(id);
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "challenge WHERE challengeid=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet challenges = statement.executeQuery();
            if (challenges.isBeforeFirst()) {
                challenges.next();
                object.setChallengeName(challenges.getString("challengename"));
                object.setType(challenges.getString("challengetype"));
            } else {
                throw new RuntimeException("Challenge with id " + id + " not found "
                        + "in challenge table");
            }
            ACEScaffold<Challenge> scaffold = new ACEScaffold<>(object, ACEType.CHALLENGE);
            return scaffold;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleChallengeNeededIds(ACEScaffold<Challenge> challenge) {
        try {
            objectArray[challenge.getId()] = challenge;
            checkAwaiting(challenge);

            // check actions
            PreparedStatement statement = getConnection().prepareStatement(""
                    + "SELECT * "
                    + "FROM actions "
                    + "WHERE challengeid=?");
            statement.setInt(1, challenge.getId());
            ResultSet set = statement.executeQuery();
            boolean isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int id = set.getInt("id");
                attachIds(challenge, id);
                /*
                if (id > challenge.getId()) {
                    addNeededId(challenge, id);
                }
                 */
            }
            if (isEmpty) {
                System.err.println(challenge + " has no associated actions!");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Conditional> loadConditional(int id) {
        System.out.println("loading conditional " + id);
        try {
            Conditional object = new Conditional(id);
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "conditional WHERE id=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet conditionals = statement.executeQuery();
            if (conditionals.isBeforeFirst()) {
                conditionals.next();
                object.setFlagName(conditionals.getString("flag"));
                object.setValue(conditionals.getInt("flagstate"));
            } else {
                throw new RuntimeException("Conditional with id " + id + " not found "
                        + "in conditional table");
            }
            ACEScaffold<Conditional> scaffold = new ACEScaffold<>(object, ACEType.CONDITIONAL);
            return scaffold;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void handleConditionalNeededIds(ACEScaffold<Conditional> conditional) {
        try {
            objectArray[conditional.getId()] = conditional;
            checkAwaiting(conditional);

            // get attached id
            PreparedStatement statement = getConnection().prepareStatement(
                    "SELECT * FROM conditional WHERE id=?");
            statement.setInt(1, conditional.getId());
            ResultSet set = statement.executeQuery();
            boolean isEmpty = true;
            while (set.next()) {
                isEmpty = false;
                int attachedId = set.getInt("attachedid");
                /*
                if (attachedId > conditional.getId()) {
                    addNeededId(conditional, attachedId);
                }
                 */
                attachIds(conditional, attachedId);
            }
            if (isEmpty) {
                System.err.println(conditional + " has no associated objects!");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void addNeededId(ACEScaffold object, int neededId) {
        ArrayList<ACEScaffold> list = awaitingMap.get(neededId);
        if (list == null) {
            list = new ArrayList<>();
            awaitingMap.put(neededId, list);
        }
        list.add(object);
    }

    private void attach(Action action, Event event) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE eventid=? AND actionid=?");
            statement.setInt(1, event.getID());
            statement.setInt(2, action.getID());
            ResultSet set = statement.executeQuery();
            set.next();
            int position = set.getInt("eventposition");
            action.setEvent(event, position);
            System.out.println("action " + action.getID() + " set event "
                    + event.getID() + " to position " + position);
        } catch (SQLException ex) {
            Logger.getLogger(StorySQLLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void attach(Event event, Choice choice) {
        System.out.println("attaching event " + event.getID() + " to choice "
                + choice.getID());
        for (Choice choice1 : event.getChoices()) {
            if (choice1 == choice) {
                return;
            }
        }
        event.addChoice(choice);
    }

    private void attach(Choice choice, Action action) {
        System.out.println("attaching choice " + choice.getID() + " to action "
                + action.getID());
        choice.setAction(action);
    }

    private void attach(Choice choice, Conditional conditional) {
        System.out.println("attaching choice " + choice.getID() + " to conditional "
                + conditional.getID());
        for (Conditional condition : choice.getConditionals()) {
            if (condition == conditional) {
                return;
            }
        }
        choice.addConditional(conditional);
    }

    private void attach(Action action, Conditional conditional) {
        System.out.println("attaching action " + action.getID() + " to conditional "
                + conditional.getID());
        for (Conditional condition : action.getConditionals()) {
            if (condition == conditional) {
                return;
            }
        }
        action.addConditional(conditional);
    }

    private void attach(Action action, Challenge challenge) {
        System.out.println("attaching action " + action.getID() + " to challenge "
                + challenge.getID());
        action.setChallenge(challenge);
    }

    private void checkAwaiting(ACEScaffold newObject) {
        if (awaitingMap.get(newObject.getId()) != null) {
            for (ACEScaffold scaffold : awaitingMap.get(newObject.getId())) {
                attachIds(newObject, scaffold.getId());
            }
            awaitingMap.remove(newObject.getId());
        }
    }

    private void attachIds(ACEScaffold newObject, int newId) {
        //ArrayList<ACEScaffold> list = loadMap.get(newObject.getId());
        ACEScaffold scaffold = objectArray[newId];
        if (scaffold == null) {
            if (awaitingMap.get(newId) == null) {
                ArrayList<ACEScaffold> list = new ArrayList<>();
                list.add(newObject);
                awaitingMap.put(newId, list);
            } else {
                awaitingMap.get(newId).add(newObject);
            }
            return;
        }
        ACEObject object = scaffold.getObject();
        if (newObject.getType() == ACEType.EVENT) {
            Event event = (Event) newObject.getObject();
            switch (scaffold.getType()) {
                case ACTION:
                    attach((Action) object, event);
                    break;
                case CHOICE:
                    attach(event, (Choice) object);
                    break;
                default:
                    System.err.println(newObject
                            + " mismatched with " + scaffold);
            }
        } else if (newObject.getType() == ACEType.ACTION) {
            Action action = (Action) newObject.getObject();
            switch (scaffold.getType()) {
                case EVENT:
                    attach(action, (Event) object);
                    break;
                case CHOICE:
                    attach((Choice) object, action);
                    break;
                case CONDITIONAL:
                    attach(action, (Conditional) object);
                    break;
                case CHALLENGE:
                    attach(action, (Challenge) object);
                    break;
                default:
                    System.err.println(newObject
                            + " mismatched with " + scaffold);
            }

        } else if (newObject.getType() == ACEType.CHOICE) {
            Choice choice = (Choice) newObject.getObject();
            System.out.println("Checking object " + newId + " for choice " + choice.getID());
            switch (scaffold.getType()) {
                case EVENT:
                    attach((Event) object, choice);
                    break;
                case ACTION:
                    attach(choice, (Action) object);
                    break;
                case CONDITIONAL:
                    attach(choice, (Conditional) object);
                    break;
                default:
                    System.err.println(newObject
                            + " mismatched with " + scaffold);
            }
        } else if (newObject.getType() == ACEType.CHALLENGE) {
            Challenge challenge = (Challenge) newObject.getObject();
            switch (scaffold.getType()) {
                case ACTION:
                    attach((Action) object, challenge);
                    break;
                default:
                    System.err.println(newObject
                            + " mismatched with " + scaffold);
            }
        } else if (newObject.getType() == ACEType.CONDITIONAL) {
            Conditional conditional = (Conditional) newObject.getObject();
            switch (scaffold.getType()) {
                case ACTION:
                    attach((Action) object, conditional);
                    break;
                case CHOICE:
                    attach((Choice) object, conditional);
                    break;
                default:
                    System.err.println(newObject
                            + " mismatched with " + scaffold);
            }
        }
        //loadMap.remove(newObject.getId());
    }

    public boolean loadedProperly() {
        boolean loaded = true;
        /*
        for (Entry<Integer, ArrayList<ACEScaffold>> entry : loadMap.entrySet()) {
            loaded = false;
            System.err.println("ID " + entry.getKey() + " detected as missing!");
            if (!entry.getValue().isEmpty()) {
                System.err.println("Entries waiting for ID " + entry.getKey() + ":");
                System.err.println(entry.getValue().toString());
            } else {
                System.err.println("Entry for " + entry.getKey() + " was empty!");
            }
        }
         */
        return loaded;
    }

    public Event loadDB() throws SQLException {
        Event root = null;
        PrintStream console = System.out;
        File file = new File("storyloader.out");
        try {
            System.setOut(new PrintStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StorySQLLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement getSize = getConnection().prepareStatement(
                "SELECT MAX(aceobject.id) FROM aceobject",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet size = getSize.executeQuery();
        if (size.isBeforeFirst()) {
            size.next();
            objectArray = new ACEScaffold[size.getInt(1) + 1];
            System.out.println("Number of ACE objects: " + objectArray.length);
        } else {
            throw new RuntimeException("Cannot determine number of ace objects!");
        }

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM "
                + "aceobject ORDER BY id",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            int id = set.getInt("id");
            String acetype = set.getString("acetype");
            acetype = acetype.toLowerCase();
            ACEScaffold scaffold;
            switch (acetype) {
                case "event":
                    scaffold = loadEvent(id);
                    handleEventNeededIds(scaffold);
                    if (root == null) {
                        root = (Event) scaffold.getObject();
                    }
                    break;
                case "action":
                    scaffold = loadAction(id);
                    handleActionNeededIds(scaffold);
                    break;
                case "choice":
                    scaffold = loadChoice(id);
                    handleChoiceNeededIds(scaffold);
                    break;
                case "challenge":
                    scaffold = loadChallenge(id);
                    handleChallengeNeededIds(scaffold);
                    break;
                case "conditional":
                    scaffold = loadConditional(id);
                    handleConditionalNeededIds(scaffold);
                    break;
            }
        }

        if (!loadedProperly()) {
            throw new RuntimeException("Detected unfinished map. Look for errors from the output above.");
        }
        
        System.setOut(console);
        System.out.println("Story loading output saved to " + file.getAbsolutePath());

        return root;
    }

}
