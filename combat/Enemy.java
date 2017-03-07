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
public class Enemy extends Player {

    private boolean meleeProf = false;
    private boolean gunProf = false;
    private boolean insultProf = false;
    String move = "";
    private String name;
    private int damage;

    public Enemy(String name) {
        super(name);
        this.name = name;
    }

    public int getDamage() {
        Random rand = new Random();
        damage = 0 + rand.nextInt(20 - 0 + 1);
        return damage;
    }

    public String getMove(int damage) {
        move = name + " attacked for " + damage;
        return move;
    }
}
