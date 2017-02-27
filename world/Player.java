package world;

import java.util.ArrayList;

/**
 *
 * @author lucas.burdell
 */
public class Player {
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Event currentEvent;
    
    public Player(Event event) {
        this.currentEvent = event;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    /**
     * @return the inventory
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(ArrayList<Item> inventory) {
        if (inventory != null) {
            this.inventory = inventory;
        }
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
        if (currentEvent != null) {
            this.currentEvent = currentEvent;
        }
    }
}
