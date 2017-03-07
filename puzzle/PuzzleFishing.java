package puzzle;

public class PuzzleFishing extends PuzzleModel {
    
 

    /**
     * Superclass Constructor
     */
    public PuzzleFishing() {
        this.setBackground("location");
        this.setSound("");
        this.setText("I row out to my normal fishing spot. I’ll need 5 fish to "
                + "sell at the market today.”\n Instructions: Click on the "
                + "fish to catch them. Bigger fish will disappear faster, "
                + "but are worth more.");
    }

}
