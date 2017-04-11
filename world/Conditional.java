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
        return flags.getOrDefault(this.getFlagName(), 0) == this.getValue();
    };

    public void setCondition() {
        flags.put(this.getFlagName(), this.getValue());
    }

    /**
     * @return the flagName
     */
    public String getFlagName() {
        return flagName;
    }

    /**
     * @param flagName the flagName to set
     */
    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
        
    
}
