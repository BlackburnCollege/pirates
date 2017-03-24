package puzzle;

import gui.ChallengeController;
import gui.ChallengeStatus;
import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Drew Hans
 */
public class PuzzleSafeCrackController extends ChallengeController implements Initializable {

    @FXML
    private Pane gamePane;

    MediaPlayer mediaPlayer;

    private PuzzleSafeCrack psc;

    private final String bgLocation = "/resources/safedial.jpg";
    private final String soundTurnLocation = "/resources/soundturn.mp3";
    private final String soundDetectLocation = "/resources/sounddetect.mp3";
    private final String soundOpenLocation = "/resources/soundopen.mp3";
    private final String soundResetLocation = "/resources/soundreset.mp3";

    @FXML
    private ImageView dialBackground;
    @FXML
    private ImageView dial;
    @FXML
    private Hyperlink leaveButton;

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.psc = new PuzzleSafeCrack(95, 15, 5);
        //this.background.setImage(new Image(this.psc.getBackground()));
        //this.sound = new Media(new File(this.psc.getSound()).toURI().toString());
        //this.mediaPlayer = new MediaPlayer(this.sound);
        this.dialBackground.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.dialBackground.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.dialBackground.setImage(new Image("/resources/puzzlesafedialOUTER.png"));
        this.dial.fitWidthProperty().bind(gamePane.prefWidthProperty());
        this.dial.fitHeightProperty().bind(gamePane.prefHeightProperty());
        this.dial.setImage(new Image("/resources/puzzlesafedialINNER.png"));
        this.gamePane.requestFocus();
        this.leaveButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                PuzzleSafeCrackController.this.finishChallenge(ChallengeStatus.LOSS);
            }
            
        });

    }

    /**
     * onKeyEvent method handles key presses
     */
    @FXML
    private void onKeyEvent(KeyEvent event) {
        //System.out.println("Key event triggered");
        //System.out.println(event.getCode());
        switch (event.getCode()) {
            case LEFT:
            case A:
            case KP_LEFT:
                System.out.println("Dial is turned counter-clockwise.");
                psc.turnCounterClockwise();
                break;
            case RIGHT:
            case D:
            case KP_RIGHT:
                System.out.println("Dial is turned clockwise.");
                psc.turnClockwise();
                break;
            default:
                break;
        }
        //this.sound = new Media(new File(this.psc.getSound()).toURI().toString());
        this.dial.setRotate((psc.getCurrentNum() / 100.0) * -360.0);
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
        System.out.println(psc.getCurrentNum());
        if (psc.getCompleted() == true) {
            this.finishChallenge(ChallengeStatus.WIN);
        }
    }

    @Override
    public void onChallengeLoaded() {

    }

    private EventHandler keyListener = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onKeyEvent(event);
            }

        };
    
    @Override
    public void setupListeners(Scene scene) {
        scene.setOnKeyPressed(keyListener);
    }

    @Override
    public void teardownListeners(Scene scene) {
        scene.onKeyPressedProperty().set(null);
    }
}
