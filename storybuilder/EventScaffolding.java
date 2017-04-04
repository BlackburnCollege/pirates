package storybuilder;

import gui.Music;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import static storybuilder.ACEObjectScaffolding.getDatabase;
import world.ACEObject;
import world.Event;

/**
 *
 * @author lucas.burdell
 */
public class EventScaffolding extends ACEObjectScaffolding<Event> {

    public EventScaffolding() {
        super("Event", new Event("text"));
    }

    public EventScaffolding(Event event) {
        super("Event", event);
    }

    public EventScaffolding(int id) {
        super("Event", new Event("text"));
        

    }
    
    
    @Override
    public void loadFromID(int id) throws SQLException {
        if (!ACEObjectScaffolding.existsInDatabase("Event", id)) {
            return;
        }
        PreparedStatement check = getDatabase().prepareStatement("SELECT * FROM event"
                + " WHERE id=?");
        check.setInt(0, id);
        ResultSet set = check.executeQuery();
        if (set.isBeforeFirst()) {
            set.next();
            Event newEvent = new Event(id);
            newEvent.setText(set.getString("text"));
            if (set.getString("background") != null) {
                newEvent.setPicture(set.getString("background"));
            }
            if (set.getString("music") != null) {
                newEvent.setMusic(Music.valueOf(set.getString("music")));
            }
            this.setObject(newEvent);
        }
    }

    @Override
    public void saveToDatabase() throws SQLException {
        /*
        CREATE TABLE event (
            id INTEGER NOT NULL Primary Key,
            text varchar(64) not null,
            backgroundname varchar(64),
            music varchar(64)
        );        
         */
        Event object = this.getObject();
        int id = object.getID();
        String text = object.getText();
        String background = object.getPicture();
        String music = object.getMusic().toString();

        PreparedStatement update = getDatabase().prepareStatement(
                "UPDATE EVENT SET text=?, backgroundname=?, music=? WHERE id=?"
        );

        PreparedStatement insert = getDatabase().prepareStatement(""
                + "INSERT INTO EVENT(id, text, backgroundname, music) "
                + "VALUES (?, ?, ?, ?)");

        insert.setInt(0, object.getID());
        update.setInt(3, id);

        update.setString(0, text);
        insert.setString(1, object.getText());

        if (background == null || background.equals("")) {
            update.setNull(1, Types.VARCHAR);
            insert.setNull(2, Types.VARCHAR);
        } else {
            update.setString(1, background);
            insert.setString(2, background);
        }

        if (music == null || music.equals("")) {
            update.setNull(2, Types.VARCHAR);
            insert.setNull(3, Types.VARCHAR);
        } else {
            update.setString(2, music);
            insert.setString(3, music);
        }

        if (this.existsInDatabase()) {
            update.execute();
        } else {
            insert.execute();
        }
    }

    @Override
    public void addConnection(ACEObjectScaffolding scaffolding) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeConnection(ACEObjectScaffolding scaffolding) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ACEObjectScaffolding[] getConnections() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
