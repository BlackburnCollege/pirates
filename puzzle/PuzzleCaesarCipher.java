package puzzle;

public class PuzzleCaesarCipher extends PuzzleModel {
    
    private final String answer = "treasure";
    private final String originalMessage = "vtgcuwtg";
    
    public PuzzleCaesarCipher(){
        this.setBackground("");
        this.setSound("");
        this.setText("I examine the box more closely and I notice a jumble "
                + "of letters carved into the top of the box that reads ... " 
                + this.originalMessage + ". A closer examination reveals"
                + "something else on the bottom: A = C, B = D ...  It appears "
                + "that I have to translate the message and enter it into the "
                + "lock.");
    }

    /**
     * @return the answer String
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * guess is called by the controller when the player makes a guess and
     * decides which text to set for the controller
     *
     * @param g
     */
    public void guess(String g) {
        if (this.answer.equalsIgnoreCase(g)) {
            this.setText("It seems to have worked!");
            //opening sound
        } else {
            this.setText("Nothing happened. Maybe I should try again.");
        }
    }
}
