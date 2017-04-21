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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import world.Player;
import world.World;

/**
 *
 * @author Lucas Burdell lucas.burdell@blackburn.edu
 */
public class GuiLoader extends Application {

    private static final String gameTitle = "Treasure and Plunder";

    /**
     * @return the singleton
     */
    public static GuiLoader getSingleton() {
        return singleton;
    }

    private Stage mainStage;
    private static GuiLoader singleton;

    public void loadGame(World world) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameFXML.fxml"));
            Parent root = loader.load();
            GameController controller = loader.getController();

            Scene scene = mainStage.getScene();
            scene.setRoot(root);
            controller.setScene(scene);
            String css = this.getClass().getResource("GuiStyle.css").toExternalForm();
            scene.getStylesheets().add(css);
            mainStage.setScene(scene);
            controller.startGame(world);
        } catch (IOException ex) {
            Logger.getLogger(GuiLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLoadingScreen(Player player) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoaderFXML.fxml"));
            Parent root = loader.load();
            LoaderFXMLController controller = loader.getController();
            controller.setPlayer(player);
            Scene scene = mainStage.getScene();
            scene.setRoot(root);
            
            String css = this.getClass().getResource("GuiStyle.css").toExternalForm();
            scene.getStylesheets().add(css);
            mainStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(GuiLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNIFIED);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerFXML.fxml"));
        Parent root = loader.load();

 
        
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("GuiStyle.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setResizable(false);

        stage.setIconified(false);

        
        stage.setWidth(800);
        stage.setHeight(600);

        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("F11"));
        stage.setFullScreenExitHint("");
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            private boolean isFullscreen = stage.isFullScreen();

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.F11) {
                    if (this.isFullscreen) {
                        this.isFullscreen = false;
                        stage.setFullScreenExitHint("");
                    } else {
                        this.isFullscreen = true;
                        stage.setFullScreen(true);
                    }
                }
            }

        });
        stage.setTitle(gameTitle);
        stage.show();
        setMainStage(stage);
        singleton = this;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the mainStage
     */
    public Stage getMainStage() {
        return mainStage;
    }

    /**
     * @param mainStage the mainStage to set
     */
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

}
