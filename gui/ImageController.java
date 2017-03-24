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
import javafx.scene.image.Image;
import javafx.scene.media.Media;

/**
 *
 * @author lucas.burdell
 */
public class ImageController {

    private static final String IMAGE_LOCATION = "resources/";
    private final HashMap<String, Image> names = new HashMap<>();
    private final ArrayList<Image> resources = new ArrayList<>();

    private static final ImageController singleton = new ImageController();

    /**
     * @return the singleton
     */
    public static synchronized ImageController get() {
        return singleton;
    }

    private ImageController() {
        //hide the constructor
        try {
            URI uri = AudioController.class.getResource("/" + IMAGE_LOCATION).toURI();
            Path myPath;
            if (uri.getScheme().equals("jar")) {
                FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
                myPath = fileSystem.getPath(IMAGE_LOCATION);
            } else {
                myPath = Paths.get(uri);
            }
            Stream<Path> walk = Files.walk(myPath, 1);
            for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
                Path path = it.next();
                String location = path.getFileName().toString();
                String[] parts = location.split("\\.");
                if (parts.length != 2) {
                    continue;
                }
                String name = parts[0];
                String fileType = parts[1];
                if (isImageType(fileType)) {
                    System.out.println("image controller: loading " + IMAGE_LOCATION + location);
                    Image media = new Image(GuiLoader.class.getClassLoader().getResource(IMAGE_LOCATION + location).toString());
                    resources.add(media);
                    names.put(name.toLowerCase(), media);
                }
            }
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AudioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private boolean isImageType(String name) {
        return name.equalsIgnoreCase("png") || name.equalsIgnoreCase("jpg") || name.equalsIgnoreCase("gif");
    }
    
    public Image getImage(String name) {
        return (names.get(name.toLowerCase()));
    }

}
