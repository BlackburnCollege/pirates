package sql;

import gui.Music;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private ArrayList<ACEObject> all = new ArrayList<>();
    private ArrayList<ACEObject> unfinished = new ArrayList<>();

    public ArrayList<ACEObject> loadDB() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM "
                + "aceobject", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            int id = set.getInt("id");
            String acetype = set.getString("acetype");
            acetype = acetype.toLowerCase();
            if (acetype.equals("event")) {
                Event object = new Event(id);
                statement = connection.prepareStatement("SELECT * FROM "
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

            }
        }
        return all;
    }

    private boolean attachToObject(Choice choice, int eventId, int actionId) {
        int finishedCount = 0;
        for (ACEObject object : unfinished) {
            if (object instanceof Event && object.getID() == eventId) {
                Event event = (Event) object;
                event.addChoice(choice);
                finishedCount++;
            } else if (object instanceof Action && object.getID() == actionId) {
                Action action = (Action) object;
                choice.setAction(action);
                finishedCount++;
            }
        }
        return finishedCount == 2;
    }

    private <T extends ACEObject> boolean
            arrayContains(T[] objects, T toLook) {
        for (T object : objects) {
            if (object.equals(toLook)) {
                return true;
            }
        }
        return false;
    }

    private boolean attachToObject(Action action, int eventId) {
        for (ACEObject object : unfinished) {
            if (object instanceof Event && object.getID() == eventId) {
                Event event = (Event) object;
                if (!arrayContains(action.getEvents(), event)) {
                    action.addEvent((Event) object);
                }
                return true;
            }
        }
        return false;
    }

}
