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
    private Player enemy;
    private double damage;

    public Combat(Player player, Player enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void round(String input) {

    }

    public String event(String input) {
        return "work in progress...";
    }

    public double getCurrentHealth() {
        return 1.0;
    }
}
