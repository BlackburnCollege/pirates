package puzzle;

import gui.Sound;

/**
 *
 * @author Drew Hans
 */
public class PuzzleSafeCrack extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private byte currentNum;
    private boolean[] enteredCorrect;
    private int[] safeCombination;

    // PuzleSafeCrack resource locations
    private final String dialOuterLocation = "/resources/puzzlesafedialOUTER.png";
    private final String dialInnerLocation = "/resources/puzzlesafedialINNER.png";
    
    //sounds
    private final Sound soundTurnLocation = Sound.SAFEDIALTURN;
    private final Sound soundDetectLocation = Sound.SAFEDETECTCOMBO;
    private final Sound soundOpenLocation = Sound.SAFEUNLOCK;
    private final Sound soundResetLocation = Sound.SAFELOCKRESET;

    /**
     * Constructor
     */
    public PuzzleSafeCrack() {
        this.currentNum = 0;

        this.enteredCorrect = new boolean[3];
        this.enteredCorrect[0] = false; // for combo1
        this.enteredCorrect[1] = false; // for combo2
        this.enteredCorrect[2] = false; // for combo3

        this.safeCombination = new int[3];
        this.safeCombination[0] = 98; // store combo1
        this.safeCombination[1] = 7; // store combo2
        this.safeCombination[2] = 5; // store combo3

        // update model parameters for controller
        this.setBackground(this.dialOuterLocation);
        this.setSound(this.soundTurnLocation);
        this.setText("Turn the dial and listen for clues");
    }

    /**
     * Constructor
     *
     * @param num1
     * @param num2
     * @param num3
     */
    public PuzzleSafeCrack(int num1, int num2, int num3) {
        this.currentNum = 0;

        this.enteredCorrect = new boolean[3];
        this.enteredCorrect[0] = false; // for combo1
        this.enteredCorrect[1] = false; // for combo2
        this.enteredCorrect[2] = false; // for combo3

        this.safeCombination = new int[3];
        this.safeCombination[0] = num1; // store combo1
        this.safeCombination[1] = num2; // store combo2
        this.safeCombination[2] = num3; // store combo3

        // update model parameters for controller
        this.setBackground(this.dialOuterLocation);
        this.setSound(this.soundTurnLocation);
        this.setText("Turn the dial and listen for clues");
    }

    /**
     * @return the current number selected on the dial
     */
    public byte getCurrentNum() {
        return this.currentNum;
    }

    /**
     * @return the String location of the inner dial
     */
    public String getDialInnerLocation() {
        return this.dialInnerLocation;
    }

    /**
     * @return the String location of the outer dial
     */
    public String getDialOuterLocation() {
        return this.dialOuterLocation;
    }

    /**
     * @return the safeCombination byte array
     */
    public int[] getSafeCombination() {
        return this.safeCombination;
    }

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing this method directly
     *
     * onTurn looks at the class variables values and decides which sound to set
     * for the controller
     */
    private void onTurn() {
        if (!this.enteredCorrect[0] && this.currentNum != this.safeCombination[0]) {
            this.setSound(this.soundTurnLocation);
        } else if (!this.enteredCorrect[0] && this.currentNum == this.safeCombination[0]) {
            this.enteredCorrect[0] = true;
            this.setSound(this.soundDetectLocation);
        } else if (this.enteredCorrect[0] && this.currentNum == this.safeCombination[0] - 1) {
            this.enteredCorrect[0] = false;
            this.setSound(this.soundResetLocation);
        } else if (!this.enteredCorrect[1] && this.currentNum != this.safeCombination[1]) {
            this.setSound(this.soundTurnLocation);
        } else if (!this.enteredCorrect[1] && this.currentNum == this.safeCombination[1]) {
            this.enteredCorrect[1] = true;
            this.setSound(this.soundDetectLocation);
        } else if (this.enteredCorrect[1] && this.currentNum == this.safeCombination[1] + 1) {
            this.enteredCorrect[1] = false;
            this.setSound(this.soundResetLocation);
        } else if (!this.enteredCorrect[2] && this.currentNum != this.safeCombination[2]) {
            this.setSound(this.soundTurnLocation);
        } else if (!this.enteredCorrect[2] && this.currentNum == this.safeCombination[2]) {
            this.enteredCorrect[2] = true;
            this.setSound(this.soundOpenLocation);
            this.setCompleted(); // set puzzle status to solved
        } else {
            this.setSound(this.soundTurnLocation);
        }
    }

    /**
     * turnClockwise is called by the controller when the player turns the dial
     * clockwise
     */
    public void turnClockwise() {
        if (this.currentNum == 0) {
            this.currentNum = 99;
        } else {
            this.currentNum--;
        }
        this.onTurn();
    }

    /**
     * turnCounterClockwise is called by the controller when the player turns
     * the dial counterclockwise
     */
    public void turnCounterClockwise() {
        if (this.currentNum == 99) {
            this.currentNum = 0;
        } else {
            this.currentNum++;
        }
        this.onTurn();
    }
}
