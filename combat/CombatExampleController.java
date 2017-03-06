
package combat;

import gui.ChallengeController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author dakota.tebbe
 */
public class CombatExampleController extends ChallengeController 
        implements Initializable {
    
    private int numShots = 2;
    
    @FXML
    private Label output;
    @FXML
    private ProgressBar enemyHealth = new ProgressBar(1.0);
    @FXML
    private Pane mainPane;
    
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        output.setText("Hello World!");
    }
    @FXML
    private void attack(ActionEvent event){
        this.enemyHealth.setProgress(0.5);
        this.output.setText("You attacked your opponent");
    }
    @FXML
    private void insult(ActionEvent event){
        this.enemyHealth.setStyle("-fx-accent: slategrey");
        this.output.setText("''I'll devour yer parrot, ye parrot-loving parrot!''");
    }
    @FXML
    private void run(ActionEvent event){
        this.output.setText("You ran");
        this.mainPane.setVisible(false);
    }
    @FXML
    private void fireGun(ActionEvent event){
        if(this.numShots!=0){
            this.output.setText("Fired gun");
            this.numShots--;
        }
        else{
            this.output.setText("Out of shots");
        }
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
