package storybuilder;

import gui.Music;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javafx.scene.layout.Pane;
import static storybuilder.ACEObjectScaffolding.getDatabase;
import world.ACEObject;
import world.Action;
import world.Event;

/**
 *
 * @author lucas.burdell
 */
public class ActionScaffolding extends ACEObjectScaffolding<Action> {

    public ActionScaffolding() {
        super("Action", new Action("text"));
    }

    public ActionScaffolding(Action action) {
        super("Action", action);
    }

    @Override
    public void saveToDatabase() throws SQLException {
        /*
        CREATE TABLE actions (
            id integer not null primary key,
            text varchar(512),
            eventid integer not null
        );
         */

        Action object = this.getObject();
        int id = object.getID();
        String text = object.getText();
        int eventid = -1;
        if (this.getConnections()[0] != null) {
            eventid = this.getConnections()[0].getObject().getID();
        }

        PreparedStatement update = getDatabase().prepareStatement(
                "UPDATE actions SET text=?, eventid=? WHERE id=?"
        );

        PreparedStatement insert = getDatabase().prepareStatement(""
                + "INSERT INTO actions(id, text, eventid) "
                + "VALUES (?, ?, ?)");

        insert.setInt(1, object.getID());
        update.setInt(3, id);

        update.setString(1, text);
        insert.setString(2, object.getText());

        if (eventid == -1) {
            update.setNull(2, Types.INTEGER);
            insert.setNull(3, Types.INTEGER);
        } else {
            update.setInt(2, eventid);
            insert.setInt(3, eventid);
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

    @Override
    public void loadFromID(int id) throws SQLException {
        if (!ACEObjectScaffolding.existsInDatabase("Action", id)) {
            return;
        }
        PreparedStatement check = getDatabase().prepareStatement("SELECT * FROM actions"
                + " WHERE id=?");
        check.setInt(1, id);
        ResultSet set = check.executeQuery();
        if (set.isBeforeFirst()) {
            set.next();
            Action newAction = new Action(id);
            newAction.setText(set.getString("text"));
            if (set.getInt("eventid") != 0) {
                // TODO LOAD CONNECTIONS
            }
            this.setObject(newAction);
        }
    }

}
