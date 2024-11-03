package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/persondb",
                    "postgres", "admin");
            return connection;
    }
}
