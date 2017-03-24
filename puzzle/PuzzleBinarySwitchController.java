package puzzle;

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
import javafx.scene.image.Image;
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
    private ImageView leverBackground;  // the background lever

    @FXML
    private ImageView lever;  // the lever

    @FXML
    private Hyperlink leaveButton;  // the exit button

    @FXML
    MediaPlayer mediaPlayer;  // plays sounds

    @FXML
    private TextField hint;  // displays text hint

    private PuzzleBinarySwitch pbs;  // the PuzzleObject
    
    private ImageController images = ImageController.get();

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.pbs = new PuzzleBinarySwitch(false, false, true, 1);

        this.leverBackground.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.leverBackground.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.leverBackground.setImage(images.getImage(this.pbs.getLeverBackgroundLocation()));

        this.lever.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.lever.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.lever.setImage(images.getImage((this.pbs.getLeverLocation())));

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
        if (pbs.getCompleted() == true) {
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
    }

    @Override
    public void onChallengeLoaded() {

    }

    @Override
    public void setupListeners(Scene scene) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void teardownListeners(Scene scene) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
