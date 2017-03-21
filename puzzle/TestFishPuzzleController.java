package puzzle;

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

/**
 * Created by lucas.burdell on 3/20/2017.
 */
public class TestFishPuzzleController extends ChallengeController implements Initializable {

    @FXML
    public Pane gamePane;

    @FXML
    ImageView fishyImageView;

    @FXML
    Label timerLabel;

    private FishingTimer timer;


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
            if (currentTime >= maxTime) {
                TestFishPuzzleController.this.finishChallenge(ChallengeStatus.LOSS);
                this.stop();
            }
        }
    }


    @Override
    public void onChallengeLoaded() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fishyImageView.setImage(new Image("/resources/fish.png"));
        fishyImageView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    timer.stop();
                    TestFishPuzzleController.this.finishChallenge(ChallengeStatus.WIN);

                }
            }
        });
        timer = new FishingTimer(10);
        timer.start();
    }
}
