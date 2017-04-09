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
    private final String decoderBackgroundLocation = "decoder_base_0";
    private final String decoderLocation = "decoder_0";
    private final Sound soundClickLocation = Sound.CLICK;

    /**
     * Constructor
     */
    public PuzzleCaesarCipher() {
        this.correctKey = 5; // store default correctKey

        this.currentKey = 0; // store currentKey

        // update model parameters for controller
        this.setBackground(this.decoderBackgroundLocation);

        //TODO: SET SOUND TO LEVERPULL
        this.setSound(this.soundClickLocation);
        this.setText("The decode is set to " + this.currentKey + ".");
    }

    /**
     * Constructor
     *
     * @param solutionKey
     */
    public PuzzleCaesarCipher(int solutionKey) {
        this.correctKey = solutionKey; // store default correctKey

        this.currentKey = 0; // store currentKey

        // update model parameters for controller
        this.setBackground(this.decoderBackgroundLocation);

        //TODO: SET SOUND TO LEVERPULL
        this.setSound(this.soundClickLocation);
        this.setText("The decode is set to " + this.currentKey + ".");
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
    public String getDecoderBackgroundLocation() {
        return this.decoderBackgroundLocation;
    }

    /**
     * @return the String location of the decoder
     */
    public String getDecoderLocation() {
        return this.decoderLocation;
    }

}
