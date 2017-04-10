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
import world.Choice;
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
        private final ArrayList<Integer> neededIds = new ArrayList<>();

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

        /**
         * @return the neededIds
         */
        public ArrayList<Integer> getNeededIds() {
            return neededIds;
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
    
    private void loadEventNeededIds(ACEScaffold<Event> event) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                    + "actionsevent WHERE eventid=?");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StorySQLLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadNeededIds(ACEScaffold event) {
        switch (event.getType()) {
            case EVENT:
                loadEventNeededIds(event);
                break;
        }
    }

    public ArrayList<ACEObject> loadDB() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                + "aceobject", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            int id = set.getInt("id");
            String acetype = set.getString("acetype");
            acetype = acetype.toLowerCase();
            ACEScaffold scaffold;
            switch(acetype) {
                case "event":
                    scaffold = loadEvent(id);
                    break;
                default:
                    continue;
            }
            loadNeededIds(scaffold);
        }
        
        
        //return all;
        return null;
    }

}
