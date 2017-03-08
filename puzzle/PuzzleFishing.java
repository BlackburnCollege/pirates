package puzzle;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;

public class PuzzleFishing extends PuzzleModel {
    
    private final String waterPic = "water.jpg";
    private final String smallFishPic = "";
    private final String mediumFishPic = "";
    private final String largeFishPic = "";
    private final String newFishSound = "";
    private int fishCount = 0;
    private final Button smallFishButton = null;
    private final Button mediumFishButton = null;
    private final Button largeFishButton = null;
    private int fishWeight = 0; 
    
    public PuzzleFishing() throws InterruptedException {
        this.setBackground(waterPic);
        this.setSound(newFishSound);
        this.setText("I row out to my normal fishing spot. I’ll need 5 fish to "
                + "sell at the market today.”\n Instructions: Click on the "
                + "fish to catch them. Bigger fish will disappear faster, "
                + "but are worth more.");
        
        while(fishCount <= 5){
            this.displayFish();
        }
    }
    
    public int getRandomFishSize(){
        Random rand = null;
        int randomFish = rand.nextInt((3-1)+1);
        return randomFish;
    }

    public void displayFish() throws InterruptedException{
        int fish = this.getRandomFishSize();
        this.setSound(this.newFishSound);
        TimerTask smallFishTask = new TimerTask() {
            @Override
            public void run() {
                //display small fish
            }
        };
        TimerTask mediumFishTask = new TimerTask() {
            @Override
            public void run() {
                //Display medium fish
            }
        };
        TimerTask largeFishTask = new TimerTask() {
            @Override
            public void run() {
                //Display Large fish
            }
        };
        Timer timer = new Timer();
        if (fish ==1){
            timer.schedule(smallFishTask, 5000);
            //if(fish is clicked){
            //    timer.cancel();
            //    fishCount++;
            //    weightCount += 1;
            //}
        } else if(fish == 3){
            timer.schedule(mediumFishTask, 3000);
            //if(fish is clicked){
            //    timer.cancel();
            //    fishCount++;
            //    weightCount += 2;
            //}
        } else {
            timer.schedule(largeFishTask, 1000);
            //if(fish is clicked){
            //    timer.cancel();
            //    fishCount++;
            //    weightCount += 3;
            //}
        }
    }
    
}
