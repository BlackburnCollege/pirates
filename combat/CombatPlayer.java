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
    CombatPlayer(String name, int maxHealth){
        super(name,maxHealth);
    }
    
    public String getMove(Move move, Entity entity) {
        String action = "";
        Action choice = null;
        
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
