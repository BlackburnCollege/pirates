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
    final double maxMeleeMulti;
    final double maxRangedMulti;
    final double maxVerbalMulti;
    double currentMeleeMulti;
    double currentRangedMulti;
    double currentVerbalMulti;

    public Entity(String name, int maxHealth, double meleeMulti, double rangedMulti, double verbalMulti) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
        this.maxMeleeMulti = meleeMulti;
        this.maxRangedMulti = rangedMulti;
        this.maxVerbalMulti = verbalMulti;
        this.currentMeleeMulti = this.maxMeleeMulti;
        this.currentRangedMulti = this.maxRangedMulti;
        this.currentVerbalMulti = this.maxVerbalMulti;
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
    
    public void decreaseMeleeMulti(){
        this.currentMeleeMulti = 0;
        this.statusCounter = 3;
    }
    public void decreaseRangedMulti (){
        this.currentRangedMulti = 0;
        this.statusCounter = 3;
    }
    public void decreaseVerbalMulti (){
        this.currentVerbalMulti = 0;
        this.statusCounter = 3;
    }
    
    public void resetMultis (){
        if(this.currentMeleeMulti != this.maxMeleeMulti){
            this.currentMeleeMulti = this.maxMeleeMulti;
        }
        if(this.currentRangedMulti != this.maxRangedMulti){
            this.currentRangedMulti = this.maxRangedMulti;
        }
        if(this.currentVerbalMulti != this.maxVerbalMulti){
            this.currentVerbalMulti = this.maxVerbalMulti;
        }
    }
    
    public boolean decrementStatusCounter(){
        if (this.statusCounter != 0){
            this.statusCounter--;
        }
        return (this.statusCounter == 0);
    }
}
