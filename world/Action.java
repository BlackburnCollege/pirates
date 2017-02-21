package world;

/**
 *
 * @author lucas.burdell
 */
public class Action {
    private Event newEvent;
    
    public Action() {
        this.newEvent = null;
    }
    
    public Action(Event newEvent) {
        this.newEvent = newEvent;
    }

    /**
     * @return the newEvent
     */
    public Event getEvent() {
        return newEvent;
    }
    
    
    
    
}
