package world;

import java.util.HashMap;

/**
 *
 * @author lucas.burdell
 */
public class World {

    private static World singletonWorld = new World();

    public static World get() {
        return singletonWorld;
    }

    private Player player;
    private Location[] locations = new Location[8];
    private HashMap<String, Event> events = new HashMap<>();

    private World() {
        
        
    }

    public Event getEvent(String eventName) {
        return events.get(eventName);
    }

    public Player getPlayer() {
        return player;
    }
}
