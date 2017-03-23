package puzzle;

import com.sun.media.jfxmediaimpl.platform.Platform;
import gui.ChallengeController;
import gui.ChallengeStatus;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import world.Challenge;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import puzzle.PuzzleFishTest.Fish;

/**
 * Created by lucas.burdell on 3/20/2017.
 */
public class TestFishPuzzleController extends ChallengeController implements Initializable {

    public static final int TIME_TO_FISH = 10;

    private Image fishImage = new Image("resources/fish.png");

    @FXML
    public Pane gamePane;

    @FXML
    private Label timerLabel;

    private FishingTimer timer;

    private PuzzleFishTest fishPuzzle = new PuzzleFishTest();

    @Override
    public void setupListeners(Scene scene) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Timer for puzzle timeout
    // gotta catch 'em all before this goes off
    // I put this in the controller because the model has no sense of time
    // and if I wanted the model to have a sense of time I'd need to hook 
    // listeners or callbacks into the model from the controller and then make a 
    // new thread for the timer, which is overkill.
    private class FishingTimer extends AnimationTimer {

        private long maxTime;
        private long currentTime;

        public FishingTimer(int maxTime) {
            super();
            this.currentTime = System.nanoTime();
            this.maxTime = this.currentTime + (maxTime * 1000000000L); // seconds to nano seconds
        }

        @Override
        public void handle(long now) {
            currentTime += now - currentTime;
            double timeRemaining = (maxTime - currentTime) / 1000000000.0;
            // massive hack
            TestFishPuzzleController.this.timerLabel.setText(
                    "Click the fish before time runs out! " + timeRemaining + " seconds left");
            if (currentTime >= maxTime && !fishPuzzle.getCompleted()) {
                TestFishPuzzleController.this.finishChallenge(ChallengeStatus.LOSS);
                this.stop();
            }
        }
    }

    @Override
    public void onChallengeLoaded() {
        // do nothing, we don't need any info from the challenge
        // I forced this method to be overriden because the combat team
        // needed extra info from the Challenge story model object
    }

    //check if we caught them all
    public void checkIfPuzzleComplete() {
        if (fishPuzzle.getCompleted()) {
            this.finishChallenge(ChallengeStatus.WIN);
            timer.stop();
        }
    }

    // catch the fishies
    public void fishViewClicked(ImageView fishView, Fish fish) {
        gamePane.getChildren().remove(fishView);
        fishPuzzle.catchFish(fish);
        checkIfPuzzleComplete();
    }

    // get us a fish view to show on screen
    // also sets up the mouse click event listener
    public ImageView buildFishView(Fish fish) {
        ImageView fishView = new ImageView(fishImage);
        
        //calculate position on screen
        double screenPosX = ((double) fish.getXPos() / (double) PuzzleFishTest.MAP_WIDTH)
                * gamePane.getPrefWidth() - fishImage.getHeight();
        double screenPosY = ((double) fish.getYPos() / (double) PuzzleFishTest.MAP_HEIGHT)
                * gamePane.getPrefHeight();
        
        
        
        // shoddy bounds checking
        if (screenPosX < fishImage.getWidth()) {
            screenPosX = fishImage.getWidth();
        } else if (screenPosX > gamePane.getPrefWidth() - fishImage.getWidth()) {
            screenPosX = gamePane.getPrefWidth() - fishImage.getWidth();
        }
        
        if (screenPosY < fishImage.getHeight()) {
            screenPosY = fishImage.getHeight();
        } else if (screenPosY > gamePane.getPrefHeight() - fishImage.getHeight()) {
            screenPosY = gamePane.getPrefHeight() - fishImage.getHeight();
        }
        fishView.setX(screenPosX);
        fishView.setY(screenPosY);
        fishView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    fishViewClicked(fishView, fish);
                }
            }
        });
        return fishView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //backgrounds are a pain to set sometimes
        //there's probably a much easier way to do this
        gamePane.setBackground(new Background(
                new BackgroundImage(
                        new Image("resources/fishing_background.png"), 
                        BackgroundRepeat.REPEAT, 
                        BackgroundRepeat.REPEAT, 
                        BackgroundPosition.CENTER, 
                        BackgroundSize.DEFAULT
                )
        ));

        // make fish
        for (Fish fish : fishPuzzle.getFishes()) {
            ImageView fishView = buildFishView(fish);
            gamePane.getChildren().add(fishView);
        }
        
        // make and start timer
        timer = new FishingTimer(TIME_TO_FISH);
        timer.start();
    }
}
