package puzzle;

import gui.ChallengeController;
import gui.ChallengeStatus;
import gui.ImageController;
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
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import puzzle.PuzzleFish.Fish;

/**
 * This class defines the Controller that mediates between the Puzzle object
 * model and the Puzzle GUI
 *
 * @author Jessica Cramer
 * @author Lucas Burdell
 */
public class PuzzleFishController extends ChallengeController implements Initializable {

    @FXML
    public Pane gamePane;

    @FXML
    private Label timerLabel;

    public static final int TIME_TO_FISH = 20;

    private final ImageController images = ImageController.get();
    private Image fishImage = images.getImage("fish_0");

    private FishingTimer timer;

    private PuzzleFish fishPuzzle = new PuzzleFish();

    private Fish[] fishes;
    private ImageView[] fishImages;

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //backgrounds are a pain to set sometimes
        //there's probably a much easier way to do this
        gamePane.setBackground(new Background(
                new BackgroundImage(
                        images.getImage("fishing_background"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(1, 1, true, true, true, true)
                )
        ));

        fishes = new Fish[fishPuzzle.getFishes().size()];
        fishImages = new ImageView[fishes.length];

        // make fish
        int i = 0;
        for (Fish fish : fishPuzzle.getFishes()) {
            ImageView fishView = buildFishView(fish);
            gamePane.getChildren().add(fishView);
            this.fishes[i] = fish;
            fishImages[i] = fishView;
            i++;
        }

        // make and start timer
        timer = new FishingTimer(TIME_TO_FISH);
        timer.start();
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
            String formatted = new DecimalFormat("##.##").format(timeRemaining);
            PuzzleFishController.this.timerLabel.setText(
                    "Click the fish before time runs out! " + formatted + " seconds left");
            for (int i = 0; i < fishes.length; i++) {
                Fish fishe = fishes[i];
                ImageView fishView = fishImages[i];
                if (fishe != null && fishView != null && !fishe.isCaught()) {
                    fishe.think(now);
                    updateFishView(fishe, fishView);
                    System.out.println("Fish " + i + " thinking");
                }
            }
            if (currentTime >= maxTime && !fishPuzzle.getCompleted()) {
                PuzzleFishController.this.finishChallenge(ChallengeStatus.LOSS);
                this.stop();
            }
        }
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

    public void updateFishView(Fish fish, ImageView view) {
        double screenWidth = (gamePane.getWidth() - view.getImage().getWidth() / 2);
        double screenHeight = (gamePane.getHeight() - view.getImage().getHeight() / 2);;

        
        //calculate position on screen
        double screenPosX = ((double) fish.getXPos() / (double) PuzzleFish.MAP_WIDTH)
                * screenWidth;
        double screenPosY = ((double) fish.getYPos() / (double) PuzzleFish.MAP_HEIGHT)
                * screenHeight;

        view.setLayoutX(screenPosX);
        view.setLayoutY(screenPosY);
        //view.setScaleX(PuzzleFish.MAP_WIDTH / screenWidth);
        //view.setScaleY(PuzzleFish.MAP_HEIGHT / screenHeight);
        view.setRotate(fish.getRotation());
    }

    // get us a fish view to show on screen
    // also sets up the mouse click event listener
    public ImageView buildFishView(Fish fish) {
        ImageView fishView = new ImageView(fishImage);
        int screenWidth = 800;
        int screenHeight = 600;

        //calculate position on screen
        double screenPosX = ((double) fish.getXPos() / (double) PuzzleFish.MAP_WIDTH)
                * screenWidth;
        double screenPosY = ((double) fish.getYPos() / (double) PuzzleFish.MAP_HEIGHT)
                * screenHeight;
        System.out.println("screenPosX = " + screenPosX);
        System.out.println("screenPosY = " + screenPosY);

        // shoddy bounds checking
        /*
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
         */
        fishView.setLayoutX(screenPosX);
        fishView.setLayoutY(screenPosY);
        //fishView.setScaleX(PuzzleFish.MAP_WIDTH / screenWidth);
        //fishView.setScaleY(PuzzleFish.MAP_HEIGHT / screenHeight);
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
    public void onChallengeLoaded() {
        // do nothing, we don't need any info from the challenge
        // I forced this method to be overriden because the combat team
        // needed extra info from the Challenge story model object
    }

    @Override
    public void setupListeners(Scene scene) {

    }

    @Override
    public void teardownListeners(Scene scene) {

    }
}
