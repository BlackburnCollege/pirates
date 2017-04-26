package puzzle;

import gui.AudioController;
import gui.ChallengeController;
import gui.ChallengeStatus;
import gui.ImageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;

/**
 * This class defines the Controller that mediates between the Puzzle object model and the Puzzle GUI
 *
 * @author Drew Hans
 * @author Lucas Burdell
 */
public class PuzzleSafeCrackController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView dialBackground; // the outer safe dial ring

    @FXML
    private ImageView dial; // the inner safe dial ring

    @FXML
    private Hyperlink leaveButton; // the exit button

    @FXML
    private MediaPlayer mediaPlayer; // plays sounds

    private PuzzleSafeCrack puzzle;  // the PuzzleObject

    private final ImageController images = ImageController.get();

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.puzzle = new PuzzleSafeCrack(95, 15, 5);

        this.dialBackground.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.dialBackground.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.dialBackground.setImage(images.getImage(this.puzzle.getDialOuterLocation()));

        this.dial.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.dial.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.dial.setImage(images.getImage(this.puzzle.getDialInnerLocation()));

        this.gamePane.requestFocus();

        this.leaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (puzzle.getCompleted()) {
                    PuzzleSafeCrackController.this.finishChallenge(ChallengeStatus.WIN);
                } else {
                    PuzzleSafeCrackController.this.finishChallenge(ChallengeStatus.LOSS);
                }

            }
        });
    }

    /**
     * checkSolution method interacts with ChallengeController superclass through finishChallenge method
     */
    private void checkSolution() {
        System.out.println(puzzle.getCurrentNum());
        if (puzzle.getCompleted() == true) {
            this.finishChallenge(ChallengeStatus.WIN);
            System.out.println("You win!");
        }
    }

    /**
     * onKeyEvent method handles key presses
     */
    @FXML
    private void onKeyEvent(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
            case A:
            case KP_LEFT:
                puzzle.turnCounterClockwise();
                break;
            case RIGHT:
            case D:
            case KP_RIGHT:
                puzzle.turnClockwise();
                break;
            default:
                break;
        }

        // update the GUI - rotate the inner dial image
        this.dial.setRotate((puzzle.getCurrentNum() / 100.0) * -360.0);

        // play the appropriate sound (determined by the PuzzleObject)
        AudioController.get().playSound(this.puzzle.getSound());
        // check solve status
        checkSolution();
    }

    /**
     * onMouseEvent method handles mouse clicks and movement
     */
    @FXML
    private void onMouseEvent(MouseEvent event) {
    }

    /**
     * EventHandler calls onKeyEvent when it detects a KeyEvent
     */
    private EventHandler keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            onKeyEvent(event);
        }

    };

    @Override
    public void onChallengeLoaded() {
    }

    @Override
    public void setupListeners(Scene scene) {
        scene.setOnKeyPressed(keyListener);
    }

    @Override
    public void teardownListeners(Scene scene) {
        scene.onKeyPressedProperty().set(null);
    }
}
