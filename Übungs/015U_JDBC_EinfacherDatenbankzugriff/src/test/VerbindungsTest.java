package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Test the connection between this project and database.
 */
public class VerbindungsTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";

        Connection verbindung = DriverManager.getConnection(url, user, password);
        System.out.println(verbindung);
    }
}
