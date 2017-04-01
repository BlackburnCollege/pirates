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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Drew Hans
 */
public class PuzzleBinarySwitchController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView leverLeftBackground;

    @FXML
    private ImageView leverLeft;

    @FXML
    private ImageView leverMiddleBackground;

    @FXML
    private ImageView leverMiddle;

    @FXML
    private ImageView leverRightBackground;

    @FXML
    private ImageView leverRight;

    @FXML
    private Hyperlink leaveButton;  // the exit button

    @FXML
    MediaPlayer mediaPlayer;  // plays sounds

    @FXML
    private TextField hint;  // displays text hint

    private PuzzleBinarySwitch puzzle;  // the PuzzleObject

    private ImageController images = ImageController.get();

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.puzzle = new PuzzleBinarySwitch(false, false, true, 1);

        this.leverLeftBackground.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverLeftBackground.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverLeftBackground.setImage(images.getImage(this.puzzle.getLeverBackgroundLocation()));

        this.leverMiddleBackground.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverMiddleBackground.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverMiddleBackground.setImage(images.getImage(this.puzzle.getLeverBackgroundLocation()));

        this.leverRightBackground.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverRightBackground.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverRightBackground.setImage(images.getImage(this.puzzle.getLeverBackgroundLocation()));

        this.leverLeft.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverLeft.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverLeft.setImage(images.getImage((this.puzzle.getLeverLocation())));

        this.leverMiddle.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverMiddle.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverMiddle.setImage(images.getImage((this.puzzle.getLeverLocation())));

        this.leverRight.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverRight.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverRight.setImage(images.getImage((this.puzzle.getLeverLocation())));

        this.gamePane.requestFocus();

        this.leaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PuzzleBinarySwitchController.this.finishChallenge(ChallengeStatus.LOSS);
            }
        });
    }

    /**
     * checkSolution method interacts with ChallengeController superclass
     * through finishChallenge method
     */
    private void checkSolution() {
        if (puzzle.getCompleted() == true) {
            this.finishChallenge(ChallengeStatus.WIN);
        }
    }

    /**
     * onKeyEvent method handles key presses
     */
    @FXML
    private void onKeyEvent(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
            case KP_LEFT:
            case A:
                puzzle.pullLeftmost();
                // update the GUI
                this.leverLeft.setRotate(180);
                break;
            case UP:
            case KP_UP:
            case DOWN:
            case KP_DOWN:
            case S:
                puzzle.pullMiddle();
                // update the GUI
                this.leverLeft.setRotate(180);
                break;
            case RIGHT:
            case KP_RIGHT:
            case D:
                puzzle.pullRightmost();
                // update the GUI
                this.leverLeft.setRotate(180);
                break;
            default:
                break;
        }

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
