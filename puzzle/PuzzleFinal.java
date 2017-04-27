package puzzle;

import gui.Sound;

/**
 * This class defines the PuzzleFinal object subclass of PuzzleModel.
 *
 * @author Drew Hans
 */
public class PuzzleFinal extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package, and different packages from accessing
     * these variables directly
     */
    private char[] correctDialPositions;
    private char[] currentDialPositions;

    // PuzzleFinal resource locations
    private final String finalBackgroundLocation = "puzzleFinalBackground";
    private final String upButtonLocation = "puzzleFinalArrowUp";
    private final String downButtonLocation = "puzzleFinalArrowDown";
    private final Sound soundClickLocation = Sound.CLICK;

    /**
     * Constructor
     */
    public PuzzleFinal() {
        this.correctDialPositions = new char[7];
        this.correctDialPositions[0] = 'M';
        this.correctDialPositions[1] = 'A';
        this.correctDialPositions[2] = 'R';
        this.correctDialPositions[3] = 'G';
        this.correctDialPositions[4] = 'E';
        this.correctDialPositions[5] = 'R';
        this.correctDialPositions[6] = 'Y';

        this.currentDialPositions = new char[7];
        this.currentDialPositions[0] = 'A';
        this.currentDialPositions[1] = 'A';
        this.currentDialPositions[2] = 'A';
        this.currentDialPositions[3] = 'A';
        this.currentDialPositions[4] = 'A';
        this.currentDialPositions[5] = 'A';
        this.currentDialPositions[6] = 'A';

        // update model parameters for controller
        this.setBackground(this.finalBackgroundLocation);
        this.setSound(this.soundClickLocation);
        this.setText("");
    }

    /**
     * Constructor
     */
    public PuzzleFinal(String spouseName) {
        this.correctDialPositions = new char[7];
        this.correctDialPositions[0] = spouseName.charAt(0);
        this.correctDialPositions[1] = spouseName.charAt(1);
        this.correctDialPositions[2] = spouseName.charAt(2);
        this.correctDialPositions[3] = spouseName.charAt(3);
        this.correctDialPositions[4] = spouseName.charAt(4);
        this.correctDialPositions[5] = spouseName.charAt(5);
        this.correctDialPositions[6] = spouseName.charAt(6);

        this.currentDialPositions = new char[7];
        this.currentDialPositions[0] = 'A';
        this.currentDialPositions[1] = 'A';
        this.currentDialPositions[2] = 'A';
        this.currentDialPositions[3] = 'A';
        this.currentDialPositions[4] = 'A';
        this.currentDialPositions[5] = 'A';
        this.currentDialPositions[6] = 'A';

        // update model parameters for controller
        this.setBackground(this.finalBackgroundLocation);
        this.setSound(this.soundClickLocation);
        this.setText("");
    }

    /**
     * @return the correctDialPositions char array
     */
    public char[] getCorrectDialPositions() {
        return this.correctDialPositions;
    }

    /**
     * @return the currentDialPositions char array
     */
    public char[] getCurrentDialPositions() {
        return this.currentDialPositions;
    }

    /**
     * @return the finalBackgroundLocation String
     */
    public String getFinalBackgroundLocation() {
        return this.finalBackgroundLocation;
    }

    /**
     * @return the upButtonLocation String
     */
    public String getUpButtonLocation() {
        return this.upButtonLocation;
    }

    /**
     * @return the downButtonLocation String
     */
    public String getDownButtonLocation() {
        return this.downButtonLocation;
    }

    /**
     * private modifier restricts other programs, subclasses in this package, and different packages from accessing this
     * method directly
     *
     * onPress looks at the class variables values and decides which text to set for the controller
     */
    private void onPress() {
        if (this.correctDialPositions[0] == this.currentDialPositions[0]
                && this.correctDialPositions[1] == this.currentDialPositions[1]
                && this.correctDialPositions[2] == this.currentDialPositions[2]
                && this.correctDialPositions[3] == this.currentDialPositions[3]
                && this.correctDialPositions[4] == this.currentDialPositions[4]
                && this.correctDialPositions[5] == this.currentDialPositions[5]
                && this.correctDialPositions[6] == this.currentDialPositions[6]) {
            this.setText("The door opens!");
            this.setCompleted(); // set puzzle status to solved
        } else {
            this.setText("The door doesn't budge");
        }
    }

    /**
     * turnDialUp is called by the controller when the player chooses to turn the dial at dialPos up
     *
     * @param dialPos - the array position of dial to turn
     */
    public void turnDialUp(int dialPos) {
        if (this.currentDialPositions[dialPos] == 'Z') {
            this.currentDialPositions[dialPos] = 'A';
        } else {
            // increment char
            int charValue = this.currentDialPositions[dialPos];
            this.currentDialPositions[dialPos] = (char) (charValue + 1);
        }
        this.onPress();
    }

    /**
     * turnDialDown is called by the controller when the player chooses to turn dial at dialPos down
     *
     * @param dialPos - the array position of dial to turn
     */
    public void turnDialDown(int dialPos) {
        if (this.currentDialPositions[dialPos] == 'A') {
            this.currentDialPositions[dialPos] = 'Z';
        } else {
            // increment char
            int charValue = this.currentDialPositions[dialPos];
            this.currentDialPositions[dialPos] = (char) (charValue - 1);
        }
        this.onPress();
    }
}
