package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import world.Player;

/**
 * FXML Controller class
 *
 * @author lucas.burdell
 */
public class PlayerFXMLController
        implements Initializable {

    @FXML
    private TextField playerNameField;
    @FXML
    private Button enterButton;
    @FXML
    private AnchorPane mediaPane;
    @FXML
    private ImageView diaryImage;
    @FXML
    private MediaView gameMedia;
    @FXML
    private ImageView gameImage;
    @FXML
    private AnchorPane mediaPane1;
    @FXML
    private ImageView diaryPageImage;
    @FXML
    private ImageView fakeGameImage;

    private static final int PADDING = 20;
    @FXML
    private RadioButton playerMale;
    @FXML
    private ToggleGroup playerGender;
    @FXML
    private RadioButton playerFemale;
    @FXML
    private RadioButton spouseMale;
    @FXML
    private ToggleGroup spouseGender;
    @FXML
    private RadioButton spouseFemale;
    @FXML
    private VBox gamePane;
    @FXML
    private StackPane mainPane;
    @FXML
    private BorderPane gameContainer;
    @FXML
    private StackPane challengePane;

    private void setBinds() {
        //menuControls.setPrefHeight(controlContainer.heightProperty().divide(3).get());


        mediaPane.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        mediaPane.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
        mediaPane1.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        mediaPane1.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
        gamePane.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        gamePane.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
        
        //gameImage.fitWidthProperty().bind(mediaPane.widthProperty().divide(2).subtract(PADDING));
        gameImage.fitHeightProperty().bind(mediaPane.prefHeightProperty().subtract(PADDING * 4));
        gameImage.fitWidthProperty().bind(mediaPane.prefWidthProperty().subtract(PADDING * 4));

        fakeGameImage.fitHeightProperty().bind(mediaPane1.prefHeightProperty().subtract(PADDING * 4));
        fakeGameImage.fitWidthProperty().bind(mediaPane1.prefWidthProperty().subtract(PADDING * 4));

        //gameImage.fitHeightProperty().bind(mediaPane.heightProperty().subtract(PADDING));
        gameImage.setVisible(true);
        diaryImage.fitHeightProperty().bind(mediaPane.prefHeightProperty());
        diaryImage.fitWidthProperty().bind(mediaPane.prefWidthProperty());
        diaryPageImage.fitHeightProperty().bind(mediaPane1.prefHeightProperty());
        diaryPageImage.fitWidthProperty().bind(mediaPane1.prefWidthProperty());

        diaryImage.setVisible(true);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        gamePane.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        gamePane.maxWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        gamePane.prefHeightProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        gamePane.maxHeightProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
         */

        //mediaPane.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        //mediaPane.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
        /*
        mediaPane1.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        mediaPane1.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));

        //gameImage.fitWidthProperty().bind(mediaPane.widthProperty().divide(2).subtract(PADDING));
        gameImage.fitHeightProperty().bind(mediaPane.prefHeightProperty().subtract(PADDING * 4));
        gameImage.fitWidthProperty().bind(mediaPane.prefWidthProperty().subtract(PADDING * 4));

        fakeGameImage.fitHeightProperty().bind(mediaPane1.prefHeightProperty().subtract(PADDING * 4));
        fakeGameImage.fitWidthProperty().bind(mediaPane1.prefWidthProperty().subtract(PADDING * 4));

        //gameImage.fitHeightProperty().bind(mediaPane.heightProperty().subtract(PADDING));
        gameImage.setVisible(true);
        diaryImage.fitHeightProperty().bind(mediaPane.prefHeightProperty());
        diaryImage.fitWidthProperty().bind(mediaPane.prefWidthProperty());
        diaryPageImage.fitHeightProperty().bind(mediaPane1.prefHeightProperty());
        diaryPageImage.fitWidthProperty().bind(mediaPane1.prefWidthProperty());
         */
        setBinds();
        mediaPane1.scaleXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPane1.setTranslateX(-mediaPane.getPrefWidth() * (1 - mediaPane1.getScaleX()));
            }

        });

        diaryImage.setVisible(true);

        EventHandler<ActionEvent> playerSelectHandle = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource().equals(playerMale)) {
                    changeImage(ImageController.get().getImage("player_male_front_0"));
                } else {
                    changeImage(ImageController.get().getImage("player_female_front_0"));
                }
            }

        };

        playerMale.setOnAction(playerSelectHandle);
        playerFemale.setOnAction(playerSelectHandle);
        changeImage(ImageController.get().getImage("player_male_front_0"));
    }

    public void changeImage(Image image) {
        ScaleTransition st = new ScaleTransition(Duration.millis(400), mediaPane1);
        fakeGameImage.setImage(gameImage.getImage());
        mediaPane1.setVisible(true);
        gameImage.setImage(image);

        st.setToX(-.5);
        st.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPane1.setVisible(false);
                mediaPane1.setScaleX(1.0);
            }
        });
        st.play();
    }

    @FXML
    private void startGame(ActionEvent event) {
        Player player = new Player(playerNameField.getText());
        System.err.println(playerNameField.getText());
        player.setMale(playerMale.isSelected());
        player.setSpouseMale(spouseMale.isSelected());
        GuiLoader.getSingleton().showLoadingScreen(player);
    }
}
