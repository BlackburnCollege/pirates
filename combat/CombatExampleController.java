package combat;

import gui.ChallengeController;
import gui.ChallengeStatus;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
    private ImageView enemyImage;
    @FXML
    private ImageView playerImage;

    @FXML
    private void attack(ActionEvent event) {
        this.output.setText(this.combat.round(Move.ATTACK));

        this.enemyHealth.setProgress(this.combat.getEnemyCurrentHealth() / (double) this.combat.getEnemyMaxHealth());
        this.playerHealth.setProgress(this.combat.getPlayerCurrentHealth() / (double) this.combat.getPlayerMaxHealth());

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
// maybe load background according to enemy type?
        mainPane.setBackground(new Background(
                new BackgroundImage(
                        new Image("resources/woods_background.png"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT
                )
        ));
    }

    @Override
    public void onChallengeLoaded() {
        String nameOfChallenger = this.getChallengeInformation();

        

        Player player = new Player("PLAYERNAME", 100);
        //TODO: LOAD ENEMY DATA FROM SOMEWHERE
        // pseudo example of what that might look like: 
        /* if nameOfChallenger.equals("wolf") {
            enemy.setHealth(wolfHealth)
            enemy.setAttacks(getWolfAttacks())
        }
         */

        try {
            enemyImage.setImage(new Image("resources/" + nameOfChallenger + ".jpg"));
        } catch (Exception e) {
            System.err.println("image not found for " + nameOfChallenger);
        }
        Enemy enemy = new Enemy(nameOfChallenger, 100);
        this.combat = new Combat(player, enemy);
    }
}
