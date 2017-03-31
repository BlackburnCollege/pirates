package storybuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import world.ACEObject;

/**
 *
 * @author lucas.burdell
 * @param <T>
 */
public abstract class ACEObjectScaffolding<T extends ACEObject> {

    private T object;
    private Pane symbol;
    private final ArrayList<ACEObjectScaffolding> connections = new ArrayList<>();

    public ACEObjectScaffolding(String type, T object) {
        this.object = object;
        this.symbol = buildGUI(type);
    }
    
    public ACEObjectScaffolding(Pane symbol, T object) {
        this.object = object;
        this.symbol = symbol;
    }

    abstract public PreparedStatement generateSQLInsert(Connection database) throws SQLException;
    
    abstract public PreparedStatement generateSQLRetrieve(Connection database) throws SQLException;

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
    public ACEObjectScaffolding[] getConnections() {
        return connections.toArray(new ACEObjectScaffolding[connections.size()]);
    }

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
    
    protected ArrayList<ACEObjectScaffolding> getConnectionList() {
        return connections;
    }

}
