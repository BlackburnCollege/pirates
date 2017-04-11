package sql;

import gui.Music;
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

            // check conditionals 
            /*
            statement = connection.prepareStatement("SELECT * FROM "
                    + "conditional WHERE attachedid=?");
            statement.setInt(1, event.getId());
            set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("id");
                if (id > event.getId()) {
                    addNeededId(event, id);
                }
            }
             */
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
            ResultSet events = statement.executeQuery();
            if (events.isBeforeFirst()) {
                object.setText(events.getString("text"));
            } else {
                throw new RuntimeException("Event with id " + id + " not found "
                        + "in event table");
            }
            ACEScaffold<Action> scaffold = new ACEScaffold<>(object, ACEType.EVENT);
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
                }
            }
        }
    }

    private void handleNeededIds(ACEScaffold object) {
        switch (object.getType()) {
            case EVENT:
                handleEventNeededIds(object);
                break;
        }
    }

    public ArrayList<ACEObject> loadDB() throws SQLException {
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
                    break;
                default:
                    continue;
            }
            handleNeededIds(scaffold);
        }

        //return all;
        return null;
    }

}
