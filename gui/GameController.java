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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
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
    private AnchorPane mediaPane;
    @FXML
    private MediaView gameMedia;
    @FXML
    private BorderPane gameContainer;
    @FXML
    private StackPane mainPane;
    @FXML
    private Pane challengePane;
    @FXML
    private ScrollPane gameScroll;
    @FXML
    private ScrollPane menuScroll;
    @FXML
    private ImageView diaryImage;

    private Scene scene;

    // The world
    private World world;
    private boolean inventoryOpen = false;
    private boolean inventoryMoving = false;
    private HashMap<String, String> puzzleControllers = new HashMap<>();
    private final AudioController musicController = AudioController.get();
    private final ImageController images = ImageController.get();
    @FXML
    private AnchorPane mediaPane1;
    @FXML
    private ImageView diaryPageImage;
    @FXML
    private ImageView fakeGameImage;

    private void buildPuzzleControllerMappings() {
        this.puzzleControllers.put("safecrack", "/puzzle/PuzzleSafeCrackGUI.fxml");
        this.puzzleControllers.put("fish", "/puzzle/PuzzleFishGUI.fxml");
        this.puzzleControllers.put("binary", "/puzzle/PuzzleBinarySwitchGUI.fxml");
        this.puzzleControllers.put("caesar", "/puzzle/PuzzleCaesarCipherGUI.fxml");
        this.puzzleControllers.put("final", "/puzzle/PuzzleFinalGUI.fxml");
        this.puzzleControllers.put("flower", "/puzzle/PuzzleFlowerGUI.fxml");
    }

    // TEXT PATTERNS
    // special pattern
    Pattern specialPattern = Pattern.compile("\\$(.*?)\\$");

    Pattern shipNamePattern = Pattern.compile("SHIP_NAME");
    Pattern playerNamePattern = Pattern.compile("PLAYER_NAME");
    Pattern spouseNamePattern = Pattern.compile("SPOUSE_NAME");
    Pattern spousePronounPattern = Pattern.compile("SPOUSE_PRONOUN");
    Pattern spousePosessivePronounPattern = Pattern.compile("SPOUSE_POSESSIVE");
    Pattern spouseTitlePattern = Pattern.compile("SPOUSE_MARITAL_TITLE");
    Pattern playerPronounPattern = Pattern.compile("PLAYER_PRONOUN");
    Pattern playerPosessivePronounPattern = Pattern.compile("PLAYER_POSESSIVE");
    Pattern redPattern = Pattern.compile("RED\\{(.*?)\\}");

    private String parseText(String text) {
        StringBuilder output = new StringBuilder();
        Matcher specialCheck = specialPattern.matcher(text);
        if (specialCheck.find()) {
            //System.out.println("MATCHED");
            // check for patterns
            specialCheck.reset();
            int previousTextEnd = 0;
            while (specialCheck.find()) {
                // do previous
                String previousText = text.substring(previousTextEnd, specialCheck.start());
                //System.out.println(previousText);
                output.append(previousText);
                previousTextEnd = specialCheck.end();

                //start checks
                String special = specialCheck.group(1);
                Matcher redMatcher = redPattern.matcher(special);
                Matcher shipMatcher = shipNamePattern.matcher(special);
                Matcher playerMatcher = playerNamePattern.matcher(special);
                Matcher spouseMatcher = spouseNamePattern.matcher(special);
                Matcher spousePronounMatcher = spousePronounPattern.matcher(special);
                Matcher spousePosessivePronounMatcher = spousePosessivePronounPattern.matcher(special);
                Matcher playerPronounMatcher = playerPronounPattern.matcher(special);
                Matcher playerPosessivePronounMatcher = playerPosessivePronounPattern.matcher(special);
                Matcher spouseTitleMatcher = spouseTitlePattern.matcher(special);

                if (redMatcher.find()) {
                    String matchedText = redMatcher.group(1);
                   output.append(matchedText);
                } else if (shipMatcher.find()) {
                    output.append((world.getShipName()));
                } else if (playerMatcher.find()) {
                  output.append((world.getPlayer().getName()));
                } else if (playerPronounMatcher.find()) {
                  output.append((world.getPlayer().getPronoun()));
                } else if (playerPosessivePronounMatcher.find()) {
                    output.append((world.getPlayer().getPosessivePronoun()));
                } else if (spouseMatcher.find()) {
                    output.append((world.getPlayer().getSpouseName()));
                } else if (spousePronounMatcher.find()) {
                    output.append((world.getPlayer().getSpousePronoun()));
                } else if (spousePosessivePronounMatcher.find()) {
                   output.append((world.getPlayer().getSpousePosessivePronoun()));
                } else if (spouseTitleMatcher.find()) {
                    output.append((world.getPlayer().getSpouseMaritalTitle()));
                } else {
                    output.append((special));
                }
            }

            if (previousTextEnd <= text.length() - 1) {
                String remainingText = text.substring(previousTextEnd, text.length());
                output.append((remainingText));

            }

        } else {
            //System.out.println("no match");
            output.append(text);
        }
        return output.toString();
    }

    /**
     *
     * @param text create a text to display
     * @return return the Text object
     */
    private Text[] buildText(String text) {
        ArrayList<Text> texts = new ArrayList<>();
        Matcher specialCheck = specialPattern.matcher(text);
        if (specialCheck.find()) {
            //System.out.println("MATCHED");
            // check for patterns
            specialCheck.reset();
            int previousTextEnd = 0;
            while (specialCheck.find()) {
                // do previous
                String previousText = text.substring(previousTextEnd, specialCheck.start());
                //System.out.println(previousText);
                texts.add(makeTextObject(previousText));
                previousTextEnd = specialCheck.end();

                //start checks
                String special = specialCheck.group(1);
                Matcher redMatcher = redPattern.matcher(special);
                Matcher shipMatcher = shipNamePattern.matcher(special);
                Matcher playerMatcher = playerNamePattern.matcher(special);
                Matcher spouseMatcher = spouseNamePattern.matcher(special);
                Matcher spousePronounMatcher = spousePronounPattern.matcher(special);
                Matcher spousePosessivePronounMatcher = spousePosessivePronounPattern.matcher(special);
                Matcher playerPronounMatcher = playerPronounPattern.matcher(special);
                Matcher playerPosessivePronounMatcher = playerPosessivePronounPattern.matcher(special);
                Matcher spouseTitleMatcher = spouseTitlePattern.matcher(special);

                if (redMatcher.find()) {
                    String matchedText = redMatcher.group(1);
                    Text matchedTextObject = makeTextObject(matchedText);
                    matchedTextObject.setFill(Paint.valueOf("red"));
                    texts.add(matchedTextObject);
                } else if (shipMatcher.find()) {
                    texts.add(makeTextObject(world.getShipName()));
                } else if (playerMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getName()));
                } else if (playerPronounMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getPronoun()));
                } else if (playerPosessivePronounMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getPosessivePronoun()));
                } else if (spouseMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getSpouseName()));
                } else if (spousePronounMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getSpousePronoun()));
                } else if (spousePosessivePronounMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getSpousePosessivePronoun()));
                } else if (spouseTitleMatcher.find()) {
                    texts.add(makeTextObject(world.getPlayer().getSpouseMaritalTitle()));
                } else {
                    texts.add(makeTextObject(special));
                }
            }

            if (previousTextEnd <= text.length() - 1) {
                String remainingText = text.substring(previousTextEnd, text.length());
                texts.add(makeTextObject(remainingText + "\n"));

            }

        } else {
            //System.out.println("no match");
            Text newText = makeTextObject(text + "\n");
            texts.add(newText);
        }
        return texts.toArray(new Text[texts.size()]);
    }

    private Text makeTextObject(String text) {
        Text newText = new Text(text);
        newText.setFont(Font.font("Consolas", 24));
        return newText;
    }

    private final Animation fadeOutAnimation = new Transition() {

        {
            setCycleDuration(Duration.millis(250));
            setInterpolator(Interpolator.EASE_OUT);
        }

        @Override
        protected void interpolate(double frac) {
            Color vColor = new Color(0, 0, 0, 1 - frac);
            challengePane.setBackground(new Background(new BackgroundFill(vColor, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    };

    private final Animation fadeInAnimation = new Transition() {

        {
            setCycleDuration(Duration.millis(250));
            setInterpolator(Interpolator.EASE_IN);
        }

        @Override
        protected void interpolate(double frac) {
            Color vColor = new Color(0, 0, 0, frac);
            challengePane.setBackground(new Background(new BackgroundFill(vColor, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    };

    /**
     * setup backgrounds for the different panels
     *
     */
    private void setBackgrounds() {

        BackgroundSize properSizing = new BackgroundSize(1, 1, true, true, true, true);

        gameContainer.setBackground(
                new Background(
                        new BackgroundImage(
                                images.getImage("game_background"),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                properSizing
                        )
                )
        );
        gamePanel.setBackground(new Background(
                new BackgroundImage(
                        images.getImage("menu-text-background"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));
        menuPanel.setBackground(new Background(
                new BackgroundImage(
                        images.getImage("menu-text-background"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
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
        controlContainer.maxWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        controlContainer.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
        //controlContainer.setPrefWidth(controlContainer.getScene().getWidth() / 3 - PADDING);
        //controlContainer.setPrefHeight(controlContainer.getScene().getHeight() / 2 - PADDING);

        gameScroll.prefWidthProperty().bind(controlContainer.prefWidthProperty());

        menuScroll.prefWidthProperty().bind(controlContainer.prefWidthProperty());
        menuScroll.prefHeightProperty().bind(controlContainer.heightProperty().divide(3));
        menuScroll.prefViewportHeightProperty().bind(menuScroll.prefHeightProperty());

        menuPanel.prefHeightProperty().bind(menuScroll.heightProperty().subtract(20));
        //menuControls.setPrefHeight(controlContainer.heightProperty().divide(3).get());

        gameScroll.prefHeightProperty().bind(controlContainer.prefHeightProperty().subtract(menuScroll.prefHeightProperty()));
        gameScroll.prefViewportHeightProperty().bind(gameScroll.prefHeightProperty());
        gamePanel.minHeightProperty().bind(gameScroll.heightProperty().subtract(20));

        mediaPane.prefWidthProperty().bind(gameContainer.widthProperty().divide(2).subtract(PADDING));
        mediaPane.prefHeightProperty().bind(gameContainer.heightProperty().subtract(PADDING));
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

        diaryImage.setVisible(true);
    }

    /**
     * Adds a string of text to the game text panel. Appends a newline character
     * to the end of the string.
     *
     * @param text the text to add
     */
    private void addTextToDisplay(String text) {
        Text[] textObject = buildText(text);
        gamePanel.getChildren().addAll(textObject);
    }

    /**
     * clear the display
     */
    private void clearDisplay() {
        gamePanel.getChildren().clear();
    }

    /**
     * Build a Hyperlink object to game text panel. The Hyperlinks are
     * click-able TextField on the screen.
     *
     * @param text The text of the Hyperlink
     * @return the Hyperlink
     */
    private Label makeHyperlink(String text) {
        /*
        Hyperlink hyperLink = new Hyperlink(text);
        hyperLink.getStyleClass().add("textLink");
        hyperLink.setFocusTraversable(false);

        //hyperLink.setStyle("-fx-text-fill: black; -fx-underline: false");
        //hyperLink.setFocusTraversable(false);
        hyperLink.setFont(Font.font("Consolas", FontWeight.BOLD, 24));
         */
        Label button = new Label();
        button.setText(parseText(text));
        //button.setEditable(false);
        button.getStyleClass().add("textlink");
        button.setFocusTraversable(false);
        button.setBackground(Background.EMPTY);
        button.setWrapText(true);
        button.setTextAlignment(TextAlignment.JUSTIFY);
        button.prefWidthProperty().bind(gamePanel.widthProperty());
        button.setPrefHeight(Control.USE_COMPUTED_SIZE);
        button.requestLayout();

        //button.prefWidthProperty().bind(gamePanel.prefWidthProperty());
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setCursor(Cursor.HAND);
            }
        });
        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setCursor(Cursor.DEFAULT);
            }

        });
        //ScrollBar scrollBarv = (ScrollBar) button.lookup(".scroll-bar:vertical");
        //scrollBarv.setDisable(true);
        button.setFont(Font.font("Consolas", FontWeight.BOLD, 24));
        return button;
    }

    /**
     * Adds a Hyperlink to the game text panel.
     *
     * @param link the Hyperlink to add.
     */
    private void addHyperlinkToDisplay(Label link) {
        gamePanel.getChildren().add(link);
        gamePanel.getChildren().addAll(buildText(""));
    }

    /**
     * Add a choice to the game text panel. This builds a Hyperlink out of the
     * Choice object and adds a listener to the Hyperlink to process the
     * Choice's Event object on click.
     *
     * @param choice
     */
    private void addChoiceToDisplay(Choice choice) {
        Label hyperLink = makeHyperlink(choice.getText());
        hyperLink.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // PLAY CLICK SOUND
                musicController.playSound(Sound.CLICK);
                processGameAction(choice.getAction());
            }
        });
        addHyperlinkToDisplay(hyperLink);
    }

    /**
     * Setup the inventory Hyperlink and add it to the menu panel.
     */
    private void setupInventoryButton() {

    }

    /**
     * setup the exit Hyperlink and add it to the menu panel.
     */
    private void setupExitButton() {
        Label exit = makeHyperlink("Exit Game");
        exit.setStyle("-fx-text-fill: black");
        exit.setAlignment(Pos.CENTER);
        exit.setTextAlignment(TextAlignment.CENTER);
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GuiLoader.getSingleton().getMainStage().close();
                System.exit(0);
            }
        });
        menuPanel.getChildren().add(exit);
    }

    /**
     * @param action the Action the challenge belongs to
     */
    private void loadChallenge(Action action) {

        FXMLLoader loader = null;
        Parent root = null;
        ChallengeController controller = null;
        //load controller
        if (action.getChallenge().getType().equals("combat")) {
            try {
                loader = new FXMLLoader(getClass().getResource(
                        "/combat/CombatFXML.fxml"));
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
                root = (Parent) loader.load();
                controller = loader.getController();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else if (action.getChallenge().getType().equals("other")) {
            try {
                if (action.getChallenge().getChallengeName().equals("shipname")) {
                    loader = new FXMLLoader(getClass().getResource(
                            "/gui/ShipNameFXML.fxml"));
                    root = (Pane) loader.load();
                    controller = loader.getController();
                } else if (action.getChallenge().getChallengeName().equals("map")) {
                    loader = new FXMLLoader(getClass().getResource(
                            "/gui/MapFXML.fxml"));
                    root = (Pane) loader.load();
                    controller = loader.getController();
                } else if (action.getChallenge().getChallengeName().equals("credits")) {
                    loader = new FXMLLoader(getClass().getResource(
                            "/gui/CreditsFXML.fxml"));
                    root = (Pane) loader.load();
                    controller = loader.getController();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        challengePane.setDisable(false);
        //challengePane.setStyle("-fx-background-color: #000000FF");
        fadeInAnimation.play();

        final Parent challengeRoot = root;
        final Scene sceneRef = this.mainPane.getScene();

        final ChallengeController finalController = controller;
        final Parent finalRoot = root;
        // wait for animation to finish before loading new screen in
        fadeInAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                challengePane.getChildren().add(0, finalRoot);
            }
        });
        finalController.setOnChallengeFinish(new ChallengeCallback() {
            @Override
            public void challengeCompleted(ChallengeStatus status) {
                this.challengeCompleted(status.ordinal());
            }

            @Override
            public void challengeCompleted(int status) {
                challengePane.getChildren().clear();
                challengePane.setDisable(true);
                //challengePane.setStyle("-fx-background-color: #00000000");
                fadeOutAnimation.play();
                try {
                    processGameEvent(action.getEvents()[status]);
                } catch (RuntimeException re) {
                    System.err.println("Error thrown after Action "
                            + "" + action.getID() + "'s Challenge " +
                            action.getChallenge().getID() + "tried to load event"
                            + " at position " + status);
                    throw re;
                    
                }
                
                finalController.teardownListeners(sceneRef);
            }

        });
        finalController.setChallengeInformation(action.getChallenge().getChallengeName());
        finalController.setWorld(world);
        finalController.onChallengeLoaded();
        finalController.setupListeners(GameController.this.mainPane.getScene());

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

            Label next = makeHyperlink("next");
            action.doConditionalModifiers(this.world.getStoryFlags());
            next.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (action.hasChallenge()) {
                        musicController.playSound(Sound.SWORD_SWISH);
                        loadChallenge(action);
                    } else {
                        musicController.playSound(Sound.CLICK);
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
            action.doConditionalModifiers(this.world.getStoryFlags());
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
        if (event == null) {
            throw new RuntimeException("Event was null! Check for insert errors "
                    + "in your SQL output!");
        }
        clearDisplay();
        addTextToDisplay(event.getText());
        Image picture;
        world.setCurrentEvent(event);
        try {
            picture = images.getImage(event.getPicture());
        } catch (Exception e) {
            picture = null;
        }
        //gameImage.setImage(picture);
        if (picture == null) {
            picture = gameImage.getImage(); // use last image
        } else {
            changeImage(picture);
        }

        addDividerToDisplay();

        for (Choice c : event.getChoices()) {
            if (c.checkConditions(this.world.getStoryFlags())) {
                //System.out.println("Displaying " + c.getID() + " " + c.getText());
                addChoiceToDisplay(c);
            }
        }

        if (event.getMusic() != null) {
            musicController.playSong(event.getMusic());
        }

    }

    public void startGame(World world) {
        this.world = world;
        processGameEvent(world.getCurrentEvent());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // close challenge pane
        this.challengePane.setDisable(true);

        // SET BORDERS
        Border border = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(2),
                new BorderWidths(10, 10, 10, 10)));
        //gameContainer.setBorder(border);
//        gamePanel.setBorder(border);
//        menuPanel.setBorder(border);
        gameScroll.setBorder(border);
        menuScroll.setBorder(border);
        gameScroll.getStyleClass().add("edge-to-edge");
        gameScroll.setStyle("-fx-background-color: transparent");
        menuScroll.getStyleClass().add("edge-to-edge");
        menuScroll.setStyle("-fx-background-color: transparent");

        // SET BACKGROUNDS
        setBackgrounds();
        diaryPageImage.setImage(images.getImage("diary_page_without_border_0"));
        diaryImage.setImage(images.getImage("diary_page_0"));

        mediaPane1.scaleXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPane1.setTranslateX(-mediaPane.getPrefWidth() * (1 - mediaPane1.getScaleX()));
            }

        });

        // SET BINDS
        setBinds();
        setupInventoryButton();
        setupExitButton();
        buildPuzzleControllerMappings();
    }

    public void changeImage(Image image) {
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), mediaPane1);
        fakeGameImage.setImage(gameImage.getImage());
        mediaPane1.setVisible(true);
        gameImage.setImage(image);

        st.setToX(-1f);
        st.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPane1.setVisible(false);
                mediaPane1.setScaleX(1.0);
            }
        });
        st.play();
        //st.setByY(1.5f);
        //st.setCycleCount(4f);
        //st.setAutoReverse(true);

    }

    /**
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @param scene the scene to set
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
