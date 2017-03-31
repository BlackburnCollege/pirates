package sql;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;
import org.apache.derby.tools.ij;

/**
 *
 * @author lucas.burdell
 */
public class SQLLoader {

    private static final String databaseDriver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String databaseURL = "jdbc:derby:pirates/";// + databaseName;

    //public static final String databaseName = "pirates/piratestest";
    private String databaseName;
    private String databaseCreationURL = databaseURL + databaseName + ";create=true";
    private boolean create;
    //private static final String databaseCreationURL = databaseURL + ";create=true";

    public SQLLoader(String databaseName) {
        this(databaseName, false);
    }
    
    public SQLLoader(String databaseName, boolean create) {
        this.databaseName = databaseName;
        this.create = create;
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
    private ArrayList<String> extractSQLFiles() throws Exception {
        ArrayList<String> tempFiles = new ArrayList<>();
        Path tempDirPath = Files.createTempDirectory("piratestmp", new FileAttribute[0]);
        File tempDir = tempDirPath.toFile();
        URI uri = SQLLoader.class.getResource("/sql/").toURI();
        Path myPath;
        if (uri.getScheme().equals("jar")) {
            FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
            myPath = fileSystem.getPath("sql/");
        } else {
            myPath = Paths.get(uri);
        }
        Stream<Path> walk = Files.walk(myPath, 1);
        for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
            Path filePath = it.next();
            String name = filePath.getFileName().toString();
            if (name.endsWith(".sql")) {
                System.out.println("sql loader: loading " + "sql/" + name);
                Files.copy(SQLLoader.class.getResourceAsStream(
                        "/sql/" + name), (new File(tempDirPath.toString(), name)).toPath(),
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
    public void loadSQL() throws Exception {

        File oldDatabase = new File(databaseName);
        if (oldDatabase.exists()) {
            System.out.println("Deleting old database: " + oldDatabase.getAbsolutePath().toString());
            oldDatabase.delete();
        }

        System.setProperty("ij.driver", databaseDriver);
        System.setProperty("ij.database", databaseCreationURL);
        PrintStream console = System.out;
        //System.setOut(new PrintStream(new File("sqloutput")));
        for (String path : extractSQLFiles()) {
            System.out.println("running " + path);
            String[] argArray = new String[]{path};
            ij.main(argArray);
        }
        System.setOut(console);
        System.setProperty("ij.database", databaseURL + databaseName);
    }

    // MAIN METHOD USED FOR TESTING ONLY
    // TODO: REMOVE METHOD
    public static void main(String[] args) throws Exception {
        SQLLoader loader = new SQLLoader("piratestest", true);
        //loadSQL();

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
    }

    /**
     * @return the create
     */
    public boolean isCreate() {
        return create;
    }
}
