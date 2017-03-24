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
    private String answer;
    private String riddle;

    // PuzzleRiddle resource locations
    private final String bgLocation = "bg.jpg";

    /**
     * Constructor
     */
    public PuzzleRiddle() {
        this.riddle = "What is at the end of a rainbow?";
        this.answer = "W";

        // update model parameters for controller
        this.setBackground(this.bgLocation);
        this.setSound(null);
        this.setText(this.riddle);
    }

    /**
     * Constructor
     *
     * @param r
     * @param a
     */
    public PuzzleRiddle(String r, String a) {
        this.riddle = r;
        this.answer = a;

        // update model parameters for controller
        this.setBackground(this.bgLocation);
        this.setSound(null);
        this.setText(this.riddle);
    }

    /**
     * @return the answer String
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * @return the riddle String
     */
    public String getRiddle() {
        return this.riddle;
    }

    /**
     * guess is called by the controller when the player makes a guess and
     * decides which text to set for the controller
     *
     * @param g
     */
    public void guess(String g) {
        if (this.answer.equalsIgnoreCase(g)) {
            this.setText("Correct!");
        } else {
            this.setText("Wrong! Try again.");
        }
    }
}
