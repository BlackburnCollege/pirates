package world;

/**
 *
 * @author lucas.burdell
 */
public class Choice {
    private String text;
    private Action action;
    
    public Choice() {
        
    }
    
    public Choice(String text) {
        this.text = text;
    }

    public Choice(String text, Action action) {
        this.text = text;
        this.action = action;
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
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }
    
    
}
