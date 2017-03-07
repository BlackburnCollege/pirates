
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
    private Combat combat;
    @FXML
    private Label output;
    @FXML
    private ProgressBar enemyHealth = new ProgressBar(1.0);
    @FXML
    private ProgressBar playerHealth = new ProgressBar(1.0);
    @FXML
    private Pane mainPane;
    
    
    @FXML
    private void attack(ActionEvent event){
        this.combat.round(Move.ATTACK);
    }
    @FXML
    private void insult(ActionEvent event){
        this.combat.round(Move.INSULT);
    }
    @FXML
    private void run(ActionEvent event){
        this.output.setText("You ran");
        this.mainPane.setVisible(false);
    }
    @FXML
    private void fireGun(ActionEvent event){
        this.combat.round(Move.SHOOT);
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Player player = new Player("REPLACE_LATER");
        Enemy enemy = new Enemy("REPLACE_LATER");
        this.combat = new Combat(player, enemy);
    }    
    
}
