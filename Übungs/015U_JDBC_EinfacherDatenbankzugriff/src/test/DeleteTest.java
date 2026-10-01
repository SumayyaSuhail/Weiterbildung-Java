package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbindung = DriverManager.getConnection(url, user, password);

        String sqlEingabe = "DELETE FROM kunden WHERE NACHNAME='Müller'";
        Statement transformator = verbindung.createStatement();
        transformator.execute(sqlEingabe);

        String sqlEingabe2 = "DELETE FROM Bestellungen WHERE NAME='Monitor'";
        transformator.execute(sqlEingabe2);
        System.out.println("\nDatenbank delete wurde beendet.");
    }
}
