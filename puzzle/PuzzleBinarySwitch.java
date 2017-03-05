package puzzle;

/**
 *
 * @author Drew Hans
 */
public class PuzzleBinarySwitch extends PuzzleModel {

    private final String bgLocation = "bg.jpg";
    private final String soundPullLeverLocation = "soundpulllever.mp3";
    private boolean[] correctSwitchPositions;
    private boolean[] currentSwitchPositions;
    private byte doorClue;

    /**
     * Constructor
     */
    public PuzzleBinarySwitch() {
        this.setBackground(this.bgLocation);
        this.setSound(this.soundPullLeverLocation);
        this.setText("The number 1 is carved on the door.  What could it mean?");

        this.doorClue = 1; // store door clue

        this.correctSwitchPositions = new boolean[3];
        this.correctSwitchPositions[0] = false; // store leftmost switch solution
        this.correctSwitchPositions[1] = false; // store middle switch solution
        this.correctSwitchPositions[2] = true; // store rightmost switch solution

        this.currentSwitchPositions = new boolean[3];
        this.currentSwitchPositions[0] = false; // for leftmost switch
        this.currentSwitchPositions[1] = false; // for middle switch
        this.currentSwitchPositions[2] = false; // for rightmost switch
    }

    /**
     * Constructor
     *
     * @param ls
     * @param ms
     * @param rs
     * @param dc
     */
    public PuzzleBinarySwitch(boolean ls, boolean ms, boolean rs, byte dc) {
        this.setBackground(this.bgLocation);
        this.setSound(this.soundPullLeverLocation);

        this.doorClue = dc; // store door clue

        this.setText("The number " + dc + " is carved on the door.  What could it mean?");

        this.correctSwitchPositions = new boolean[3];
        this.correctSwitchPositions[0] = ls; // store leftmost switch solution
        this.correctSwitchPositions[1] = ms; // store middle switch solution
        this.correctSwitchPositions[2] = rs; // store rightmost switch solution

        this.currentSwitchPositions = new boolean[3];
        this.currentSwitchPositions[0] = false; // for leftmost switch
        this.currentSwitchPositions[1] = false; // for middle switch
        this.currentSwitchPositions[2] = false; // for rightmost switch
    }

    /**
     * @return currentSwitchPositions boolean array
     */
    public boolean[] getCurrentSwitchPositions() {
        return this.currentSwitchPositions;
    }

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     *
     * onPull looks at the class variables values and decides which text to set
     * for the controller
     */
    private void onPull() {
        if (this.correctSwitchPositions[0] == this.currentSwitchPositions[0]
                && this.correctSwitchPositions[1] == this.currentSwitchPositions[1]
                && this.correctSwitchPositions[2] == this.currentSwitchPositions[2]) {
            this.setText("The door opens!");
        } else {
            this.setText("The door doesn't budge");
        }
    }

    /**
     * pullLeftmost is called by the controller when the player chooses to pull
     * the leftmost lever
     */
    public void pullLeftmost() {
        this.currentSwitchPositions[0] = !this.currentSwitchPositions[0];
        this.onPull();
    }

    /**
     * pullMiddle is called by the controller when the player chooses to pull
     * the middle lever
     */
    public void pullMiddle() {
        this.currentSwitchPositions[1] = !this.currentSwitchPositions[1];
        this.onPull();
    }

    /**
     * pullRightmost is called by the controller when the player chooses to pull
     * the rightmost lever
     */
    public void pullRightmost() {
        this.currentSwitchPositions[2] = !this.currentSwitchPositions[2];
        this.onPull();
    }

}
