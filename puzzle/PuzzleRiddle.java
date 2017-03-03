package puzzle;

/**
 *
 * @author Drew Hans
 */
public class PuzzleRiddle extends PuzzleModel {

    /**
     * private modifier restricts other programs, subclasses in this package,
     * and different packages from accessing these variables directly
     */
    private final String bgLocation = "bg.jpg";
    private String riddle;
    private String answer;

    /**
     * Constructor
     */
    public PuzzleRiddle() {
        this.background = this.bgLocation;
        this.sound = "";
        this.text = "";
        this.riddle = "What is at the end of a rainbow?";
        this.answer = "W";
    }

    /**
     * Constructor
     *
     * @param r
     * @param a
     */
    public PuzzleRiddle(String r, String a) {
        this.background = this.bgLocation;
        this.sound = "";
        this.text = "";
        this.riddle = r;
        this.answer = a;
    }

    /**
     * protected modifier restricts other programs from accessing this method
     *
     * guess is called by the controller when the player makes a guess and
     * decides which text to set for the controller
     *
     * @param g
     */
    protected void guess(String g) {
        if (this.answer.equalsIgnoreCase(g)) {
            this.setText("Correct!");
        } else {
            this.setText("Wrong! Try again.");
        }
    }
}
