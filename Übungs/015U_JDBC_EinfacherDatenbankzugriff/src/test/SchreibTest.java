package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Test the Insert into command to write elements into the table.
 */
public class SchreibTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbindung = DriverManager.getConnection(url, user, password);

        String sqlEingabe = "INSERT INTO kunde VALUE(NULL,?,?,?,?)";
        String sqlEingabeFuerBestellung = "INSERT INTO bestellung VALUE(NULL,?,?)";

        PreparedStatement transformatorFuerKunde = verbindung.prepareStatement(sqlEingabe);
        transformatorFuerKunde.setString(1, "Ben");
        transformatorFuerKunde.setString(2, "Müller");
        transformatorFuerKunde.setString(3, "ben.müller@gmail.com");
        transformatorFuerKunde.setObject(4, LocalDate.of(2026,9,30));
        transformatorFuerKunde.execute();

        transformatorFuerKunde = verbindung.prepareStatement(sqlEingabe);
        transformatorFuerKunde.setString(1, "Emma");
        transformatorFuerKunde.setString(2, "Wagner");
        transformatorFuerKunde.setString(3, "emma.wagner@gmail.com");
        transformatorFuerKunde.setObject(4, LocalDate.of(2026,8,10));
        transformatorFuerKunde.execute();

        PreparedStatement transformatorFuerBestellung = verbindung.prepareStatement(sqlEingabeFuerBestellung);
        transformatorFuerBestellung.setString(1,"Monitor");
        transformatorFuerBestellung.setDouble(2,179.00);
        transformatorFuerBestellung.execute();

        transformatorFuerBestellung = verbindung.prepareStatement(sqlEingabeFuerBestellung);
        transformatorFuerBestellung.setString(1, "Laptop");
        transformatorFuerBestellung.setDouble(2, 899.99);
        transformatorFuerBestellung.execute();
        System.out.println("\nSchreiben beendet");
    }
}
