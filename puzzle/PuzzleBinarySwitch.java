package puzzle;

import gui.Sound;

/**
 *
 * @author Drew Hans
 */
public class PuzzleBinarySwitch extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private boolean[] correctSwitchPositions;
    private boolean[] currentSwitchPositions;
    private int doorClue;

    // PuzzleBinarySwitch resource locations
    private final String leverBackgroundLocation = "lever_base_0";
    private final String leverLocation = "lever_0";
    private final Sound soundLeverPullLocation = Sound.CLICK;

    /**
     * Constructor
     */
    public PuzzleBinarySwitch() {
        this.doorClue = 1; // store door clue

        this.correctSwitchPositions = new boolean[3];
        this.correctSwitchPositions[0] = false; // store leftmost switch solution
        this.correctSwitchPositions[1] = false; // store middle switch solution
        this.correctSwitchPositions[2] = true; // store rightmost switch solution

        this.currentSwitchPositions = new boolean[3];
        this.currentSwitchPositions[0] = false; // for leftmost switch
        this.currentSwitchPositions[1] = false; // for middle switch
        this.currentSwitchPositions[2] = false; // for rightmost switch

        // update model parameters for controller
        this.setBackground(this.leverBackgroundLocation);
        
        //TODO: SET SOUND TO LEVERPULL
        this.setSound(this.soundLeverPullLocation);
        this.setText("The number " + this.doorClue + " is carved on the door.  What could it mean?");
    }

    /**
     * Constructor
     *
     * @param ls
     * @param ms
     * @param rs
     * @param dc
     */
    public PuzzleBinarySwitch(boolean ls, boolean ms, boolean rs, int dc) {
        this.doorClue = dc; // store door clue

        this.correctSwitchPositions = new boolean[3];
        this.correctSwitchPositions[0] = ls; // store leftmost switch solution
        this.correctSwitchPositions[1] = ms; // store middle switch solution
        this.correctSwitchPositions[2] = rs; // store rightmost switch solution

        this.currentSwitchPositions = new boolean[3];
        this.currentSwitchPositions[0] = false; // for leftmost switch
        this.currentSwitchPositions[1] = false; // for middle switch
        this.currentSwitchPositions[2] = false; // for rightmost switch

        // update model parameters for controller
        this.setBackground(this.leverBackgroundLocation);
        //TODO: SET SOUND TO LEVER PULL 
        this.setSound(this.soundLeverPullLocation);
        this.setText("The number " + this.doorClue + " is carved on the door.  What could it mean?");
    }

    /**
     * @return the currentSwitchPositions boolean array
     */
    public boolean[] getCurrentSwitchPositions() {
        return this.currentSwitchPositions;
    }

    /**
     * @return the doorClue int
     */
    public int getDoorClue() {
        return this.doorClue;
    }

    /**
     * @return the String location of the inner dial
     */
    public String getLeverBackgroundLocation() {
        return this.leverBackgroundLocation;
    }

    /**
     * @return the String location of the outer dial
     */
    public String getLeverLocation() {
        return this.leverLocation;
    }

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing this method directly
     *
     * onPull looks at the class variables values and decides which text to set
     * for the controller
     */
    private void onPull() {
        if (this.correctSwitchPositions[0] == this.currentSwitchPositions[0]
                && this.correctSwitchPositions[1] == this.currentSwitchPositions[1]
                && this.correctSwitchPositions[2] == this.currentSwitchPositions[2]) {
            this.setText("The door opens!");
            this.setCompleted(); // set puzzle status to solved
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
