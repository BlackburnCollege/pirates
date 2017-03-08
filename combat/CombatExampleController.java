package combat;

import gui.ChallengeController;
import gui.ChallengeStatus;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
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
    private void attack(ActionEvent event) {
        this.output.setText(this.combat.round(Move.ATTACK));

        this.enemyHealth.setProgress(this.combat.getEnemyCurrentHealth() / (double)this.combat.getEnemyMaxHealth());
        this.playerHealth.setProgress(this.combat.getPlayerCurrentHealth() / (double)this.combat.getPlayerMaxHealth());

        if (this.combat.getEnemyCurrentHealth() <= 0) {
            this.finishChallenge(ChallengeStatus.WIN);
        } else if (this.combat.getPlayerCurrentHealth() <= 0) {
            this.finishChallenge(ChallengeStatus.LOSS);
        }
    }

    @FXML
    private void insult(ActionEvent event) {
        this.combat.round(Move.INSULT);
        this.enemyHealth.setProgress(this.combat.getEnemyCurrentHealth());
        this.playerHealth.setProgress(this.combat.getPlayerCurrentHealth());
    }

    @FXML
    private void run(ActionEvent event) {
        this.output.setText(this.combat.round(Move.RUN));
        if (this.combat.getPlayerCurrentHealth() <= 0) {
            this.finishChallenge(ChallengeStatus.LOSS);
        }
    }

    @FXML
    private void shoot(ActionEvent event) {
        this.combat.round(Move.SHOOT);
        this.enemyHealth.setProgress(this.combat.getEnemyCurrentHealth());
        this.playerHealth.setProgress(this.combat.getPlayerCurrentHealth());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Player player = new Player("Sean Cena", 100);
        Enemy enemy = new Enemy("Overtaker", 100);
        this.combat = new Combat(player, enemy);
    }

}
