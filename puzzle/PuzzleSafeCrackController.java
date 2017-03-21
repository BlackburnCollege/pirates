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
public class PuzzleSafeCrackController extends ChallengeController implements Initializable {

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

    private PuzzleSafeCrack psc;

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.psc = new PuzzleSafeCrack((byte) 95, (byte) 15, (byte) 5);
        this.gamePane.requestFocus();
        //this.background.setImage(new Image(this.psc.getBackground()));
        //this.sound = new Media(new File(this.psc.getSound()).toURI().toString());
        //this.mediaPlayer = new MediaPlayer(this.sound);
    }

    /**
     * onKeyEvent method handles key presses
     */
    @FXML
    private void onKeyEvent(KeyEvent event) {
        System.out.println("Key event triggered");
        System.out.println(event.getCode());
        switch (event.getCode()) {
            case LEFT:
            case KP_LEFT:
                System.out.println("Dial is turned counter-clockwise.");
                psc.turnCounterClockwise();
                break;
            case RIGHT:
            case KP_RIGHT:
                System.out.println("Dial is turned clockwise.");
                psc.turnClockwise();
                break;
            default:
                break;
        }
        //this.sound = new Media(new File(this.psc.getSound()).toURI().toString());
        playSound();
        checkSolution();
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
        //this.mediaPlayer = new MediaPlayer(this.sound);
        //this.mediaPlayer.play();
    }

    /**
     * checkSolution method interacts with ChallengeController superclass
     * through finishChallenge method
     */
    private void checkSolution() {
        //if (psc.getCompleted() == true) {
            this.finishChallenge(ChallengeStatus.WIN);
        //}
    }

    @Override
    public void onChallengeLoaded() {

    }
}
