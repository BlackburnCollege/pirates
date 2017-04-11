package sql;

import gui.Music;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

    private SQLDatabaseManager manager = new SQLDatabaseManager("storyDB", true);
    private Connection connection = manager.getConnection();
    private HashMap<Integer, ArrayList<ACEScaffold>> loadMap = new HashMap<>();

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
    }

    private ACEScaffold<Event> loadEvent(int id) {
        try {
            Event object = new Event(id);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "event WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet events = statement.executeQuery();
            if (events.isBeforeFirst()) {
                object.setText(events.getString("text"));
                object.setMusic(Music.valueOf(events.getString("music")));
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
            attachIds(event);

            // check actions
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE eventid=?");
            statement.setInt(1, event.getId());
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("actionid");
                if (id > event.getId()) {
                    addNeededId(event, id);
                }
            }

            // check choices
            statement = connection.prepareStatement("SELECT * FROM "
                    + "choice WHERE eventid=?");
            statement.setInt(1, event.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("id");
                if (id > event.getId()) {
                    addNeededId(event, id);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Action> loadAction(int id) {
        try {
            Action object = new Action(id);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "actions WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet actions = statement.executeQuery();
            if (actions.isBeforeFirst()) {
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
            attachIds(action);

            // check events
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE actionid=?");
            statement.setInt(1, action.getId());
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("eventid");
                if (id > action.getId()) {
                    addNeededId(action, id);
                }
            }

            // check challenges
            statement = connection.prepareStatement("SELECT * FROM "
                    + "actions WHERE id=?");
            statement.setInt(1, action.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("challengeid");
                if (id > action.getId()) {
                    addNeededId(action, id);
                }
            }

            // check conditionals 
            statement = connection.prepareStatement("SELECT * FROM "
                    + "conditional WHERE attachedid=?");
            statement.setInt(1, action.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("id");
                if (id > action.getId()) {
                    addNeededId(action, id);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Choice> loadChoice(int id) {
        try {
            Choice object = new Choice(id);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "choice WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet choices = statement.executeQuery();
            if (choices.isBeforeFirst()) {
                object.setText(choices.getString("text"));
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
            attachIds(choice);

            // check events
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "choice WHERE id=?");
            statement.setInt(1, choice.getId());
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("eventid");
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
            }

            // check actions
            statement = connection.prepareStatement("SELECT * FROM "
                    + "choice WHERE id=?");
            statement.setInt(1, choice.getId());
            set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("actionid");
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
            }

            // check conditionals 
            statement = connection.prepareStatement("SELECT * FROM "
                    + "conditional WHERE attachedid=?");
            statement.setInt(1, choice.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("id");
                if (id > choice.getId()) {
                    addNeededId(choice, id);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Challenge> loadChallenge(int id) {
        try {
            Challenge object = new Challenge(id);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "challenge WHERE challengeid=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet challenges = statement.executeQuery();
            if (challenges.isBeforeFirst()) {
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
            attachIds(challenge);

            // check actions
            PreparedStatement statement = connection.prepareStatement(""
                    + "SELECT * "
                    + "FROM actions "
                    + "WHERE challengeid=?");
            statement.setInt(1, challenge.getId());
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                if (id > challenge.getId()) {
                    addNeededId(challenge, id);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ACEScaffold<Conditional> loadConditional(int id) {
        try {
            Conditional object = new Conditional(id);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "conditional WHERE id=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, id);
            ResultSet conditionals = statement.executeQuery();
            if (conditionals.isBeforeFirst()) {
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
            attachIds(conditional);

            // get attached id
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM conditional WHERE id=?");
            statement.setInt(1, conditional.getId());
            ResultSet set = statement.executeQuery();
            set.next();
            int attachedId = set.getInt("attachedid");
            if (attachedId > conditional.getId()) {
                addNeededId(conditional, attachedId);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void addNeededId(ACEScaffold object, int neededId) {
        ArrayList<ACEScaffold> list = loadMap.get(neededId);
        if (list == null) {
            list = new ArrayList<>();
            loadMap.put(neededId, list);
        }
        list.add(object);
    }

    private void attach(Action action, Event event) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE eventid=? AND actionid=?");
            statement.setInt(1, event.getID());
            statement.setInt(2, action.getID());
            ResultSet set = statement.executeQuery();
            set.next();
            int position = set.getInt("eventposition");
            action.setEvent(event, position);
        } catch (SQLException ex) {
            Logger.getLogger(StorySQLLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void attach(Event event, Choice choice) {
        event.addChoice(choice);
    }

    private void attach(Choice choice, Action action) {
        choice.setAction(action);
    }

    private void attach(Choice choice, Conditional conditional) {
        choice.addConditional(conditional);
    }

    private void attach(Action action, Conditional conditional) {
        action.addConditional(conditional);
    }

    private void attach(Action action, Challenge challenge) {
        action.setChallenge(challenge);
    }

    private void attachIds(ACEScaffold newObject) {
        ArrayList<ACEScaffold> list = loadMap.get(newObject.getId());
        if (list == null) {
            return;
        }
        if (newObject.getType() == ACEType.EVENT) {
            Event event = (Event) newObject.getObject();
            for (ACEScaffold scaffold : list) {
                ACEObject object = scaffold.getObject();
                switch (scaffold.getType()) {
                    case ACTION:
                        attach((Action) object, event);
                        break;
                    case CHOICE:
                        attach(event, (Choice) object);
                        break;
                    default:
                        System.err.println("Event " + event.getID() + " "
                                + "mismatched with " + object.getID());
                }
            }
        } else if (newObject.getType() == ACEType.ACTION) {
            Action action = (Action) newObject.getObject();
            for (ACEScaffold scaffold : list) {
                ACEObject object = scaffold.getObject();
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
                        System.err.println("Action " + action.getID() + " "
                                + "mismatched with " + object.getID());
                }
            }
        } else if (newObject.getType() == ACEType.CHOICE) {
            Choice choice = (Choice) newObject.getObject();
            for (ACEScaffold scaffold : list) {
                ACEObject object = scaffold.getObject();
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
                        System.err.println("choice " + choice.getID() + " "
                                + "mismatched with " + object.getID());
                }
            }
        } else if (newObject.getType() == ACEType.CHALLENGE) {
            Challenge challenge = (Challenge) newObject.getObject();
            for (ACEScaffold scaffold : list) {
                ACEObject object = scaffold.getObject();
                switch (scaffold.getType()) {
                    case ACTION:
                        attach((Action) object, challenge);
                        break;
                    default:
                        System.err.println("challenge " + challenge.getID()
                                + " mismatched with " + object.getID());
                }
            }
        } else if (newObject.getType() == ACEType.CONDITIONAL) {
            Conditional conditional = (Conditional) newObject.getObject();
            for (ACEScaffold scaffold : list) {
                ACEObject object = scaffold.getObject();
                switch (scaffold.getType()) {
                    case ACTION:
                        attach((Action) object, conditional);
                        break;
                    case CHOICE:
                        attach((Choice) object, conditional);
                        break;
                    default:
                        System.err.println("conditional " + conditional.getID()
                                + " mismatched with " + object.getID());
                }
            }
        }
        loadMap.remove(newObject.getId());
    }

    public boolean loadedProperly() {
        return loadMap.isEmpty();
    }

    public Event loadDB() throws SQLException {
        Event root = null;
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
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
            throw new RuntimeException("Not everything was removed from the hash"
                    + " map. Please use the debugger.");
        }
        
        return root;
    }

}
