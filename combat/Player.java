/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import java.util.ArrayList;
import world.Item;

/**
 *
 * @author arthur.levan
 */
public class Player {

    private double currentHealth = 1.0;
    private double maxHealth = 1.0;
    private boolean meleeProf = false;
    private boolean gunProf = false;
    private boolean insultProf = false;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    /*
    * Sets the proficiency level of a given skill.
     */
    public void setProf(Proficiency profName, boolean value) {
        switch (profName) {
            case MELEE:
                meleeProf = value;
                break;
            case GUN:
                gunProf = value;
                break;
            case INSULT:
                insultProf = value;
                break;
        }
    }

    public void decreaseHealth(double damage) {
        currentHealth -= damage;
    }

    /*
    * Returns the current health of the Player
     */
    public double getHealth() {
        return currentHealth;
    }

    public int intHealth() {
        return (int) (100 * currentHealth);
    }

    /*
     * Resets player health back to full.
     */
    public void resetHealth() {
        currentHealth = maxHealth;
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

    public String getName() {
        return name;
    }

}
