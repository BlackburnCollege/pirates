package storybuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

/**
 * FXML Controller class
 *
 * @author lucas.burdell
 */
public class StoryBuilderFXMLController implements Initializable {

    @FXML
    private Pane canvasPane;
    @FXML
    private Button eventButton;
    @FXML
    private Button actionButton;
    @FXML
    private Button choiceButton;
    @FXML
    private Pane actionTemplate;
    @FXML
    private Pane eventTemplate;
    @FXML
    private Pane choiceTemplate;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ToolBar toolbar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // FIX THE CHOICE TEMPLATE
        for (Node node : choiceTemplate.getChildren()) {
            if (node.getId().equals("shape")) {
                Polygon triangle = (Polygon) node;
                ObservableList<Double> list = triangle.getPoints();
                list.clear();
                list.addAll(0.0, 0.0, choiceTemplate.getPrefWidth() / 2,
                        choiceTemplate.getPrefHeight(),
                        choiceTemplate.getPrefWidth(),
                        0.0);
            }
        }
        //choiceTemplate.setVisible(true);
        /*
        canvasPane.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton()  == MouseButton.PRIMARY) {
                    System.out.println(event.getEventType().toString());
                    System.out.println(event.getX() + " " + event.getY());
                    double x = event.getSceneX();
                    double y = event.getSceneY();
                    Point2D point = canvasPane.sceneToLocal(x, y, true);
                    try {
                        Pane choice = (Pane) FXMLLoader.load(
                                StoryBuilder.class.getResource(
                                        "/storybuilder/ChoiceFXML.fxml"));
                        canvasPane.getChildren().add(choice);
                        choice.setLayoutX(point.getX() - 100);
                        choice.setLayoutY(point.getY() - 100);
                        choice.setVisible(true);
                        System.out.println("choice added at " + point.getX() + 
                                " " + point.getY());
                    } catch (IOException ex) {
                        
                    }
                    
                    
                }
            }
            
        });*/
    }

}
