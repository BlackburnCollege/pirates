package puzzle;

import gui.AudioController;
import gui.ChallengeController;
import gui.ChallengeStatus;
import gui.ImageController;
import java.net.URL;
import java.util.Arrays;
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
public class PuzzleFinalController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView dial0Background;

    @FXML
    private ImageView dial0upButton;

    @FXML
    private ImageView dial0downButton;

    @FXML
    private ImageView dial1Background;

    @FXML
    private ImageView dial1upButton;

    @FXML
    private ImageView dial1downButton;

    @FXML
    private ImageView dial2Background;

    @FXML
    private ImageView dial2upButton;

    @FXML
    private ImageView dial2downButton;

    @FXML
    private ImageView dial3Background;

    @FXML
    private ImageView dial3upButton;

    @FXML
    private ImageView dial3downButton;

    @FXML
    private ImageView dial4Background;

    @FXML
    private ImageView dial4upButton;

    @FXML
    private ImageView dial4downButton;

    @FXML
    private ImageView dial5Background;

    @FXML
    private ImageView dial5upButton;

    @FXML
    private ImageView dial5downButton;

    @FXML
    private ImageView dial6Background;

    @FXML
    private ImageView dial6upButton;

    @FXML
    private ImageView dial6downButton;

    @FXML
    private Hyperlink leaveButton; // the exit button

    @FXML
    private MediaPlayer mediaPlayer; // plays sounds

    @FXML
    private TextField dial0Text; // the text for dial0

    @FXML
    private TextField dial1Text; // the text for dial1

    @FXML
    private TextField dial2Text; // the text for dial2

    @FXML
    private TextField dial3Text; // the text for dial3

    @FXML
    private TextField dial4Text; // the text for dial4

    @FXML
    private TextField dial5Text; // the text for dial5

    @FXML
    private TextField dial6Text; // the text for dial6

    private PuzzleFinal puzzle;  // the PuzzleObject

    private final ImageController images = ImageController.get();

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.puzzle = new PuzzleFinal();

        this.dial0Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial0upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial0downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial0Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[0]));

        this.dial1Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial1upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial1downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial1Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[1]));

        this.dial2Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial2upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial2downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial2Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[2]));

        this.dial3Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial3upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial3downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial3Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[3]));

        this.dial4Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial4upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial4downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial4Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[4]));

        this.dial5Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial5upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial5downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial5Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[5]));

        this.dial6Background.setImage(images.getImage(this.puzzle.getFinalBackgroundLocation()));
        this.dial6upButton.setImage(images.getImage(this.puzzle.getUpButtonLocation()));
        this.dial6downButton.setImage(images.getImage(this.puzzle.getDownButtonLocation()));
        this.dial6Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[6]));

        this.gamePane.requestFocus();

        this.leaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PuzzleFinalController.this.finishChallenge(ChallengeStatus.LOSS);
            }
        });
    }

    /**
     * checkSolution method interacts with ChallengeController superclass
     * through finishChallenge method
     */
    private void checkSolution() {
        
        //System.out.println(Arrays.toString(puzzle.getCorrectDialPositions()));
        if (puzzle.getCompleted() == true) {
            this.finishChallenge(ChallengeStatus.WIN);
        }
    }

    /**
     * onKeyEvent method handles key presses
     */
    @FXML
    private void onKeyEvent(KeyEvent event) {
    }

    /**
     * onMouseEvent method handles mouse clicks and movement
     */
    @FXML
    private void onMouseEvent(MouseEvent event) {
        if (event.getSource().equals(this.dial0upButton)) {
            puzzle.turnDialUp(0);
            this.dial0Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[0]));
        } else if (event.getSource().equals(this.dial0downButton)) {
            puzzle.turnDialDown(0);
            this.dial0Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[0]));
        } else if (event.getSource().equals(this.dial1upButton)) {
            puzzle.turnDialUp(1);
            this.dial1Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[1]));
        } else if (event.getSource().equals(this.dial1downButton)) {
            puzzle.turnDialDown(1);
            this.dial1Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[1]));
        } else if (event.getSource().equals(this.dial2upButton)) {
            puzzle.turnDialUp(2);
            this.dial2Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[2]));
        } else if (event.getSource().equals(this.dial2downButton)) {
            puzzle.turnDialDown(2);
            this.dial2Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[2]));
        } else if (event.getSource().equals(this.dial3upButton)) {
            puzzle.turnDialUp(3);
            this.dial3Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[3]));
        } else if (event.getSource().equals(this.dial3downButton)) {
            puzzle.turnDialDown(3);
            this.dial3Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[3]));
        } else if (event.getSource().equals(this.dial4upButton)) {
            puzzle.turnDialUp(4);
            this.dial4Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[4]));
        } else if (event.getSource().equals(this.dial4downButton)) {
            puzzle.turnDialDown(4);
            this.dial4Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[4]));
        } else if (event.getSource().equals(this.dial5upButton)) {
            puzzle.turnDialUp(5);
            this.dial5Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[5]));
        } else if (event.getSource().equals(this.dial5downButton)) {
            puzzle.turnDialDown(5);
            this.dial5Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[5]));
        } else if (event.getSource().equals(this.dial6upButton)) {
            puzzle.turnDialUp(6);
            this.dial6Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[6]));
        } else if (event.getSource().equals(this.dial6downButton)) {
            puzzle.turnDialDown(6);
            this.dial6Text.setText(Character.toString(this.puzzle.getCurrectDialPositions()[6]));
        }

        AudioController.get().playSound(this.puzzle.getSound());
        this.checkSolution();
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
