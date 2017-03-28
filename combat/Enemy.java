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

    public Enemy(String name, int maxHealth) {
        super(name, maxHealth);
    }
    
    public String getMove(Entity entity) {
        Random randnum = new Random();
        String action = "";
        Action choice = null;
        Move move = Move.values()[randnum.nextInt(3)];
        
        switch(move){
            case ATTACK:
                choice = new Melee();
                action = " attacked ";
                break;
            case SHOOT:
                choice = new Ranged();
                action = " shot ";
                break;
            case INSULT:
                choice = new Verbal();
                action = " insulted ";
                break;
        }
        choice.affect(entity);
        return this.getName() + action + entity.getName();
    }
}
