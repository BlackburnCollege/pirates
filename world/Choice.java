package world;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lucas.burdell
 */
public class Choice extends ACEObject {

    private String text;
    private Action action;
    private ArrayList<Conditional> conditions = new ArrayList<>();

    public Choice(int id) {
        super(id);
    }
    
    public Choice() {
        super();
    }

    public Choice(String text) {
        super();
        this.text = text;
    }

    public Choice(String text, Action action) {
        super();
        this.text = text;
        this.action = action;
    }

    public Choice(String text, Action action, ArrayList<Conditional> conditionals) {
        super();
        this.text = text;
        this.action = action;
        this.conditions = conditionals;
    }
    
    public boolean checkConditions() {
        for (Conditional c : conditions) {
            if (!c.checkCondition()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param text the text to set
     * @return
     */
    public Choice setText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @param action the action to set
     * @return
     */
    public Choice setAction(Action action) {
        this.action = action;
        return this;
    }

    /**
     * @return the conditions
     */
    public Conditional[] getConditions() {
        return conditions.toArray(new Conditional[1]);
    }

    /**
     * @param conditions the conditions to set
     * @return
     */
    public Choice setConditions(Conditional[] conditions) {
        this.conditions = new ArrayList<>(Arrays.asList(conditions));
        return this;
    }

    public Choice addConditional(Conditional condition) {
        this.conditions.add(condition);
        return this;
    }

}
