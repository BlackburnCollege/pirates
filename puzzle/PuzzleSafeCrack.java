package puzzle;

/**
 *
 * @author Drew Hans
 */
public class PuzzleSafeCrack extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private final String bgLocation = "bg.jpg";
    private final String soundTurnLocation = "soundturn.mp3";
    private final String soundDetectLocation = "sounddetect.mp3";
    private final String soundOpenLocation = "soundopen.mp3";
    private final String soundResetLocation = "soundreset.mp3";
    private byte currentNum;
    private boolean[] enteredCorrect;
    private byte[] safeCombination;

    /**
     * Constructor
     */
    public PuzzleSafeCrack() {
        this.setBackground(this.bgLocation);
        this.setSound(this.soundTurnLocation);
        this.setText("Turn the dial and listen for clues");

        this.currentNum = 0;

        this.enteredCorrect = new boolean[3];
        this.enteredCorrect[0] = false; // for combo1
        this.enteredCorrect[1] = false; // for combo2
        this.enteredCorrect[2] = false; // for combo3

        this.safeCombination = new byte[3];
        this.safeCombination[0] = 98; // store combo1
        this.safeCombination[1] = 7; // store combo2
        this.safeCombination[2] = 5; // store combo3
    }

    /**
     * Constructor
     *
     * @param num1
     * @param num2
     * @param num3
     */
    public PuzzleSafeCrack(byte num1, byte num2, byte num3) {
        this.setBackground(this.bgLocation);
        this.setSound(this.soundTurnLocation);
        this.setText("Turn the dial and listen for clues");

        this.currentNum = 0;

        this.enteredCorrect = new boolean[3];
        this.enteredCorrect[0] = false; // for combo1
        this.enteredCorrect[1] = false; // for combo2
        this.enteredCorrect[2] = false; // for combo3

        this.safeCombination = new byte[3];
        this.safeCombination[0] = num1; // store combo1
        this.safeCombination[1] = num2; // store combo2
        this.safeCombination[2] = num3; // store combo3
    }

    /**
     * @return the current number selected on the dial
     */
    public byte getCurrentNum() {
        return this.currentNum;
    }

    /**
     * @return the safeCombination byte array
     */
    public byte[] getSafeCombination() {
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
        } else {
            this.setSound(this.soundTurnLocation);
        }
    }

    /**
     * turnClockwise is called by the controller when the player turns the dial
     * clockwise
     */
    public void turnClockwise() {
        if (this.currentNum == -1) {
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
        if (this.currentNum == 100) {
            this.currentNum = 0;
        } else {
            this.currentNum++;
        }
        this.onTurn();
    }

}
