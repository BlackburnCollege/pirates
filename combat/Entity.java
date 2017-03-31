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
public class Entity {

    private int currentHealth;
    private final int maxHealth;
    private String name;
    private int statusCounter=0;
    double meleeMulti;
    double rangedMulti;
    double verbalMulti;

    public Entity(String name, int maxHealth, double meleeMulti, double rangedMulti, double verbalMulti) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
        this.meleeMulti = meleeMulti;
        this.rangedMulti = rangedMulti;
        this.verbalMulti = verbalMulti;
    }


    public void decreaseHealth(int damage) {
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
    
    public String getName() {
        return name;
    }
    

}
