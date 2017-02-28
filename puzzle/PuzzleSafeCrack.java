package puzzle;

/**
 *
 * @author Drew Hans
 */
public class PuzzleSafeCrack {

    private final String background;
    private final String soundTurn;
    private final String soundDetect;
    private final String soundOpen;
    private final String soundReset;
    private byte comboNum1;
    private byte comboNum2;
    private byte comboNum3;
    private boolean combo1Correct;
    private boolean combo2Correct;
    private boolean combo3Correct;
    private byte currentNum;

    /**
     * Constructor
     */
    public PuzzleSafeCrack() {
        this.background = "bg.jpg";
        this.soundTurn = "soundturn.mp3";
        this.soundDetect = "sounddetect.mp3";
        this.soundOpen = "soundopen.mp3";
        this.soundReset = "soundreset.mp3";
        this.currentNum = 0;
    }

    /**
     * Constructor
     *
     * @param num1
     * @param num2
     * @param num3
     */
    public PuzzleSafeCrack(byte num1, byte num2, byte num3) {
        this.background = "bg.jpg";
        this.soundTurn = "soundturn.mp3";
        this.soundDetect = "sounddetect.mp3";
        this.soundOpen = "soundopen.mp3";
        this.soundReset = "soundreset.mp3";
        this.comboNum1 = num1;
        this.comboNum2 = num2;
        this.comboNum3 = num3;
        this.combo1Correct = false;
        this.combo2Correct = false;
        this.combo3Correct = false;
        this.currentNum = 0;
    }
    
    /**
     * getCurrentNum
     *
     * @return the current number selected on the dial
     */
    public byte getCurrentNum () {
        return this.currentNum;
    }

    /**
     * turnClockwise is called by the controller when the player turns the dial.
     * Simulates turning the safe dial clockwise
     *
     * @return the String location of a sound file
     */
    public String turnClockwise() {
        if (this.currentNum == -1) {
            this.currentNum = 100;
        } else {
            this.currentNum--;
        }
        return this.onAttempt();
    }

    /**
     * turnCounterClockwise is called by the controller when the player turns
     * the dial. Simulates turning the safe dial counterclockwise.
     *
     * @return the String location of a sound file
     */
    public String turnCounterClockwise() {
        if (this.currentNum == 101) {
            this.currentNum = 0;
        } else {
            this.currentNum++;
        }
        return this.onAttempt();
    }

    /**
     * onAttempt looks at the class variables values and decides which sound to
     * return to the controller
     *
     * @return the String location of a sound file
     */
    private String onAttempt() {
        if (!this.combo1Correct && this.currentNum != this.comboNum1) {
            return this.soundTurn;
        } else if (!this.combo1Correct && this.currentNum == this.comboNum1) {
            this.combo1Correct = true;
            return this.soundDetect;
        } else if (this.combo1Correct && this.currentNum == this.comboNum1 - 1) {
            this.combo1Correct = false;
            return this.soundReset;
        } else if (!this.combo2Correct && this.currentNum != this.comboNum2) {
            return this.soundTurn;
        } else if (!this.combo2Correct && this.currentNum == this.comboNum2) {
            this.combo2Correct = true;
            return this.soundDetect;
        } else if (this.combo2Correct && this.currentNum == this.comboNum2 + 1) {
            this.combo2Correct = false;
            return this.soundReset;
        } else if (!this.combo3Correct && this.currentNum != this.comboNum3) {
            return this.soundTurn;
        } else if (!this.combo3Correct && this.currentNum == this.comboNum3) {
            this.combo3Correct = true;
            return this.soundOpen;
        } else {
            return "Something went horribly wrong in PuzzleSafeCrack";
        }
    }

}
