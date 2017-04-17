/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sql.SQLDatabaseManager;

/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class LoaderFXMLController implements Initializable {

    @FXML
    private Label animatedLoading;
    @FXML
    private Label loadingStatus;

    private void setGUIText(Label label, String text) {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    setGUIText(label, text);
                }
            });
            return;
        }
        label.setText(text);
    }

    private class LoadingTimer extends AnimationTimer {

        private long last = 0;
        private int state = 0;

        @Override
        public void handle(long now) {
            // that's an L, not a 1 (l vs 1)
            if (now - last > 700000000l) {
                state = (state + 1) % 4;
                switch (state) {
                    case 0:
                        setGUIText(animatedLoading, "Loading");
                        break;
                    case 1:
                        setGUIText(animatedLoading, "Loading.");
                        break;
                    case 2:
                        setGUIText(animatedLoading, "Loading..");
                        break;
                    case 3:
                        setGUIText(animatedLoading, "Loading...");
                        break;
                }
                last = now;
            }
        }

    }
    
    private void loadGame() {
        GuiLoader.getSingleton().loadGame();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadingTimer timer = new LoadingTimer();
        timer.start();
        Thread loadingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                setGUIText(loadingStatus, "Building story database");
                SQLDatabaseManager story = SQLDatabaseManager.getManager("storyDB");
                setGUIText(loadingStatus, "Building combat database");
                SQLDatabaseManager combat = SQLDatabaseManager.getManager("combatDB");
                setGUIText(loadingStatus, "Extracting images");
                ImageController.get();
                setGUIText(loadingStatus, "Extracting audio");
                AudioController.get();
                setGUIText(loadingStatus, "Building story tree");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LoaderFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        timer.stop();
                        loadGame();
                    }
                    
                });

            }
        });
        loadingThread.setDaemon(true);
        loadingThread.start();
    }
}
