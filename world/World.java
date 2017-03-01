package world;

import gui.Music;
import java.util.HashMap;

/**
 *
 * @author lucas.burdell
 */
public class World {

    
    // current story state of the game
    private Event currentEvent;

    // Player object for story. Currently only contains inventory and a name
    private Player player;
    
    
    /* 
    NAMING SCHEME FOR EVENTS:
    island-initials_location_visit-type_event-identifier
    
    island-initials: three letter initials for the island names
    location: the location on the island or in an event chain
    visit-type: type of visit to this event; i.e. f for first time, r for returning, ae for after event or after an event
    event-identifier: identifier for the event; arbitrary name to refer to event
    */
    // HashMap that tracks events using an event's name as the key.
    private HashMap<String, Event> events = new HashMap<>();

    
    public World(String playerName) {
        this.player = new Player(playerName);
        //opening event, after convo, fish puzzle, wolf combat, closing event

        
        // Initialize events with the event text
        this.events.put("tut_home_f_opening_family", new Event("As you walk down stairs you are"
                + " greeted by you wife, Marjory, and you son, " + playerName + 
                " jr. \"Hello " + playerName + ",\" Marjory says."));
        
        this.events.put("tut_home_r_stairs", new Event("You are back at the stairs."));
        
        this.events.put("tut_home_f_outside", new Event("You walk outside, "
                + "down to the docks. You get on your boat and go fishing."));
        
        this.events.put("tut_pier_f_fishingpuzzle", new Event("This is a fishing puzzle."));
        
        this.events.put("tut_home_ae_fishing", new Event("As you walk home the smell of fish"
                + " attracts a wolf. Kill it. Defend your honor."));
        
        this.events.put("tut_home_ae_wolfcombat", new Event("You made it home!"));
        
        //Add choices and set settings to each event
        this.events.get("tut_home_f_opening_family")
                .setMusic(Music.LIVING_VOYAGE)
                .addChoice("Hello Person",
                    new Action(events.get("tut_home_f_outside"), "\"Hello Person,\" "
                            + "you greet your wife. You are a fully operational "
                            + "human being, and definitely not a robot."))
                .addChoice("Wassup dude.", 
                new Action(events.get("tut_home_f_outside"), "\"Wassup dude.\" "
                        + "Really?"));
        
        this.events.get("tut_home_f_outside").addChoice("next", 
                new Action(events.get("tut_pier_f_fishingpuzzle"), "You leave to catch some fish."));
        
        this.events.get("tut_pier_f_fishingpuzzle").addChoice("next", 
                new Action(events.get("tut_home_ae_fishing"), "catching fish.",
                        new Challenge("puzzle", "fish")));
        
        this.events.get("tut_home_ae_fishing").addChoice("next", 
                new Action(events.get("tut_home_ae_wolfcombat"), "You have killed the wolf. Yay.",
                        new Challenge("combat", "wolf"))).setMusic(Music.THE_BUILDER);
        
        this.events.get("tut_home_ae_wolfcombat").addChoice("next", 
                new Action(events.get("tut_home_f_opening_family"), "Its groundhogs day up in here"));
        
        this.currentEvent = events.get("tut_home_f_opening_family");
        
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
}
