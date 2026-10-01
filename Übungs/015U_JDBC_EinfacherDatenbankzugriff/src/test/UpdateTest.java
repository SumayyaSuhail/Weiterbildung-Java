package test;

import java.sql.*;

public class UpdateTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbindung = DriverManager.getConnection(url, user, password);

        String sqlEingabe = "UPDATE kunden SET VORNAME='Tom' WHERE NACHNAME='Müller'";
        Statement transformator = verbindung.createStatement();
        transformator.execute(sqlEingabe);

        System.out.println("\nDatenbank update wurde beendet.");
    }
}
