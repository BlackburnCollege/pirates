/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

import java.util.Random;

/**
 *
 * @author arthur.levan
 */
public class Enemy extends Entity {

    public Enemy(String name, int maxHealth, double meleeMulti, double rangedMulti, double verbalMulti) {
        super(name, maxHealth, meleeMulti, rangedMulti, verbalMulti);
    }
    
    public String getMove(Entity entity) {
        Random randnum = new Random();
        String action = "";
        Action choice = null;
        Move move = Move.values()[randnum.nextInt(3)];
        
        switch(move){
            case ATTACK:
                if(this.meleeMulti > 0){
                    choice = new Melee(this.meleeMulti);
                    action = " attacked ";
                }
                break;
            case SHOOT:
                if(this.rangedMulti > 0){
                    choice = new Ranged(this.rangedMulti);
                    action = " shot ";
                }
                break;
            case INSULT:
                if(this.verbalMulti > 0){
                    choice = new Verbal(this.verbalMulti);
                    action = " insulted ";
                }
                break;
        }
        choice.affect(entity);
        return this.getName() + action + entity.getName();
    }
}
