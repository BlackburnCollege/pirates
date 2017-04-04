package storybuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import sql.SQLDatabaseManager;
import world.ACEObject;

/**
 *
 * @author lucas.burdell
 * @param <T>
 */
public abstract class ACEObjectScaffolding<T extends ACEObject> {

    /**
     * @return the manager
     */
    public static SQLDatabaseManager getManager() {
        return manager;
    }

    /**
     * @param aManager the manager to set
     */
    public static void setManager(SQLDatabaseManager aManager) {
        manager = aManager;
        database = manager.getConnection();
    }

    /**
     * @return the database
     */
    public static Connection getDatabase() {
        return database;
    }

    /**
     * @return the objects
     */
    public static ArrayList<ACEObjectScaffolding> getObjects() {
        return objects;
    }

    private T object;
    private Pane symbol;
    private String type;
    private final ArrayList<ACEObjectScaffolding> connections = new ArrayList<>();
    private static final ArrayList<ACEObjectScaffolding> objects = new ArrayList<>();

    private static SQLDatabaseManager manager;
    private static Connection database;

    public ACEObjectScaffolding(String type, T object) {
        this.object = object;
        this.type = type;
        this.symbol = buildGUI(type);
        objects.add(this);
    }

    public ACEObjectScaffolding(String type, Pane symbol, T object) {
        this.object = object;
        this.type = type;
        this.symbol = symbol;
        objects.add(this);
    }

    abstract public void loadFromID(int id) throws SQLException;

    /**
     *
     * @throws SQLException
     */
    abstract public void saveToDatabase() throws SQLException;

    public static boolean existsInDatabase(String type, int id) throws SQLException {
        PreparedStatement check = getDatabase().prepareStatement("SELECT * FROM aceobject"
                + "WHERE id=?");
        check.setInt(1, id);
        ResultSet set = check.executeQuery();
        if (set.isBeforeFirst()) {
            set.next();
            String objectType = set.getString("acetype");
            if (objectType.equalsIgnoreCase(type)) {
                return true;
            } else {
                throw new RuntimeException(type + " with id "
                        + id
                        + " does not match with database aceobject of same "
                        + "id with type " + objectType);
            }
        }
        return false;
    }

    public boolean existsInDatabase() throws SQLException {
        PreparedStatement check = getDatabase().prepareStatement("SELECT * FROM aceobject"
                + "WHERE id=?");
        check.setInt(1, this.object.getID());
        ResultSet set = check.executeQuery();
        if (set.isBeforeFirst()) {
            set.next();
            String objectType = set.getString("acetype");
            if (objectType.equalsIgnoreCase(this.type)) {
                return true;
            } else {
                throw new RuntimeException(this.type + " with id "
                        + this.getObject().getID()
                        + " does not match with database aceobject of same "
                        + "id with type " + objectType);
            }
        }
        return false;
    }

    /**
     * @return the object
     */
    public T getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(T object) {
        this.object = object;
    }

    /**
     * @return the symbol
     */
    public Pane getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(Pane symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the connections
     */
    public abstract ACEObjectScaffolding[] getConnections();

    public abstract void addConnection(ACEObjectScaffolding scaffolding);

    public abstract void removeConnection(ACEObjectScaffolding scaffolding);

    public final Pane buildGUI(String name) {
        try {
            Pane choice = (Pane) FXMLLoader.load(
                    ACEObjectScaffolding.class.getResource(
                            "/storybuilder/" + name + ".fxml"));
            return choice;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
