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
public class Challenge extends ACEObject {
    private String type; // combat or puzzle
    private String challengeName; // name of puzzle to load, or name of opponent to load

    
    public Challenge(int id) {
        super(id);
    }
    
    
    public Challenge(String type, String challengeName) {
        super();
        this.type = type;
        this.challengeName = challengeName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the challengeName
     */
    public String getChallengeName() {
        return challengeName;
    }

    /**
     * @param challengeName the challengeName to set
     */
    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }
}
