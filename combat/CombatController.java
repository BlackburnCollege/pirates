package combat;

import gui.ChallengeController;
import gui.ChallengeStatus;
import gui.ImageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import sql.EntitySQLLoader;

/**
 *
 * @author dakota.tebbe
 */
public class CombatController extends ChallengeController
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

    private ImageController images = ImageController.get();
    @FXML
    private ImageView battleImage;
    @FXML
    private ImageView diaryImage;

    @FXML
    private void attack(ActionEvent event) {
        this.output.setText(this.combat.round(Move.ATTACK));

        this.enemyHealth.setProgress(this.combat.getEnemyHealthDouble());
        this.playerHealth.setProgress(this.combat.getPlayerHealthDouble());

        this.healthCheck();
    }

    @FXML
    private void insult(ActionEvent event) {
        this.output.setText(this.combat.round(Move.INSULT));

        this.enemyHealth.setProgress(this.combat.getEnemyHealthDouble());
        this.playerHealth.setProgress(this.combat.getPlayerHealthDouble());

        this.healthCheck();
    }

    @FXML
    private void shoot(ActionEvent event) {
        this.output.setText(this.combat.round(Move.SHOOT));

        this.enemyHealth.setProgress(this.combat.getEnemyHealthDouble());
        this.playerHealth.setProgress(this.combat.getPlayerHealthDouble());

        this.healthCheck();
    }

    private void healthCheck() {
        if (this.combat.getEnemyHealthDouble() <= 0) {
            this.finishChallenge(ChallengeStatus.WIN);
        } else if (this.combat.getPlayerHealthDouble() <= 0) {
            this.finishChallenge(ChallengeStatus.LOSS);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*
        mainPane.setBackground(new Background(
                new BackgroundImage(
                        images.getImage("diary_page_0"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(1, 1, true, true, true, true)
                )
        ));
        */
        diaryImage.setImage(images.getImage("whole_diary_0"));
    }

    @Override
    public void onChallengeLoaded() {
        String nameOfChallenger = this.getChallengeInformation();
        EntitySQLLoader load;

        load = new EntitySQLLoader("Demo Drew");
        
        
        

        CombatPlayer player = new CombatPlayer(load.getName(), load.getHealth(), load.getMeleeModifier(), load.getRangedModifier(), load.getVerbalModifier(), load.isInsultImmune());

        enemyImage.setImage(images.getImage(nameOfChallenger));
        Image enemyBackground = images.getImage(nameOfChallenger + "_background");
        battleImage.setImage(enemyBackground);
        load = new EntitySQLLoader(nameOfChallenger);

        Enemy enemy = new Enemy(load.getName(), load.getHealth(), load.getMeleeModifier(), load.getRangedModifier(), load.getVerbalModifier(), load.isInsultImmune());
        this.combat = new Combat(player, enemy);
    }

    @Override
    public void setupListeners(Scene scene) {

    }

    @Override
    public void teardownListeners(Scene scene) {

    }
}
