package puzzle;

/**
 *
 * @author Drew Hans
 */
public class PuzzleRiddle {

    private final String background;
    private String riddle;
    private String answer;

    /**
     * Constructor
     */
    public PuzzleRiddle() {
        this.background = "bg.jpg";
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
        this.background = "bg.jpg";
        this.riddle = r;
        this.answer = a;
    }

    /**
     * guess is called by the controller when the player makes a guess
     *
     * @param g the userinput
     * @return the String response to the guess
     */
    public String guess(String g) {
        return this.onAttempt(g);
    }

    /**
     * onAttempt looks at the class variables values and decides what to return
     * to the controller
     *
     * @return the String location of a sound file
     */
    private String onAttempt(String guess) {
        if (this.answer.equalsIgnoreCase(guess)) {
            return "Correct!";
        } else {
            return "Wrong! Try again.";
        }
    }

}
