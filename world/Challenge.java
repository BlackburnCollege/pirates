/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

/**
 *
 * @author timothy.francis
 */
public class Challenge {
    private String type; // combat or puzzle
    private String challengeName; // name of puzzle to load, or name of opponent to load

    
    public Challenge(String type, String challengeName) {
        this.type = type;
        this.challengeName = challengeName;
    }
}
