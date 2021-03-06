/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat;

/**
 *
 * @author arthur.levan
 */
public class CombatPlayer extends Entity{
    CombatPlayer(String name, int maxHealth, double meleeMulti, double rangedMulti, double verbalMulti, boolean verbalImmunity){
        super(name, maxHealth, meleeMulti, rangedMulti, verbalMulti, verbalImmunity);
    }
    
    public String getMove(Move move, Entity entity) {
        String action = "";
        Action choice = null;
        
        if(this.decrementStatusCounter()){
            this.resetMultis();
        }
        
        switch(move){
            case ATTACK:
                choice = new Melee(this.currentMeleeMulti);
                action = " attacked ";
                break;
            case SHOOT:
                choice = new Ranged(this.currentRangedMulti);
                action = " shot ";
                break;
            case INSULT:
                choice = new Verbal(this.currentVerbalMulti);
                action = " insulted ";
                break;
        }
        String output = choice.affect(entity);
        return output + this.getName() + action + entity.getName();
    }
}
