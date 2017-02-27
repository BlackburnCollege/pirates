/*
 * Copyright (C) 2017 Lucas Burdell lucas.burdell@blackburn.edu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import world.*;

/**
 *
 * @author Lucas Burdell lucas.burdell@blackburn.edu
 */
public class GameController implements Initializable {

    private static final String IMAGE_LOCATION = "resources/";
    private static final int PADDING = 20;

    //private BorderPane background;
    @FXML
    private ImageView gameImage;
    @FXML
    private VBox controlContainer;
    @FXML
    private TextFlow gameControls;
    @FXML
    private TextFlow menuControls;
    @FXML
    private StackPane mediaPane;
    @FXML
    private MediaView gameMedia;
    @FXML
    private BorderPane gamePane;
    @FXML
    private StackPane mainPane;
    @FXML
    private Pane loaderPane;

    private Text makeText(String text) {
        Text newText = new Text(text + "\n");
        newText.setFont(Font.font("Consolas", 24));
       // newText.setFocusTraversable(false);
        return newText;
    }

    private AudioController musicController = AudioController.get();

    private void playMusic() {
        Random random = new Random();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int songNumber = random.nextInt(musicController.getResources().size());
                while (true) {
                    musicController.playSongAndYield(musicController.getResources().get(songNumber));
                    int lastPlayed = songNumber;
                    songNumber = random.nextInt(musicController.getResources().size());
                    int tries = 0;
                    while (songNumber == lastPlayed && tries < 5) {
                        songNumber = random.nextInt(musicController.getResources().size());
                        tries++;
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void setBackgrounds() {

        BackgroundSize properSizing = new BackgroundSize(1, 1, true, true, true, false);

        gamePane.setBackground(
                new Background(
                        new BackgroundImage(
                                new Image(IMAGE_LOCATION + "background.jpg"),
                                BackgroundRepeat.REPEAT,
                                BackgroundRepeat.REPEAT,
                                BackgroundPosition.CENTER,
                                properSizing
                        )
                )
        );
        gameControls.setBackground(new Background(
                new BackgroundImage(
                        new Image(IMAGE_LOCATION + "menu-text-background.jpg"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));
        menuControls.setBackground(new Background(
                new BackgroundImage(
                        new Image(IMAGE_LOCATION + "menu-text-background.jpg"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));
    }

    private void setBinds() {
        controlContainer.prefWidthProperty().bind(gamePane.widthProperty().divide(2).subtract(PADDING));
        controlContainer.prefHeightProperty().bind(gamePane.heightProperty().subtract(PADDING));

        gameControls.prefWidthProperty().bind(controlContainer.prefWidthProperty());

        menuControls.prefWidthProperty().bind(controlContainer.prefWidthProperty());
        menuControls.prefHeightProperty().bind(controlContainer.heightProperty().divide(3));
        //menuControls.setPrefHeight(controlContainer.heightProperty().divide(3).get());

        gameControls.prefHeightProperty().bind(controlContainer.prefHeightProperty().subtract(menuControls.prefHeightProperty()));

        gameImage.fitWidthProperty().bind(gamePane.widthProperty().divide(2).subtract(PADDING));
        gameImage.fitHeightProperty().bind(gamePane.heightProperty().subtract(PADDING));
        gameImage.setVisible(true);
    }

    private void addTextToDisplay(String text) {
        Text textObject = makeText(text);
        gameControls.getChildren().add(textObject);
    }

    private void clearDisplay() {
        gameControls.getChildren().clear();
    }

    private Hyperlink makeHyperlink(String text) {
        Hyperlink hyperLink = new Hyperlink(text);
        hyperLink.getStyleClass().add("textLink");
        hyperLink.setFocusTraversable(false);
        
        //hyperLink.setStyle("-fx-text-fill: black; -fx-underline: false");
        
        //hyperLink.setFocusTraversable(false);
        hyperLink.setFont(Font.font("Consolas", FontWeight.BOLD, 24));
        return hyperLink;
    }

    private void addHyperlinkToDisplay(Hyperlink link) {
        gameControls.getChildren().addAll(link, makeText(""));
    }

    private void addChoiceToDisplay(Choice choice) {
        Hyperlink hyperLink = makeHyperlink(choice.getText());
        hyperLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                processGameAction(choice.getAction());
            }
        });
        addHyperlinkToDisplay(hyperLink);
    }

    private boolean inventoryOpen = false;
    private boolean inventoryMoving = false;

    private void setupInventoryButton() {
        Hyperlink inventory = makeHyperlink("Inventory");
        inventory.setStyle("-fx-text-fill: black");
        inventory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (inventoryMoving) {
                    return;
                }
                
                menuControls.prefHeightProperty().unbind();

                double newHeight = 0;
                if (!inventoryOpen) {
                    newHeight = menuControls.prefHeightProperty().multiply(2).get();
                } else {
                    //menuControls.prefHeightProperty().bind(controlContainer.heightProperty().divide(3));
                    newHeight = controlContainer.heightProperty().divide(3).get();
                }

                inventoryMoving = true;
                menuControls.prefHeightProperty().unbind();
                Timeline inventoryTimeline = new Timeline();
                inventoryTimeline.setCycleCount(1);
                inventoryTimeline.setAutoReverse(false);
                inventoryTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(500),
                        new KeyValue(menuControls.prefHeightProperty(),
                                newHeight)));
                // TODO: INSERT A GRIDPANE AND RESIZE IT AS WELL AS THE MENU CONTROL PANEL
                inventoryTimeline.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        inventoryMoving = false;
                        inventoryOpen = !inventoryOpen;
                    }
                });
                inventoryTimeline.play();
            }
        });

        menuControls.getChildren().addAll(inventory, makeText(""));
    }

    private void setupExitButton() {
        Hyperlink exit = makeHyperlink("Exit Game");
        exit.setStyle("-fx-text-fill: black");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GuiLoader.getSingleton().getMainStage().close();
            }
        });
        menuControls.getChildren().add(exit);
    }
    
    /**
     * 
     * @param challenge
     * @return status code of challenge. Used to select next event in Action's 
     * event array. 
     */
    private int loadChallenge(Challenge challenge) {
        
        return 0; //RETURN STATUS CODE
    }
    
    private void processGameAction(Action action) {
        clearDisplay();
        addTextToDisplay(action.getText());
        Hyperlink next = makeHyperlink("next");
        int eventIndex = action.getDefaultEventIndex();
        next.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                processGameEvent(action.getEvents()[eventIndex]);
            }
            
        });
        
        addDividerToDisplay();
        addHyperlinkToDisplay(next);
        
        
        if (action.hasChallenge()) {  
            // TODO: CHALLENGE LOADING
            // eventIndex = loadChallenge(action.getChallenge());
            // 
            
        } 
        
        
        
        
        
    }
    
    private void addDividerToDisplay() {
        addTextToDisplay("==============");
    }

    private void processGameEvent(Event event) {
        clearDisplay();
        addTextToDisplay(event.getText());
        Image picture;
        try {
            picture = new Image(IMAGE_LOCATION + event.getPicture());
        } catch (Exception e) {
            picture = new Image(IMAGE_LOCATION + "gameimage.png");
        }
        gameImage.setImage(picture);
        
        addDividerToDisplay();
        
        for (Choice c : event.getChoices()) {
            addChoiceToDisplay(c);
        }
        
        if (event.getMusic() != null) {
            musicController.playSong(event.getMusic());
        }

    }

    private World world;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.world = new World("PlayerName");

        this.loaderPane.setDisable(true);
        // TODO

        /*
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("/combat/FXMLDocument.fxml"));
            loaderPane.getChildren().add(0, root);
            root.visibleProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue == false) {
                        loaderPane.getChildren().remove(root);
                        loaderPane.setDisable(true);
                    }
                }

            });
            //gamePane.visibleProperty().bind(root.visibleProperty().not());

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        
        // SET BORDERS
        Border border = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(2),
                new BorderWidths(10, 10, 10, 10)));
        gamePane.setBorder(border);
        gameControls.setBorder(border);
        menuControls.setBorder(border);

        // SET BACKGROUNDS
        setBackgrounds();

        // SET BINDS
        setBinds();
        setupInventoryButton();
        setupExitButton();

        processGameEvent(world.getCurrentEvent());
    }
}
