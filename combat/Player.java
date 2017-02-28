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
public class Player {
    private double currentHealth;
    private double maxHealth;
    private boolean ai;
    private boolean meleeProf;
    private boolean gunProf;
    private boolean insultProf;
    private String name;
    private Insult wit;

    public Player(boolean ai, String name) {
        this.ai = ai;
        this.name = name;
    }
    
}
