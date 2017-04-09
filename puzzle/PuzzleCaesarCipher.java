package puzzle;

import gui.Sound;

/**
 *
 * @author Drew Hans
 */
public class PuzzleCaesarCipher extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private int correctKey;
    private int currentKey;

    // PuzzleCaesarCipher resource locations
    private final String decoderOuterLocation = "caesarcipherdecoderOUTER";
    private final String decoderInnerLocation = "caesarcipherdecoderINNER";
    private final Sound soundClickLocation = Sound.CLICK;

    /**
     * Constructor
     */
    public PuzzleCaesarCipher() {
        this.correctKey = 5; // store default correctKey

        this.currentKey = 0; // store currentKey

        // update model parameters for controller
        this.setBackground(this.decoderOuterLocation);

        //TODO: SET SOUND TO LEVERPULL
        this.setSound(this.soundClickLocation);
        this.setText("Ymj pnqqjw nx Qzhfx");
    }

    /**
     * Constructor
     *
     * @param solutionKey - the decoder key solution
     */
    public PuzzleCaesarCipher(int solutionKey) {
        this.correctKey = solutionKey; // store default correctKey

        this.currentKey = 0; // store currentKey

        // update model parameters for controller
        this.setBackground(this.decoderOuterLocation);

        //TODO: SET SOUND TO LEVERPULL
        this.setSound(this.soundClickLocation);
        this.setText("");
    }

    /**
     * @return the correct key
     */
    public int getCorrectKey() {
        return this.correctKey;
    }

    /**
     * @return the current key
     */
    public int getCurrentKey() {
        return this.currentKey;
    }

    /**
     * @return the String location of the decoder background
     */
    public String getDecoderOuterLocation() {
        return this.decoderOuterLocation;
    }

    /**
     * @return the String location of the decoder
     */
    public String getDecoderInnerLocation() {
        return this.decoderInnerLocation;
    }

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing this method directly
     *
     * onTurn looks at the class variables values and decides which sound to set
     * for the controller
     */
    private void onTurn() {
        this.setSound(this.soundClickLocation);
    }

    /**
     * turnClockwise is called by the controller when the player turns the
     * decoder clockwise
     */
    public void turnClockwise() {
        if (this.currentKey == 0) {
            this.currentKey = 25;
        } else {
            this.currentKey--;
        }
        this.onTurn();
    }

    /**
     * turnCounterClockwise is called by the controller when the player turns
     * the decoder counterclockwise
     */
    public void turnCounterClockwise() {
        if (this.currentKey == 25) {
            this.currentKey = 0;
        } else {
            this.currentKey++;
        }
        this.onTurn();
    }

}
