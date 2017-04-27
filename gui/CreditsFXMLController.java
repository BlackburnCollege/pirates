package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author lucas.burdell
 */
public class CreditsFXMLController extends ChallengeController 
        implements Initializable {

    @FXML
    private Label endLabel;
    @FXML
    private VBox creditsPane;
    @FXML
    private Pane fadePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CreditsTimer timer = new CreditsTimer();
        timer.start();
    }

    @Override
    public void setupListeners(Scene scene) {
        
    }

    @Override
    public void teardownListeners(Scene scene) {
        
    }

    @Override
    public void onChallengeLoaded() {
        
    }

    private class CreditsTimer extends AnimationTimer {

        private long last = 0;
        private int state = 0;
        private int transitionTime = 2;
        private int displayTime = 5;
        private static final long ONE_SECOND_NANO = 1000000000L;

        public CreditsTimer() {
            super();
            last = System.nanoTime();
        }

        @Override
        public void handle(long now) {
            if (state == 0) {
                int transparency = 255 - (int) ((double) (now - last) / (double) (transitionTime * ONE_SECOND_NANO) * 255);
                fadePane.setStyle("-fx-background-color: #000000" + String.format("%02x", transparency & 0xff));
                if (now - last > transitionTime * ONE_SECOND_NANO) {
                    last = now;
                    state++;
                    fadePane.setStyle("-fx-background-color: #00000000");
                }
            } else if (state == 1) {
                if (now - last > displayTime * ONE_SECOND_NANO) {
                    last = now;
                    state++;
                }
            } else if (state == 2) {
                int transparency = (int) ((double) (now - last) / (double) (transitionTime * ONE_SECOND_NANO) * 255);
                fadePane.setStyle("-fx-background-color: #000000" + String.format("%02x", transparency & 0xff));
                if (now - last > transitionTime * ONE_SECOND_NANO) {
                    last = now;
                    state++;
                    fadePane.setStyle("-fx-background-color: #000000FF");
                    endLabel.setVisible(false);
                    creditsPane.setVisible(true);
                }
            } else if (state == 3) {
                int transparency = 255 - (int) ((double) (now - last) / (double) (transitionTime * ONE_SECOND_NANO) * 255);
                fadePane.setStyle("-fx-background-color: #000000" + String.format("%02x", transparency & 0xff));
                if (now - last > transitionTime * ONE_SECOND_NANO) {
                    last = now;
                    state++;
                    fadePane.setStyle("-fx-background-color: #00000000");
                }
            } else {
                if (now - last > displayTime * 5 * ONE_SECOND_NANO) {
                    System.exit(0);
                }
            }

        }

    }

}
