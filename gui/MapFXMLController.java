package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Pair;
import world.World;

/**
 * FXML Controller class
 *
 * @author lucas.burdell
 */
public class MapFXMLController extends ChallengeController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView diaryImage;
    @FXML
    private AnchorPane mapPane;
    @FXML
    private ImageView tribalIsland;
    @FXML
    private ImageView caveIsland;
    @FXML
    private ImageView englishIsland;
    @FXML
    private ImageView tutorialIsland;
    @FXML
    private ImageView spanishIsland;
    @FXML
    private ImageView finalIsland;
    @FXML
    private ImageView pirateIsland;
    @FXML
    private Label finalIslandLabel;
    @FXML
    private Label finalIslandLabel2;
    @FXML
    private Text caveFragmentLabel;
    @FXML
    private Text spanishFragmentLabel;
    @FXML
    private Text pirateFragmentLabel;
    @FXML
    private Text englishFragmentLabel;
    @FXML
    private Text tribalFragmentLabel;

    private boolean[] mapPiecesFound = new boolean[4];

    // tutorial, english, spanish, pirates, tribe, cave, final
    /*
    private int[] islandEntranceIds = new int[]{
        79, // really should have entrance event handle checking if people already did things there
        100,
        300,
        500,
        700,
        900,
        1100
    };
     */
    private Pair<Integer, Integer>[] islandEventIds = new Pair[]{ // should be id that leads to map, island index
        // tutorial island
        new Pair<>(78, 0),
        new Pair<>(79, 0)

    };

    private ImageView[] islandViews;

    private boolean finalIslandUnlocked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void setupListeners(Scene scene) {
        World world = this.getWorld();
        for (int i = 0; i < mapPiecesFound.length; i++) {
            int flag = world.getFlag("mappiece" + (i + 1) + "found");
            mapPiecesFound[i] = flag == 1;
        }

        String strikethrough = this.getClass().getResource("strikethrough.css").toExternalForm();
        int piecesFound = 0;
        if (mapPiecesFound[0]) {
            //englishFragmentLabel.getStyleClass().add(strikethrough);
            englishFragmentLabel.setStrikethrough(true);
            piecesFound++;
        }
        if (mapPiecesFound[1]) {
            //spanishFragmentLabel.getStyleClass().add(strikethrough);
            spanishFragmentLabel.setStrikethrough(true);
            piecesFound++;
        }
        if (world.getFlag("piratedencompleted") == 1) {
            //pirateFragmentLabel.getStyleClass().add(strikethrough);
            pirateFragmentLabel.setStrikethrough(true);
            tribalFragmentLabel.setVisible(true);
        }
        if (mapPiecesFound[2]) {
            //tribalFragmentLabel.getStyleClass().add(strikethrough);
            tribalFragmentLabel.setStrikethrough(true);
            piecesFound++;
        }
        if (mapPiecesFound[3]) {
            //caveFragmentLabel.getStyleClass().add(strikethrough);
            caveFragmentLabel.setStrikethrough(true);
            piecesFound++;
        }
        finalIslandUnlocked = true;//piecesFound >= 4;
        finalIsland.setVisible(finalIslandUnlocked);
        finalIslandLabel.setVisible(finalIslandUnlocked);
        finalIslandLabel2.setVisible(finalIslandUnlocked);
        
        islandViews = new ImageView[]{
        tutorialIsland,
        englishIsland,
        spanishIsland,
        pirateIsland,
        tribalIsland,
        caveIsland,
        finalIsland
    };

    }

    @Override
    public void teardownListeners(Scene scene) {

    }

    @Override
    public void onChallengeLoaded() {

    }

    private ImageView checkIslandClick(Object object) {
        
        //System.out.println("Check clicked");
        //System.out.println("object: " + object + " of class " + object.getClass());
        
        for (int i = 0; i < islandViews.length; i++) {
            ImageView islandView = islandViews[i];
            if (object.equals(islandView)) {
                //System.out.println("clicked is island " + i);
                if (i == 6 && !finalIslandUnlocked) {
                    return null;
                } else {
                    return islandView;
                }
            }
        }
        return null;
    }

    @FXML
    private void onMouseExit(MouseEvent event) {
        ImageView islandView = checkIslandClick(event.getSource());
        if (islandView != null) {
            islandView.setEffect(null);
           //System.out.println(islandView.getImage() + " mouse left");
        }
    }

    @FXML
    private void onMouseEnter(MouseEvent event) {
        ImageView islandView = checkIslandClick(event.getSource());
        if (islandView != null) {
            //System.out.println("Applying effect to " + islandView.getImage());
            islandView.setEffect(new DropShadow(10, Color.GOLD));
        }
    }

    @FXML
    private void onMouseClick(MouseEvent event) {
        Object object = event.getSource();
        for (int i = 0; i < islandViews.length; i++) {
            ImageView islandView = islandViews[i];
            if (object.equals(islandView)) {
                if (i == 6 && !finalIslandUnlocked) {
                    return;
                } else {
                    //System.out.println(islandView.getImage() + " was clicked");
                    this.finishChallenge(i);
                    return;
                }
            }
        }
    }
}
