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

import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Burdell lucas.burdell@blackburn.edu
 */
public class GameGuiMockups extends Application {

    /**
     * @return the singleton
     */
    public static GameGuiMockups getSingleton() {
        return singleton;
    }
    
    private Stage mainStage;
    private static GameGuiMockups singleton;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxmlresources/FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setTitle("YOU ARE A PIRATE");
        stage.show();
        setMainStage(stage);
        musicController.playSong(Music.LIVING_VOYAGE);
        singleton = this;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private MusicController musicController = MusicController.get();

    public void playMusic() {
        Random random = new Random();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int songNumber = random.nextInt(musicController.getResources().size());;
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
