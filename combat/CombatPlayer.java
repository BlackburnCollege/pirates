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
    
    public String getMove(int damage) {
        String move = super.getName() + " attacked for " + damage;
        return move;
    }
}
