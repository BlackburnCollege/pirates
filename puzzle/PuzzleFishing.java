package puzzle;

public class PuzzleFishing extends PuzzleModel {
    
    private final String waterLocation = "water.jpg";
    int smallFishWeight = 1;
    int mediumFishWeight = 3;
    int largeFishWeight = 5;
    
    
    public PuzzleFishing() {
        this.setBackground(waterLocation);
        this.setSound("");
        this.setText("I row out to my normal fishing spot. I’ll need 5 fish to "
                + "sell at the market today.”\n Instructions: Click on the "
                + "fish to catch them. Bigger fish will disappear faster, "
                + "but are worth more.");
    }

}
