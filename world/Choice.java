package world;

/**
 *
 * @author lucas.burdell
 */
public class Choice {
    private String text;
    private Action action;

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
    
    
}
