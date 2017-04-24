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
public class PuzzleBinarySwitchController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView door;

    @FXML
    private Label doorClue;

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

    MediaPlayer mediaPlayer;  // plays sounds

    private PuzzleBinarySwitch puzzle;  // the PuzzleObject

    private ImageController images = ImageController.get();

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.puzzle = new PuzzleBinarySwitch(false, false, true, 1);

        this.door.setImage(images.getImage(this.puzzle.getDoorBackgroundLocation()));
        this.leverLeftBackground.setImage(images.getImage(this.puzzle.getLeverBackgroundLocation()));
        this.leverMiddleBackground.setImage(images.getImage(this.puzzle.getLeverBackgroundLocation()));
        this.leverRightBackground.setImage(images.getImage(this.puzzle.getLeverBackgroundLocation()));
        this.leverLeft.setImage(images.getImage((this.puzzle.getLeverLocation())));
        this.leverMiddle.setImage(images.getImage((this.puzzle.getLeverLocation())));
        this.leverRight.setImage(images.getImage((this.puzzle.getLeverLocation())));

        this.doorClue.setText(Integer.toString(this.puzzle.getDoorClue()));

        this.gamePane.requestFocus();

        this.leaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (puzzle.getCompleted()) {
                    PuzzleBinarySwitchController.this.finishChallenge(ChallengeStatus.WIN);
                } else {
                    PuzzleBinarySwitchController.this.finishChallenge(ChallengeStatus.LOSS);
                }
            }
        });
    }

    /**
     * checkSolution method interacts with ChallengeController superclass through finishChallenge method
     */
    private void checkSolution() {
        if (puzzle.getCompleted()) {
            this.leaveButton.setText("FINISH");
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
                if (this.leverLeft.getRotate() == 180) {
                    this.leverLeft.setRotate(0);
                } else {
                    this.leverLeft.setRotate(180);
                }
                break;
            case UP:
            case KP_UP:
            case DOWN:
            case KP_DOWN:
            case S:
                puzzle.pullMiddle();
                // update the GUI
                if (this.leverMiddle.getRotate() == 180) {
                    this.leverMiddle.setRotate(0);
                } else {
                    this.leverMiddle.setRotate(180);
                }
                break;
            case RIGHT:
            case KP_RIGHT:
            case D:
                puzzle.pullRightmost();
                // update the GUI
                if (this.leverRight.getRotate() == 180) {
                    this.leverRight.setRotate(0);
                } else {
                    this.leverRight.setRotate(180);
                }
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
     * onClickedLever method handles mouse clicks on levers
     */
    @FXML
    private void onClickedLever(MouseEvent event) {
        if (event.getSource().equals(this.leverLeft)) {
            puzzle.pullLeftmost();
            if (this.leverLeft.getRotate() == 180) {
                this.leverLeft.setRotate(0);
            } else {
                this.leverLeft.setRotate(180);
            }
        } else if (event.getSource().equals(this.leverMiddle)) {
            puzzle.pullMiddle();
            if (this.leverMiddle.getRotate() == 180) {
                this.leverMiddle.setRotate(0);
            } else {
                this.leverMiddle.setRotate(180);
            }
        } else if (event.getSource().equals(this.leverRight)) {
            puzzle.pullRightmost();
            if (this.leverRight.getRotate() == 180) {
                this.leverRight.setRotate(0);
            } else {
                this.leverRight.setRotate(180);
            }
        }
        AudioController.get().playSound(this.puzzle.getSound());
        this.checkSolution();
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
