package puzzle;

import gui.ChallengeController;
import gui.ChallengeStatus;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Drew Hans
 */
public class PuzzleBinarySwitchController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView background;

    @FXML
    private Media sound;

    @FXML
    MediaPlayer mediaPlayer;

    @FXML
    private TextField text;

    private PuzzleBinarySwitch pbs;

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.pbs = new PuzzleBinarySwitch(false, false, true, 1);
        this.background.setImage(new Image(this.pbs.getBackground()));
        this.sound = new Media(new File(this.pbs.getSound()).toURI().toString());
        this.mediaPlayer = new MediaPlayer(this.sound);
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

    /**
     * playSound method handles MediaPlayer updates and sound plays
     */
    private void playSound() {
        this.mediaPlayer = new MediaPlayer(this.sound);
        this.mediaPlayer.play();
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
}
