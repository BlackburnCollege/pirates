package puzzle;

/**
 *
 * @author Drew Hans
 */
public abstract class PuzzleModel {

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing these variables directly
     */
    String background;
    String sound;
    String text;

    /**
     * Superclass Constructor
     */
    public PuzzleModel() {
        this.background = "";
        this.sound = "";
        this.text = "";
    }

    /**
     * @return this.background
     */
    public String getBackground() {
        return this.background;
    }

    /**
     * @return this.sound
     */
    public String getSound() {
        return this.sound;
    }

    /**
     * @return this.text
     */
    public String getText() {
        return this.text;
    }

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing this method
     */
    void setBackground(String newBG) {
        this.background = newBG;
    }

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing this method
     */
    void setSound(String newS) {
        this.sound = newS;
    }

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing this method
     */
    void setText(String newT) {
        this.text = newT;
    }

}
