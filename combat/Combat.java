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

    private Player player;
    private Enemy enemy;
    private double damage;
    private String status;

    public Combat(Player player, Enemy enemy) {
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
                this.player.decreaseHealth(.3);
                round = "you cannot run. You take 30 damage.";
                break;

        }
        return round;
    }

    private String attack() {
        double playerDamage = this.player.getDamage() / 100.0;
        double enemyDamage = this.enemy.getDamage() / 100.0;
        this.player.decreaseHealth(enemyDamage);
        this.enemy.decreaseHealth(playerDamage);
        return this.player.getMove((int) (playerDamage * 100)) + "\n" + 
                this.enemy.getMove((int) (enemyDamage * 100));
    }

    public double getPlayerHealth() {
        return this.player.getHealth();
    }

    public double getEnemyHealth() {
        return this.enemy.getHealth();
    }
}
