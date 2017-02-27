package world;

import gui.Music;
import java.util.HashMap;

/**
 *
 * @author lucas.burdell
 */
public class World {

    private Event currentEvent;

    private Player player;
    private HashMap<String, Event> events = new HashMap<>();

    public World(String playerName) {
        Player user = new Player(playerName);
        //opening event, after convo, fish puzzle, wolf combat, closing event
        events.put("Opening Event", new Event("As you walk down stairs you are"
                + "greeted by you wife, Marjory, and you son, " + playerName + 
                " jr. \"Hello person,\" Marjory says."));
        
        events.put("After Conversation", new Event("You walk outside, "
                + "down to the docks. You get on your boat and go fishing."));
        
        events.put("Fishing Puzzle", new Event("This is a fishing puzzle."));
        
        events.put("Wolf Combat", new Event("As you walk home the smell of fish"
                + "attracts a wolf. Kill it. Defend your honor."));
        
        events.put("Closing Event", new Event("You have killed the wolf. Yay."));
        
        
        
        events.get("Opening Event").addChoice("Hello Person",
                new Action(events.get("After Conversation"), "Hello Person"))
                .setMusic(Music.LIVING_VOYAGE);
        
        events.get("Opening Event").addChoice("Wassup dude.", 
                new Action(events.get("After Conversation"), "Wassup dude"));
        
        events.get("After Conversation").addChoice("next", 
                new Action(events.get("Fishing Puzzle"), "time to catch some fish"));
        
        events.get("Fishing Puzzle").addChoice("next", 
                new Action(events.get("Wolf Combat"), "catching fish.",
                        new Challenge("puzzle", "fish puzzle")));
        
        events.get("Wolf Combat").addChoice("next", 
                new Action(events.get("Closing Event"), "You finally make it home.",
                        new Challenge("combat", "wolf combat"))).setMusic(Music.THE_BUILDER);
        
        events.get("Closing Event").addChoice("next", 
                new Action(events.get("Opening Event"), "Its groundhogs day up in here"));
        
        this.currentEvent = events.get("Opening Event");
        
    }

    public Event getEvent(String eventName) {
        return events.get(eventName);
    }
    
    

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
}
