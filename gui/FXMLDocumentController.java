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

import java.awt.Stroke;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author Lucas Burdell lucas.burdell@blackburn.edu
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private BorderPane background;
    @FXML
    private ImageView gameImage;
    @FXML
    private VBox controlContainer;
    @FXML
    private TextFlow gameControls;
    @FXML
    private TextFlow menuControls;

    public Text makeText(String text) {
        Text newText = new Text(text + "\n");
        newText.setFont(Font.font("Consolas", 24));
        return newText;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundSize properSizing = new BackgroundSize(1, 1, true, true, true, false);
        Border border = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(2),
                new BorderWidths(10, 10, 10, 10)));

        gameImage.setImage(new Image("resources/gameimage.png"));
        gameImage.fitWidthProperty().bind(background.widthProperty().divide(2).subtract(20));
        gameImage.fitHeightProperty().bind(background.heightProperty().subtract(20));

        background.setBackground(
                new Background(
                        new BackgroundImage(
                                new Image("resources/background.jpg"),
                                BackgroundRepeat.REPEAT,
                                BackgroundRepeat.REPEAT,
                                BackgroundPosition.CENTER,
                                properSizing
                        )
                )
        );
        background.setBorder(border);
        gameControls.setBackground(new Background(
                new BackgroundImage(
                        new Image("resources/menu-text-background.jpg"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));
        menuControls.setBackground(new Background(
                new BackgroundImage(
                        new Image("resources/menu-text-background.jpg"),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        properSizing
                )
        ));

        controlContainer.prefWidthProperty().bind(background.widthProperty().divide(2).subtract(20));
        controlContainer.prefHeightProperty().bind(background.heightProperty().subtract(20));

        gameControls.prefWidthProperty().bind(controlContainer.prefWidthProperty());
        gameControls.setBorder(border);
        menuControls.prefWidthProperty().bind(controlContainer.prefWidthProperty());
        menuControls.prefHeightProperty().bind(controlContainer.heightProperty().divide(3));
        menuControls.setBorder(border);
        gameControls.prefHeightProperty().bind(controlContainer.prefHeightProperty().subtract(menuControls.prefHeightProperty()));

        gameControls.getChildren().add(makeText("The cave lies open before you "
                + "emitting an unnatural green light. The air is stagnant and "
                + "moist, telling you this area has been untouched by humanity "
                + "for many years. Who knows what may lie within? But this has "
                + "to be where the treasure is hidden. All of the clues have led"
                + " you to this very spot. All that is left is to go inside."));
        gameControls.getChildren().add(makeText("____________________________"));
        Hyperlink goInside = new Hyperlink("Go inside");
        goInside.setStyle("-fx-text-fill: black; -fx-underline: false");
        goInside.setFont(Font.font("Consolas", 24));
        goInside.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameControls.getChildren().clear();
                gameControls.getChildren().add(makeText("You are likely to be eaten by a grue."));
            }
        });
        gameControls.getChildren().add(goInside);
        gameControls.getChildren().add(makeText(""));
        Hyperlink turnBack = new Hyperlink("turn back");
        turnBack.setStyle("-fx-text-fill: black; -fx-underline: false");
        turnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameControls.getChildren().clear();
                gameControls.getChildren().add(makeText("You are likely to be eaten by a grue."));
            }
        });
        turnBack.setFont(Font.font("Consolas", 24));
        gameControls.getChildren().add(turnBack);

        Hyperlink inventory = new Hyperlink("Inventory");
        inventory.setStyle("-fx-text-fill: black; -fx-underline: false");
        inventory.setFont(Font.font("Consolas", 24));

        inventory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuControls.prefHeightProperty().unbind();
                Timeline inventoryTimeline = new Timeline();
                inventoryTimeline.setCycleCount(2);
                inventoryTimeline.setAutoReverse(true);
                inventoryTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
                        new KeyValue(menuControls.prefHeightProperty(),
                                menuControls.prefHeightProperty().multiply(2).get())));

                inventoryTimeline.play();
            }
        });

        menuControls.getChildren().add(inventory);

        Hyperlink exit = new Hyperlink("Exit");
        exit.setStyle("-fx-text-fill: black; -fx-underline: false");
        exit.setFont(Font.font("Consolas", 24));
        
        exit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                GameGuiMockups.getSingleton().getMainStage().close();
            } 
        });
        
        menuControls.getChildren().add(makeText(""));
        menuControls.getChildren().add(exit);

    }

}
