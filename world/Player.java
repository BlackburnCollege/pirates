package world;

import java.util.ArrayList;

/**
 *
 * @author lucas.burdell
 */
public class Player {

    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();
    private boolean male;
    private boolean spouseMale;

    public Player(String name) {
        this.name = name;
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
     * @return the male
     */
    public boolean isMale() {
        return male;
    }

    /**
     * @param male the male to set
     */
    public void setMale(boolean male) {
        this.male = male;
    }

    /**
     * @return the spouseMale
     */
    public boolean isSpouseMale() {
        return spouseMale;
    }

    /**
     * @param spouseMale the spouseMale to set
     */
    public void setSpouseMale(boolean spouseMale) {
        this.spouseMale = spouseMale;
    }

    public String getSpouseName() {
        if (this.isSpouseMale()) {
            return "Margery";
        } else {
            return "Mathias";
        }
    }

    public String getSpousePronoun() {
        if (this.isSpouseMale()) {
            return "she";
        } else {
            return "he";
        }
    }

    public String getSpouseMaritalTitle() {
        if (this.isSpouseMale()) {
            return "wife";
        } else {
            return "husband";
        }
    }
    
    public String getPronoun() {
        if (this.isMale()) {
            return "he";
        } else {
            return "she";
        }
    }

}
