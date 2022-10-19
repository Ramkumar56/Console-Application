package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Ramkumar56");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
        return connection;

    }
}
