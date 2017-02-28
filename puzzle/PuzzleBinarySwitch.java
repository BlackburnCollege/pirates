package puzzle;

/**
 *
 * @author Drew Hans
 */
public class PuzzleBinarySwitch {

    private final String background;
    private boolean leftmostCorrectPosition;
    private boolean middleCorrectPosition;
    private boolean rightmostCorrectPosition;
    private boolean leftmostCurrentPosition;
    private boolean middleCurrentPosition;
    private boolean rightmostCurrentPosition;

    /**
     * Constructor
     */
    public PuzzleBinarySwitch() {
        this.background = "bg.jpg";
    }

    /**
     * Constructor
     */
    public PuzzleBinarySwitch(boolean ls, boolean ms, boolean rs) {
        this.background = "bg.jpg";
        this.leftmostCorrectPosition = ls;
        this.middleCorrectPosition = ms;
        this.rightmostCorrectPosition = rs;
    }

    public String pullLeftmost() {
        this.leftmostCurrentPosition = !this.leftmostCurrentPosition;
        return this.onAttempt();
    }

    public String pullMiddle() {
        this.middleCurrentPosition = !this.middleCurrentPosition;
        return this.onAttempt();
    }

    public String pullRightmost() {
        this.rightmostCurrentPosition = !this.rightmostCurrentPosition;
        return this.onAttempt();
    }

    /**
     * onAttempt looks at the class variables values and decides what to return
     * to the controller
     *
     * @return the String location of a sound file
     */
    private String onAttempt() {
        if (this.leftmostCorrectPosition == this.leftmostCurrentPosition
                && this.middleCorrectPosition == this.middleCurrentPosition
                && this.rightmostCorrectPosition == this.rightmostCurrentPosition) {
            return "The door opens!";
        } else {
            return "The door doesn't budge";
        }
    }

}
