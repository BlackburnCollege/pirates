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
        String round = "";
        switch (move) {
            case ATTACK:
                round = this.attack();
                break;
            case SHOOT:
                break;
            case INSULT:
                break;
            case RUN:
                break;

        }
        return round;
    }

    private String attack() {
        int playerDamage = 8;
        int enemyDamage = 8;
        this.player.decreaseHealth(enemyDamage);
        this.enemy.decreaseHealth(playerDamage);
        return this.player.getMove(playerDamage) + "\n" +
                this.enemy.getMove(enemyDamage);
    }

    public int getPlayerCurrentHealth() {
        return this.player.getCurrentHealth();
    }

    public int getEnemyCurrentHealth() {
        return this.enemy.getCurrentHealth();
    }

    public int getPlayerMaxHealth() {
        return this.player.getMaxHealth();
    }

    public int getEnemyMaxHealth() {
        return this.enemy.getMaxHealth();
    }
}
