package world;

/**
 *
 * @author lucas.burdell
 */
public class Action {
    private Event[] events;
    private String text;
    private Challenge challenge = null;
    
    public Action() {
        this.events = null;
    }
    
    public Action(Event event) {
        this.events = new Event[]{event};
    }
    
    public Action(Event event, String text) {
        this.events = new Event[]{event};
        this.text = text;
    }
    
    public Action(Event event, String text, Challenge challenge) {
        this.events = new Event[]{event};
        this.text = text;
        this.challenge = challenge;
    }
    
    public Action(String text) {
        this.text = text;
    }

    /**
     * @return the Event
     */
    public Event getDefaultEvent() {
        return this.events[0];
    }

    /**
     * @param event the Event to set
     */
    public void addEvent(Event event) {
        Event[] temp = new Event[this.events.length + 1];
        System.arraycopy(this.events, 0, temp, 0, events.length);
        temp[temp.length - 1] = event;
        this.events = temp;
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

    /**
     * 
     * @return true if there is a challenge present
     */
    public boolean hasChallenge() {
        return challenge != null;
    }
    
    /**
     * @return the challenge
     */
    public Challenge getChallenge() {
        return challenge;
    }

    /**
     * @param challenge the challenge to set
     */
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
    
    
    
    
}
