package puzzle;

import gui.ChallengeController;
import gui.ChallengeStatus;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author lucas.burdell
 */
public class PuzzleFishingController extends ChallengeController
        implements Initializable {

    @FXML
    private Pane gamePane;
    @FXML
    private ImageView fish;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fish.setImage(new Image("/resources/fish.png"));
    }    

    @FXML
    private void clickedFish(MouseEvent event) {
        this.finishChallenge(ChallengeStatus.WIN);
    }
    
}
