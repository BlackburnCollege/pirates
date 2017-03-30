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
public class Melee implements Action{
    private int damage = 8;
    
    @Override
    public void affect(Entity entity){
        entity.decreaseHealth(this.damage);
    }
    
    public int getDamage(){
        return this.damage;
    }
}
