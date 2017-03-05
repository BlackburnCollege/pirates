package puzzle;

/**
 *
 * @author Drew Hans
 */
public abstract class PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private String background;
    private String sound;
    private String text;
    private boolean completed;

    /**
     * Superclass Constructor
     */
    public PuzzleModel() {
        this.background = "";
        this.sound = "";
        this.text = "";
        this.completed = false;
    }

    /**
     * @return this.background
     */
    public String getBackground() {
        return this.background;
    }

    /**
     * @return this.completed
     */
    public boolean getCompleted() {
        return this.completed;
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
     *
     * final prevents the method from being overridden in subclasses
     */
    final void setBackground(String newBG) {
        this.background = newBG;
    }

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing this method
     *
     * final prevents the method from being overridden in subclasses
     */
    final void setCompleted() {
        this.completed = true;
    }

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing this method
     *
     * final prevents the method from being overridden in subclasses
     */
    final void setSound(String newS) {
        this.sound = newS;
    }

    /**
     * no modifier restricts other programs and subclasses in different packages
     * from accessing this method
     *
     * final prevents the method from being overridden in subclasses
     */
    final void setText(String newT) {
        this.text = newT;
    }

}
