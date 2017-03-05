package puzzle;

/**
 *
 * @author Drew.Hans
 */
public class PuzzleMap extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private final String bgLocation = "bg.jpg";
    private final String soundMapOpen = "soundmapopen.mp3";
    private String[] mapPieceLocationHints;
    private boolean[] mapPiecesHeld;

    /**
     * Constructor
     */
    public PuzzleMap() {
        this.setBackground(this.bgLocation);
        this.setSound(this.soundMapOpen);
        this.setText("");

        this.mapPieceLocationHints = new String[6];
        this.mapPieceLocationHints[0] = ""; // for mapPiece1
        this.mapPieceLocationHints[1] = ""; // for mapPiece2
        this.mapPieceLocationHints[2] = ""; // for mapPiece3
        this.mapPieceLocationHints[3] = ""; // for mapPiece4
        this.mapPieceLocationHints[4] = ""; // for mapPiece5
        this.mapPieceLocationHints[5] = ""; // for mapPiece6

        this.mapPiecesHeld = new boolean[6];
        this.mapPiecesHeld[0] = false; // store mapPiece1
        this.mapPiecesHeld[1] = false; // store mapPiece2
        this.mapPiecesHeld[2] = false; // store mapPiece3
        this.mapPiecesHeld[3] = false; // store mapPiece4
        this.mapPiecesHeld[4] = false; // store mapPiece5
        this.mapPiecesHeld[5] = false; // store mapPiece6
    }

    /**
     * Constructor
     *
     * @param mpiece1
     * @param mpiece2
     * @param mpiece3
     * @param mpiece4
     * @param mpiece5
     * @param mpiece6
     */
    public PuzzleMap(boolean mpiece1, boolean mpiece2, boolean mpiece3, boolean mpiece4, boolean mpiece5, boolean mpiece6) {
        this.setBackground(this.bgLocation);
        this.setSound(this.soundMapOpen);
        this.setText("");

        this.mapPieceLocationHints = new String[6];
        this.mapPieceLocationHints[0] = ""; // for mapPiece1
        this.mapPieceLocationHints[1] = ""; // for mapPiece2
        this.mapPieceLocationHints[2] = ""; // for mapPiece3
        this.mapPieceLocationHints[3] = ""; // for mapPiece4
        this.mapPieceLocationHints[4] = ""; // for mapPiece5
        this.mapPieceLocationHints[5] = ""; // for mapPiece6

        this.mapPiecesHeld = new boolean[6];
        this.mapPiecesHeld[0] = mpiece1; // store mapPiece1
        this.mapPiecesHeld[1] = mpiece2; // store mapPiece2
        this.mapPiecesHeld[2] = mpiece3; // store mapPiece3
        this.mapPiecesHeld[3] = mpiece4; // store mapPiece4
        this.mapPiecesHeld[4] = mpiece5; // store mapPiece5
        this.mapPiecesHeld[5] = mpiece6; // store mapPiece6
    }

    /**
     * @return the mapPieceLocationHints String array
     */
    public String[] getMapPieceLocationHints() {
        return this.mapPieceLocationHints;
    }

    /**
     * @return the mapPiecesHeld boolean array
     */
    public boolean[] getMapPiecesHeld() {
        return this.mapPiecesHeld;
    }
}