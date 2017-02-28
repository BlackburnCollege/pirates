package world;

/**
 *
 * @author lucas.burdell
 */
public class Item {
    private String name;
    private boolean equipped;
    private boolean stacked;
    private int quantity = 1;
    
    
    public Item(String name) {
        this(name, false, false, 1);
    }
    
    public Item(String name, boolean equipped) {
        this(name, equipped, false, 1);
    }
    
    public Item(String name, boolean equipped, boolean stacked) {
        this(name, equipped, stacked, 1);
    }
    
    public Item(String name, boolean equipped, boolean stacked, int quantity) {
        this.name = name;
        this.equipped = equipped;
        this.stacked = stacked;
        this.quantity = quantity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @return 
     */
    public Item setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return the equipped
     */
    public boolean isEquipped() {
        return equipped;
    }

    /**
     * @param equipped the equipped to set
     * @return 
     */
    public Item setEquipped(boolean equipped) {
        this.equipped = equipped;
        return this;
    }

    /**
     * @return the stacked
     */
    public boolean isStacked() {
        return stacked;
    }

    /**
     * @param stacked the stacked to set
     * @return 
     */
    public Item setStacked(boolean stacked) {
        this.stacked = stacked;
        return this;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     * @return 
     */
    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
