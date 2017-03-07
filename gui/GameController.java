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
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
    private TextFlow gamePanel;
    @FXML
    private TextFlow menuPanel;
    @FXML
    private StackPane mediaPane;
    @FXML
    private MediaView gameMedia;
    @FXML
    private BorderPane gameContainer;
    @FXML
    private StackPane mainPane;
    @FXML
    private Pane challengePane;

    // The world
    private World world;
    private boolean inventoryOpen = false;
    private boolean inventoryMoving = false;

    /**
     *
     * @param text create a text to display
     * @return return the Text object
     */
    private Text makeText(String text) {
        Text newText = new Text(text + "\n");
        newText.setFont(Font.font("Consolas", 24));
        // newText.setFocusTraversable(false);
        return newText;
    }

    // create audio controller 
    private final AudioController musicController = AudioController.get();

    /**
     * old playMusic loop method
     */
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

    /**
     * setup backgrounds for the different panels
     *
     */
    private void setBackgrounds() {

        BackgroundSize properSizing = new BackgroundSize(1, 1, true, true, true, false);

        gameContainer.setBackground(
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
        gamePanel.setBackground(new Background(
                new BackgroundImage(
                        new Image(IMAGE_LOCATION + "menu-text-background.jpg"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));
        menuPanel.setBackground(new Background(
                new BackgroundImage(
                        new Image(IMAGE_LOCATION + "menu-text-background.jpg"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));
    }

    /**
     * setup the property binds for the different sizes and positions
     */
    private void setBinds() {
        controlContainer.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        controlContainer.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));

        gamePanel.prefWidthProperty().bind(controlContainer.prefWidthProperty());

        menuPanel.prefWidthProperty().bind(controlContainer.prefWidthProperty());
        menuPanel.prefHeightProperty().bind(controlContainer.heightProperty().divide(3));
        //menuControls.setPrefHeight(controlContainer.heightProperty().divide(3).get());

        gamePanel.prefHeightProperty().bind(controlContainer.prefHeightProperty().subtract(menuPanel.prefHeightProperty()));

        gameImage.fitWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        gameImage.fitHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
        gameImage.setVisible(true);
    }

    /**
     * Adds a string of text to the game text panel. Appends a newline character
     * to the end of the string.
     *
     * @param text the text to add
     */
    private void addTextToDisplay(String text) {
        Text textObject = makeText(text);
        gamePanel.getChildren().add(textObject);
    }

    /**
     * clear the display
     */
    private void clearDisplay() {
        gamePanel.getChildren().clear();
    }

    /**
     * Build a Hyperlink object to game text panel. The Hyperlinks are
     * click-able Text on the screen.
     *
     * @param text The text of the Hyperlink
     * @return the Hyperlink
     */
    private Hyperlink makeHyperlink(String text) {
        Hyperlink hyperLink = new Hyperlink(text);
        hyperLink.getStyleClass().add("textLink");
        hyperLink.setFocusTraversable(false);

        //hyperLink.setStyle("-fx-text-fill: black; -fx-underline: false");
        //hyperLink.setFocusTraversable(false);
        hyperLink.setFont(Font.font("Consolas", FontWeight.BOLD, 24));
        return hyperLink;
    }

    /**
     * Adds a Hyperlink to the game text panel.
     *
     * @param link the Hyperlink to add.
     */
    private void addHyperlinkToDisplay(Hyperlink link) {
        gamePanel.getChildren().addAll(link, makeText(""));
    }

    /**
     * Add a choice to the game text panel. This builds a Hyperlink out of the
     * Choice object and adds a listener to the Hyperlink to process the
     * Choice's Event object on click.
     *
     * @param choice
     */
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

    /**
     * Setup the inventory Hyperlink and add it to the menu panel.
     */
    private void setupInventoryButton() {
        Hyperlink inventory = makeHyperlink("Inventory");
        inventory.setStyle("-fx-text-fill: black");
        inventory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (inventoryMoving) {
                    return;
                }

                menuPanel.prefHeightProperty().unbind();

                double newHeight;
                if (!inventoryOpen) {
                    newHeight = menuPanel.prefHeightProperty().multiply(2).get();
                } else {
                    //menuControls.prefHeightProperty().bind(controlContainer.heightProperty().divide(3));
                    newHeight = controlContainer.heightProperty().divide(3).get();
                }

                inventoryMoving = true;
                menuPanel.prefHeightProperty().unbind();
                Timeline inventoryTimeline = new Timeline();
                inventoryTimeline.setCycleCount(1);
                inventoryTimeline.setAutoReverse(false);
                inventoryTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(500),
                        new KeyValue(menuPanel.prefHeightProperty(),
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

        menuPanel.getChildren().addAll(inventory, makeText(""));
    }

    /**
     * setup the exit Hyperlink and add it to the menu panel.
     */
    private void setupExitButton() {
        Hyperlink exit = makeHyperlink("Exit Game");
        exit.setStyle("-fx-text-fill: black");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GuiLoader.getSingleton().getMainStage().close();
            }
        });
        menuPanel.getChildren().add(exit);
    }

    private HashMap<String, String> puzzleControllers = new HashMap<>();

    /**
     * @param action the Action the challenge belongs to
     */
    private void loadChallenge(Action action) {

        FXMLLoader loader = null;
        Pane root = null;
        ChallengeController controller = null;
        //load controller
        if (action.getChallenge().getType().equals("combat")) {
            try {
                loader = new FXMLLoader(getClass().getResource(
                        "/combat/CombatExampleFXML.fxml"));
                root = (Pane) loader.load();
                controller = loader.getController();
                controller.setChallengeInformation(action.getChallenge().getChallengeName());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else if (action.getChallenge().getType().equals("puzzle")) {
            try {
                // TODO: PUZZLE LOADING
                loader = new FXMLLoader(getClass().getResource(
                        puzzleControllers.get(action.getChallenge()
                                .getChallengeName())));
                root = (Pane) loader.load();
                controller = loader.getController();
                controller.setChallengeInformation(action.getChallenge().getChallengeName());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        challengePane.getChildren().add(0, root);
        challengePane.setDisable(false);
        final Pane challengeRoot = root;

        controller.setOnChallengeFinish(new ChallengeCallback() {
            @Override
            public void challengeCompleted(ChallengeStatus status) {
                challengePane.getChildren().remove(challengeRoot);
                challengePane.setDisable(true);
                processGameEvent(action.getEvents()[status.ordinal()]);
            }

        });

        /*
        code for loading FXML 
        just an example
        
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
    }

    /**
     * Process an Action from the world package. This shows the Action's text,
     * displays a "next" button, checks for a challenge, and then displays it.
     *
     * @param action the Action to process
     */
    private void processGameAction(Action action) {
        clearDisplay();
        if (action.getText() != null) {
            addTextToDisplay(action.getText());

            Hyperlink next = makeHyperlink("next");
            for (Modifier modifier : action.getModifiers()) {
                if (modifier != null) {
                    modifier.modify();
                }
            }
            next.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (action.hasChallenge()) {
                        // TODO: CHALLENGE LOADING
                        loadChallenge(action);

                        processGameEvent(action.getEvents()[action.getDefaultEventIndex()]);
                    } else {
                        processGameEvent(action.getEvents()[action.getDefaultEventIndex()]);
                    }
                }

            });

            addDividerToDisplay();
            addHyperlinkToDisplay(next);
        } else if (action.hasChallenge()) {
            loadChallenge(action);
            //processGameEvent(action.getEvents()[action.getDefaultEventIndex()]);
        } else {
            processGameEvent(action.getEvents()[action.getDefaultEventIndex()]);
        }
    }

    /**
     * Adds a divider to the game text panel.
     */
    private void addDividerToDisplay() {
        addTextToDisplay("==============");
    }

    /**
     * Processes Event objects from the world package. Places the game image,
     * adds the event's text to the display, and adds the Event's choices.
     *
     * @param event The event to process
     */
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
            if (c.checkConditions()) {
                addChoiceToDisplay(c);
            }
        }

        if (event.getMusic() != null) {
            musicController.playSong(event.getMusic());
        }

    }
    
    private void buildPuzzleControllerMappings(){
        this.puzzleControllers.put("fish", "/puzzle/PuzzleFishingFXML.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.world = new World("PlayerName");

        // close challenge pane
        this.challengePane.setDisable(true);

        // SET BORDERS
        Border border = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(2),
                new BorderWidths(10, 10, 10, 10)));
        gameContainer.setBorder(border);
        gamePanel.setBorder(border);
        menuPanel.setBorder(border);

        // SET BACKGROUNDS
        setBackgrounds();

        // SET BINDS
        setBinds();
        setupInventoryButton();
        setupExitButton();
        buildPuzzleControllerMappings();
        processGameEvent(world.getCurrentEvent());
    }
}
