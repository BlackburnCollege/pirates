package world;

import gui.Music;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.StorySQLLoader;

/**
 *
 * @author lucas.burdell
 */
public class World {

    // current story state of the game
    private Event currentEvent;

    // Player object for story. Currently only contains inventory and a name
    private Player player;
    private String shipName;

    // HashMap that tracks events using an event's name as the key.
    private HashMap<String, Event> events = new HashMap<>();
    private HashMap<String, Integer> storyFlags = new HashMap<>();

    public World(String playerName) {
        this.player = new Player(playerName);
        StorySQLLoader loader = new StorySQLLoader();
        try {
            this.currentEvent = loader.loadDB();
        } catch (SQLException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public World(Player player, Event root) {
        this.player = player;
        this.currentEvent = root;
    }


    /**
     *
     * @param eventName name of event to retrieve
     * @return the event
     */
    public Event getEvent(String eventName) {
        return events.get(eventName);
    }

    /**
     *
     * @return the Player of the world
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the currentEvent
     */
    public Event getCurrentEvent() {
        return currentEvent;
    }

    /**
     * @param currentEvent the currentEvent to set
     */
    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    /**
     * @return the storyFlags
     */
    public HashMap<String, Integer> getStoryFlags() {
        return storyFlags;
    }

    /**
     * @return the shipName
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * @param shipName the shipName to set
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getFlag(String flagName) {
        return this.storyFlags.getOrDefault(flagName, 0);
    }

    public void setFlag(String flagName, int value) {
        this.storyFlags.put(flagName, value);
    }
}
