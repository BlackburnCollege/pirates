package storybuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import javafx.scene.layout.Pane;
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

    @Override
    public PreparedStatement generateSQLInsert(Connection database) throws SQLException {
        /*
        CREATE TABLE event (
            id INTEGER NOT NULL Primary Key,
            text varchar(64) not null,
            backgroundname varchar(64),
            music varchar(64)
        );        
         */
        Event object = this.getObject();
        PreparedStatement ps = database.prepareStatement(""
                + "INSERT INTO EVENT(id, text, backgroundname, music) "
                + "VALUES (?, ?, ?, ?)");
        int id = object.getID();
        String text = object.getText();
        String background = object.getPicture();
        String music = object.getMusic().toString();
        ps.setInt(0, object.getID());
        ps.setString(1, object.getText());
        if (background == null || background.equals("")) {
            ps.setNull(2, Types.VARCHAR);
        } else { 
            ps.setString(2, background);
        }
        
        if (music == null || music.equals("")) {
            ps.setNull(3, Types.VARCHAR);
        } else { 
            ps.setString(3, music);
        }
        
        return ps;
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
    public PreparedStatement generateSQLRetrieve(Connection database) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
