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
        int randChoice = randnum.nextInt(3);
        Move move = Move.values()[randChoice];
        String output = "";
        
        if(this.decrementStatusCounter()){
            this.resetMultis();
        }
        
        
            switch(move){
                case ATTACK:
                    if(this.currentMeleeMulti > 0){
                        choice = new Melee(this.currentMeleeMulti);
                        action = " attacked ";
                    }   
                    break;
                case SHOOT:
                    if(this.currentRangedMulti > 0){
                        choice = new Ranged(this.currentRangedMulti);
                        action = " shot ";
                    }
                    break;
                case INSULT:
                    if(this.currentVerbalMulti > 0){
                        choice = new Verbal(this.currentVerbalMulti);
                        action = " insulted ";
                    }
                    break;
            }
//            if(choice == null){
//                randChoice = (randChoice + 1) ;
//                move = Move.values()[randChoice];
//            }
        
        
        if (choice != null){
            output = choice.affect(entity);
            return output + this.getName() + action + entity.getName();
        }
        else {
            return this.getName() + " missed";
        }
        
    }
}
