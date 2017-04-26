package sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.apache.derby.tools.ij;
import world.Event;

/**
 *
 * @author lucas.burdell
 */
public class SQLDatabaseManager {

    public static final String databaseDriver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String databaseURL = "jdbc:derby:";// + databaseName;

    //public static final String databaseName = "pirates/piratestest";
    private String databaseName;
    private boolean create;
    private Connection connection;
    //private static final String databaseCreationURL = databaseURL + ";create=true";

    private static final HashMap<String, Boolean> MANAGERS = new HashMap<>();

    public static SQLDatabaseManager getManager(String databaseName) {
        Boolean isMade = MANAGERS.getOrDefault(databaseName, false);
        SQLDatabaseManager manager;
        if (!isMade) {
            manager = new SQLDatabaseManager(databaseName, true);
            MANAGERS.put(databaseName, true);
        } else {
            manager = new SQLDatabaseManager(databaseName, false);
        }
        return manager;
    }

    private SQLDatabaseManager(String databaseName) {
        this(databaseName, true);
    }

    private SQLDatabaseManager(String databaseName, boolean create) {
        this.databaseName = databaseName;
        this.databaseURL = this.databaseURL + this.databaseName;
        this.create = create;
        if (create) {
            this.rebuild();
        }

        Class<?> clazz;
        try {
            clazz = Class.forName(databaseDriver);
            clazz.getConstructor().newInstance();
            this.connection = DriverManager.getConnection(databaseURL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Extract .sql files out of the Jar and into a temporary directory so that
     * Apache Derby can read and execute them.
     *
     * Note: if there is a file that has a name that begins with the word
     * "schema" it will be placed first in the array.
     *
     * Only .SQL files will be loaded into the temporary directory; other files
     * will need to (and should) be loaded in a different way.
     *
     * @return Arraylist of Strings that are the paths to the loaded SQL files.
     */
    private ArrayList<String> extractSQLFiles() throws IOException, URISyntaxException {
        ArrayList<String> tempFiles = new ArrayList<>();
        Path tempDirPath = Files.createTempDirectory("piratestmp", new FileAttribute[0]);
        File tempDir = tempDirPath.toFile();
        String databaseFilePath = "sql/" + this.databaseName + "/";
        URI uri = SQLDatabaseManager.class.getResource("/" + databaseFilePath).toURI();
        Path myPath;
        if (uri.getScheme().equals("jar")) {
            FileSystem fileSystem;
            try {
                fileSystem = FileSystems.getFileSystem(uri);
            } catch (Exception e) {
                fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
            }
            myPath = fileSystem.getPath(databaseFilePath);
        } else {
            myPath = Paths.get(uri);
        }
        Stream<Path> walk = Files.walk(myPath, 1);
        for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
            Path filePath = it.next();
            String name = filePath.getFileName().toString();
            if (name.endsWith(".sql")) {
                System.out.println("sql loader: loading " + databaseFilePath + name);
                Files.copy(SQLDatabaseManager.class.getResourceAsStream(
                        "/"
                        + databaseFilePath + name), (new File(tempDirPath.toString(), name)).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                if (name.startsWith("schema")) {
                    tempFiles.add(0,
                            new File(tempDir.toString(), name).getAbsolutePath());
                } else {
                    tempFiles.add(new File(tempDir.toString(), name).getAbsolutePath());
                }
            }
        }
        return tempFiles;
    }

    /**
     * Loads the SQL files into the database. Note that this will rebuild the
     * database using the stored SQL files; it should only be called if no
     * database exists or the database has become corrupt.
     *
     * @throws Exception if the database wasn't loaded correctly an exception is
     * thrown and must be caught.
     */
    public final void rebuild() {

        try {
            File oldDatabase = new File("/" + getDatabaseName());
            if (oldDatabase.exists()) {
                System.out.println("Deleting old database: " + oldDatabase.getAbsolutePath().toString());
                oldDatabase.delete();
            }

            System.setProperty("ij.driver", databaseDriver);
            System.setProperty("ij.database", databaseURL + ";create=true");
            PrintStream console = System.out;
            File file = new File("sqlloader_" + getDatabaseName() + ".out");
            System.setOut(new PrintStream(file));
            for (String path : extractSQLFiles()) {
                console.println("running " + path);
                String[] argArray = new String[]{path};
                ij.main(argArray);
            }
            System.setOut(console);
            System.out.println("SQL Loader output saved at " + file.getAbsolutePath());
            System.setProperty("ij.database", databaseURL);
        } catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    // MAIN METHOD USED FOR TESTING ONLY
    // TODO: REMOVE METHOD
    /*
        SQLDatabaseManager loader = new SQLDatabaseManager("combatDB", true);
        loader.rebuild();
        
        EntitySQLLoader entity = new EntitySQLLoader("wolf");
        System.out.println(entity.getHealth());
        System.out.println(entity.getMeleeModifier());
        
        entity = new EntitySQLLoader("dog");
        entity.setInsultImmune(true);
        entity.setHealth(50);
        entity.saveToDatabase();
        
        entity = new EntitySQLLoader("dog");
        System.out.println(entity.isInsultImmune());
        System.out.println(entity.getHealth());
        System.out.println(entity.getMeleeModifier());
     */
//        System.out.println("Loading the Derby jdbc driver...");
//        Class<?> clazz = Class.forName(databaseDriver);
//        clazz.getConstructor().newInstance();
//
//        System.out.println("Getting Derby database connection...");
//        Connection connCS = DriverManager.getConnection(databaseURL);
//        System.out.println("Successfully got the Derby database connection...");
//
//        PreparedStatement ps2 = connCS.prepareStatement("SELECT * FROM TEST");
//        System.out.println("executing statement: ");
//
//        ps2.execute();
//        ResultSet set = ps2.getResultSet();
//
//        while (set.next()) {
//            System.out.println(
//                    set.getString("TNAME") + " " + set.getString("TTEXT")
//                    + set.getInt("TVALUE"));
//        }
//
//        connCS.close();
//        System.out.println("Closed connection");
    /**
     * @return the create
     */
    public boolean isCreate() {
        return create;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}
