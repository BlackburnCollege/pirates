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
public class SQLLoaderTest {

    public static final String databaseName = "piratestest";
    public static final String databaseDriver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String databaseURL = "jdbc:derby:" + databaseName;
    private static final String databaseCreationURL = databaseURL + ";create=true";

    private static ArrayList<String> extractSQLFiles() {
        try {
            ArrayList<String> tempFiles = new ArrayList<>();
            Path tempDirPath = Files.createTempDirectory("piratestmp", new FileAttribute[0]);
            File tempDir = tempDirPath.toFile();
            URI uri = SQLLoaderTest.class.getResource("/sql/").toURI();
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
                    Files.copy(SQLLoaderTest.class.getResourceAsStream(
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
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }

        throw new RuntimeException("Exraction was unsucessful");
    }

    public static void loadSQL(boolean rebuild) throws IOException {

        if (rebuild) {
            File oldDatabase = new File(databaseName);
            if (oldDatabase.exists()) {
                oldDatabase.delete();
            }
        }
        System.setProperty("ij.driver", databaseDriver);
        System.setProperty("ij.database", databaseCreationURL);
        PrintStream console = System.out;
        System.setOut(new PrintStream(new File("sqloutput")));
        for (String path : extractSQLFiles()) {
            String[] argArray = new String[]{path};
            ij.main(argArray);
        }
        System.setOut(console);
        System.setProperty("ij.database", databaseURL);
    }
    
    public static void loadSQL() throws IOException {
        loadSQL(true);
    }

    public static void main(String[] args) throws Exception {
        loadSQL();
        
        System.out.println("Loading the Derby jdbc driver...");
        Class<?> clazz = Class.forName(databaseDriver);
        clazz.getConstructor().newInstance();

        System.out.println("Getting Derby database connection...");
        Connection connCS = DriverManager.getConnection(databaseURL);
        System.out.println("Successfully got the Derby database connection...");

        PreparedStatement ps2 = connCS.prepareStatement("SELECT * FROM TEST");
        System.out.println("executing statement: ");

        ps2.execute();
        ResultSet set = ps2.getResultSet();

        while (set.next()) {
            System.out.println(
                    set.getString("TNAME") + " " + set.getString("TTEXT")
                    + set.getInt("TVALUE"));
        }

        connCS.close();
        System.out.println("Closed connection");

    }
}
