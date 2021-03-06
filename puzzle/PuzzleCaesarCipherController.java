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
import javafx.scene.control.Label;
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
public class PuzzleCaesarCipherController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView decoderBackground; // the outer decoder ring

    @FXML
    private ImageView decoder; // the inner decoder ring

    @FXML
    private Hyperlink leaveButton; // the exit button

    @FXML
    private MediaPlayer mediaPlayer; // plays sounds

    @FXML
    private Label decoderKey; // the current decoder key

    private PuzzleCaesarCipher puzzle;  // the PuzzleObject

    private final ImageController images = ImageController.get();

    private int rotateOffset = 166;

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.puzzle = new PuzzleCaesarCipher(5);

        this.decoderBackground.setImage(images.getImage(this.puzzle.getDecoderOuterLocation()));

        this.decoder.setImage(images.getImage(this.puzzle.getDecoderInnerLocation()));

        this.decoderKey.setText(Integer.toString(this.puzzle.getCurrentKey()));

        this.gamePane.requestFocus();

        this.leaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PuzzleCaesarCipherController.this.finishChallenge(ChallengeStatus.LOSS);
            }
        });
    }

    /**
     * checkSolution method interacts with ChallengeController superclass through finishChallenge method
     */
    private void checkSolution() {
        System.out.println(puzzle.getCurrentKey());
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
                puzzle.turnClockwise();
                this.decoderKey.setText(Integer.toString(this.puzzle.getCurrentKey()));
                break;
            case RIGHT:
            case D:
            case KP_RIGHT:
                puzzle.turnCounterClockwise();
                this.decoderKey.setText(Integer.toString(this.puzzle.getCurrentKey()));
                break;
            default:
                break;
        }

        // update the GUI - rotate the inner decoder image
        this.decoderBackground.setRotate((puzzle.getCurrentKey() / 26.0) * -360.0 + rotateOffset);

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
