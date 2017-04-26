package world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author lucas.burdell
 */
public class Action extends ACEObject {

    private Event[] events = new Event[15];

    private String text;
    private Challenge challenge = null;
    private Conditional[] modifiers = new Conditional[15];

    public Action(int id) {
        super(id);
    }

    public Action() {
        super();
        //this.events = null;
    }

    public Action(Event event) {
        super();
        //this.events = new ArrayList<>();
    }

    public Action(String text, Challenge challenge) {
        super();
        //this.events = new ArrayList<>();
        this.text = text;
    }

    public Action(Event event, String text) {
        super();
        //this.events = new ArrayList<>();
        this.events[0] = event;
        this.text = text;
    }

    public Action(Event event, String text, Challenge challenge) {
        super();
        // this.events = new ArrayList<>();
        this.events[0] = event;
        this.text = text;
        this.challenge = challenge;
    }

    public Action(String text) {
        super();
        this.text = text;
    }

    public Action(Challenge challenge) {
        super();
        this.challenge = challenge;
        //this.events = new ArrayList<>();
        this.text = null;
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
        for (int i = 0; i < events.length; i++) {
            Event event1 = events[i];
            if (event1 == null) {
                events[i] = event;
            }
        }
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
    public Conditional[] getConditionals() {
        return modifiers;
    }

    /**
     * @param modifiers
     * @return
     */
    public Action setConditionals(Conditional[] modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public Action addConditional(Conditional modifier) {
        for (int i = 0; i < modifiers.length; i++) {
            Conditional modifier1 = modifiers[i];
            if (modifier1 == null) {
                modifiers[i] = modifier;
            }
        }
        return this;
    }

    public void doConditionalModifiers(HashMap<String, Integer> flags) {
        for (Conditional c : this.modifiers) {
            if (c == null) {
                break;
            }
            c.setCondition(flags);
        }
    }

    public void setEvent(Event event, int position) {
        this.events[position] = event;
    }

}
