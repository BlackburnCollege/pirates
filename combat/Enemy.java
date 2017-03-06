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
public class Enemy extends Player {

    private boolean meleeProf = false;
    private boolean gunProf = false;
    private boolean insultProf = false;

    public Enemy(String name) {
        super(name);
    }

}
