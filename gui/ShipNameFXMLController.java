package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lucas.burdell
 */
public class ShipNameFXMLController extends ChallengeController 
        implements Initializable {

    @FXML
    private TextField shipNameField;
    @FXML
    private Button enterButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enterShipName(ActionEvent event) {
        this.getWorld().setShipName(shipNameField.getText());
        this.finishChallenge(ChallengeStatus.LOSS);
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
    
}
