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
     * protected modifier restricts other programs from accessing this method
     *
     * @return this.background
     */
    protected String getBackground() {
        return this.background;
    }

    /**
     * protected modifier restricts other programs from accessing this method
     *
     * @return this.sound
     */
    protected String getSound() {
        return this.sound;
    }

    /**
     * protected modifier restricts other programs from accessing this method
     *
     * @return this.text
     */
    protected String getText() {
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
