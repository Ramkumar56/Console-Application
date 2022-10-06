package DbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    static Connection connection;

    public static Connection CreateMyConnection() {
        if(connection==null) {
            try {

                return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Ramkumar56");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
        else {
            return connection;
            }

        }
    }
