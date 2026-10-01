package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SchreibTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbindung = DriverManager.getConnection(url, user, password);

        String sqlEingabe = "INSERT INTO kunden VALUE(NULL,?,?,?,?)";
        String sqlEingabeFuerBestellungen = "INSERT INTO bestellungen VALUE(NULL,?,?)";

        PreparedStatement transformatorFuerKunden = verbindung.prepareStatement(sqlEingabe);
        transformatorFuerKunden.setString(1, "Ben");
        transformatorFuerKunden.setString(2, "Müller");
        transformatorFuerKunden.setString(3, "ben.müller@gmail.com");
        transformatorFuerKunden.setObject(4, LocalDate.of(2026,9,30));
        transformatorFuerKunden.execute();

        transformatorFuerKunden = verbindung.prepareStatement(sqlEingabe);
        transformatorFuerKunden.setString(1, "Emma");
        transformatorFuerKunden.setString(2, "Wagner");
        transformatorFuerKunden.setString(3, "emma.wagner@gmail.com");
        transformatorFuerKunden.setObject(4, LocalDate.of(2026,8,10));
        transformatorFuerKunden.execute();

        PreparedStatement transformatorFuerBestellungen = verbindung.prepareStatement(sqlEingabeFuerBestellungen);
        transformatorFuerBestellungen.setString(1,"Monitor");
        transformatorFuerBestellungen.setDouble(2,179.00);
        transformatorFuerBestellungen.execute();

        transformatorFuerBestellungen = verbindung.prepareStatement(sqlEingabeFuerBestellungen);
        transformatorFuerBestellungen.setString(1, "Laptop");
        transformatorFuerBestellungen.setDouble(2, 899.99);
        transformatorFuerBestellungen.execute();
        System.out.println("\nSchreiben beendet");
    }
}
