/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.util.HashMap;

/**
 *
 * @author timothy.francis
 */
public class Conditional extends ACEObject {

    private String flagName;
    private int value;
    private HashMap<String, Integer> flags;
    
    public Conditional(int id) {
        super(id);
    }

    public Conditional(HashMap<String, Integer> flags, String flagName, int value) {
        super();
        this.flags = flags;
        this.flagName = flagName;
        this.value = value;
    }

    public Conditional(HashMap<String, Integer> flags, String flagName, boolean value) {
        this(flags, flagName, value ? 1 : 0);
    }
    
    public boolean checkCondition() {
        return flags.getOrDefault(this.flagName, 0) == this.value;
    };

    public void setCondition() {
        flags.put(this.flagName, this.value);
    }
        
    
}
