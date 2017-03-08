/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import java.util.ArrayList;
import java.util.Random;
import world.Item;

/**
 *
 * @author arthur.levan
 */
public class Player {

    private int currentHealth;
    private final int maxHealth;
    private boolean meleeProf = false;
    private boolean gunProf = false;
    private boolean insultProf = false;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int damage;

    public Player(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
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
    public int getCurrentHealth() {
        return this.currentHealth;
    }
    public int getMaxHealth(){
        return this.maxHealth;
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
        return this.inventory;
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
    
    public int getDamage() {
        Random rand = new Random();
        this.damage = 0 + rand.nextInt(20 - 0 + 1);
        return this.damage;
    }

    public String getMove(int damage) {
        String move = name + " attacked for " + damage;
        return move;
    }

}
