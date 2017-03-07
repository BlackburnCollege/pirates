package world;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lucas.burdell
 */
public class Action {
    private Event[] events;
    private String text;
    private Challenge challenge = null;
    private ArrayList<Modifier> modifiers = new ArrayList<>();
    
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
        return this.getEvents()[0];
    }
    
    /**
     * 
     * @return the default event index
     */
    public int getDefaultEventIndex() {
        return 0;
    }

    /**
     * @param event the Event to set
     * @return 
     */
    public Action addEvent(Event event) {
        Event[] temp = new Event[this.getEvents().length + 1];
        System.arraycopy(this.getEvents(), 0, temp, 0, getEvents().length);
        temp[temp.length - 1] = event;
        this.events = temp;
        return this;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     * @return 
     */
    public Action setText(String text) {
        this.text = text;
        return this;
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
     * @return 
     */
    public Action setChallenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }

    /**
     * @return the events
     */
    public Event[] getEvents() {
        return events;
    }
    
    
        /**
     * @return the conditions
     */
    public Modifier[] getModifiers() {
        return modifiers.toArray(new Modifier[1]);
    }

    /**
     * @param modifiers
     * @return
     */
    public Action setModifiers(Modifier[] modifiers) {
        this.modifiers = new ArrayList<>(Arrays.asList(modifiers));
        return this;
    }

    public Action addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
        return this;
    }

    
    
    
}
