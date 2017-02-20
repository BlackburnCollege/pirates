/*
 * Copyright (C) 2016 Lucas Burdell lucas.burdell@blackburn.edu
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
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Lucas Burdell lucas.burdell@blackburn.edu
 */
public class MusicController {

    /**
     * @return the resources
     */
    public ArrayList<Media> getResources() {
        return resources;
    }

    /**
     * @return the singleton
     */
    public static MusicController get() {
        return singleton;
    }
    
    

    private MusicController() {
        //hide the constructor
    }

    private static final MusicController singleton = new MusicController();
    private MediaPlayer player = null;
    private boolean autoPlaySongs = true;
    private float volume = 1f;
    
    
    
    private final HashMap<String, Media> names = new HashMap<>();
    private final ArrayList<Media> resources = new ArrayList<>();
    
    {
        try {
            URI uri = MusicController.class.getResource("/resources").toURI();
            Path myPath;
            if (uri.getScheme().equals("jar")) {
                FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
                myPath = fileSystem.getPath("/resources");
            } else {
                myPath = Paths.get(uri);
            }
            Stream<Path> walk = Files.walk(myPath, 1);
            for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
                Path path = it.next();
                String name = path.getFileName().toString();
                if (name.endsWith(".mp3") && name.startsWith("mus_")) {
                    Media media = new Media(MusicController.class.getClassLoader().getResource("resources/" + name).toString());
                    getResources().add(media);
                    names.put(name, media);
                }
            }
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MusicController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isPlaying() {
        return player.getStatus() == MediaPlayer.Status.PLAYING;
    }

    private MediaPlayer buildPlayer(Media media) {
        MediaPlayer newPlayer = new MediaPlayer(media);
        newPlayer.setVolume(getVolume());
        newPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                synchronized (MusicController.this) {
                    newPlayer.dispose();
                    player = null;
                    MusicController.this.notifyAll();
                }
            }

        });
        return newPlayer;
    }

    public void playSong() {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    playSong();
                }
            });
            return;
        }
        if (player != null && player.getStatus() == MediaPlayer.Status.PAUSED) {
            player.play();
        }
    }

    public void playSong(Media song) {

        if (song == null) {
            throw new RuntimeException(song + " not found!");
        }
        if (player != null && isPlaying()) {
            player.stop();
            synchronized (this) {
                this.notifyAll();
            }
        }
        player = buildPlayer(song);
        player.play();
    }

    public void playSong(String song) {

        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    playSong(song);
                }
            });
            return;
        }
        Media newMedia = names.get(song);
        playSong(newMedia);
    }

    public void playSongAndYield(Media media) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                playSong(media);
            }
        });
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
            }
        }

    }

    public void playSongAndYield(String song) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                playSong(song);
            }
        });
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
            }
        }

    }

    public void pauseSong() {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pauseSong();
                }
            });
            return;
        }
        if (player != null && isPlaying()) {
            player.pause();
        }
    }

    public void stopSong() {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    stopSong();
                }
            });
            return;
        }
        if (player != null && isPlaying()) {
            player.stop();
            player.dispose();
            player = null;
            synchronized (this) {
                this.notifyAll();
            }
        }
    }

    /**
     * @return the autoPlaySongs
     */
    public boolean isAutoPlayingSongs() {
        return autoPlaySongs;
    }

    /**
     * @param autoPlaySongs the autoPlaySongs to set
     */
    public void setAutoPlaySongs(boolean autoPlaySongs) {
        this.autoPlaySongs = autoPlaySongs;
    }

    /**
     * @return the volume
     */
    public float getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(float volume) {
        this.volume = volume;
        if (player != null) {
            player.setVolume(volume);
        }
    }
    
     public void playSound(String name) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Media media = names.get(name);
                if (media == null) {
                    try {
                        media = new Media(GameGuiMockups.class.getClassLoader().getResource("resources/" + name).toString());
                        names.put(name, media);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                MediaPlayer player = new MediaPlayer(media);
                float vol = getVolume();
                setVolume(Math.min(vol, 0.2f));
                Runnable dispose = new Runnable() {
                    @Override
                    public void run() {
                        player.dispose();
                        if (getVolume()==0.2f) {
                            setVolume(vol);
                        }
                    }
                };
                player.setOnEndOfMedia(dispose);
                player.setOnStopped(dispose);
                player.setOnError(dispose);
                player.play();
                System.out.println("Playing " + media + " " + media.getSource());
            }
        });
    }

}
