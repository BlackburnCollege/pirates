package world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author lucas.burdell
 */
public class Action extends ACEObject {

    private ArrayList<Event> events = new ArrayList<>(5);

    {
        for (int i = 0; i < 5; i++) {
            events.add(null);
        }
    }
    private String text;
    private Challenge challenge = null;
    private ArrayList<Conditional> modifiers = new ArrayList<>(5);

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
        this.events.add(event);
        this.text = text;
    }

    public Action(Event event, String text, Challenge challenge) {
        super();
        // this.events = new ArrayList<>();
        this.events.add(event);
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
        this.events.add(event);
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
        return events.toArray(new Event[events.size()]);
    }

    /**
     * @return the conditions
     */
    public Conditional[] getConditionals() {
        return modifiers.toArray(new Conditional[modifiers.size()]);
    }

    /**
     * @param modifiers
     * @return
     */
    public Action setConditionals(Conditional[] modifiers) {
        this.modifiers = new ArrayList<>(Arrays.asList(modifiers));
        return this;
    }

    public Action addConditional(Conditional modifier) {
        this.modifiers.add(modifier);
        return this;
    }

    public void doConditionalModifiers(HashMap<String, Integer> flags) {
        System.out.println("Doing modifiers for action " + this.getID());
        for (Conditional c : this.modifiers) {
            System.out.println("Setting condition for condition " + c.getID());
            c.setCondition(flags);
        }
    }

    public void setEvent(Event event, int position) {
        if (events.size() >= position) {
            this.events.add(position, event);
        } else {
            this.events.set(position, event);
        }
    }

}
