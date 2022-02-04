package rahul.jain.urlshortener.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import rahul.jain.urlshortener.domain.Constants;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {

    public static void createNewDatabase(String fileName) {
        String databaseLocation = Constants.FILE_LOCATION + fileName;
        File database = new File(databaseLocation);

        if (!database.exists()) {
            String url = "jdbc:sqlite:" + databaseLocation;
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Database already exists");
    }
}
