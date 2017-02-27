package world;

/**
 *
 * @author lucas.burdell
 */
public class Action {
    private Event event;
    private String text;
    
    public Action() {
        this.event = null;
    }
    
    public Action(Event event) {
        this.event = event;
    }
    
    public Action(Event event, String text) {
        this.event = event;
        this.text = text;
    }
    
    public Action(String text) {
        this.text = text;
    }

    /**
     * @return the Event
     */
    public Event getEvent() {
        return this.event;
    }

    /**
     * @param event the Event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
    
    
    
}
