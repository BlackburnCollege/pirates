package sql;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.derby.tools.ij;

/**
 *
 * @author lucas.burdell
 */
public class SQLTest {

    public static final String CSdriver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String dbURLCS = "jdbc:derby:piratestest;create=true";

    public static Path loadSQL() throws IOException {
        Path path = Files.createTempDirectory("piratestmp", new FileAttribute[0]);
        File tempDir = path.toFile();
        FileFilter sqlFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.toString().endsWith(".sql");
            }
        };
        Path schemaPath = new File(path.toFile(), "story_schema.sql").toPath();
        Files.copy(SQLTest.class.getResourceAsStream("/sql/story_schema.sql"), schemaPath,
                StandardCopyOption.REPLACE_EXISTING);
        Path storyPath = new File(path.toFile(), "loadSTORY.sql").toPath();
        Files.copy(SQLTest.class.getResourceAsStream("/sql/loadSTORY.sql"), storyPath,
                StandardCopyOption.REPLACE_EXISTING);

        return path;
    }

    public static void main(String[] args) throws Exception {
        Path tempDir = loadSQL();
        String[] argTest = new String[]{(new File(tempDir.toString(), "story_schema.sql")).getAbsolutePath()};
        System.setProperty("ij.driver", CSdriver);
        System.setProperty("ij.database", dbURLCS + ";create=true");
        ij.main(argTest);
        argTest = new String[]{(new File(tempDir.toString(), "loadSTORY.sql")).getAbsolutePath()};

        ij.main(argTest);

        System.out.println("Loading the Derby jdbc driver...");
        Class<?> clazz = Class.forName(CSdriver);
        clazz.getConstructor().newInstance();

        System.out.println("Getting Derby database connection...");
        Connection connCS = DriverManager.getConnection(dbURLCS);
        System.out.println("Successfully got the Derby database connection...");

        PreparedStatement ps = connCS.prepareStatement("SELECT TNAME FROM TEST");
        System.out.println("executing statement:");
        ps.execute();
        ResultSet set = ps.getResultSet();
        while (set.next()) {
            System.out.println(set.getString(1));
        }

        connCS.close();
        System.out.println("Closed connection");

    }
}
