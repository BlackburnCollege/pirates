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
public class Combat {

    private CombatPlayer player;
    private Enemy enemy;
    private double damage;
    private String status;

    public Combat(CombatPlayer player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public String round(Move move) {
        String out = this.player.getMove(move, this.enemy) + "\n" +
                this.enemy.getMove(this.player);
        return out;
    }

    public double getPlayerHealthDouble() {
        return this.player.getCurrentHealth() / (double)this.player.getMaxHealth();
    }

    public double getEnemyHealthDouble() {
        return this.enemy.getCurrentHealth() / (double)this.enemy.getMaxHealth();
    }

}
