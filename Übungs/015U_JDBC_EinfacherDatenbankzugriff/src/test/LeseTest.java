package test;

import java.sql.*;
import java.time.LocalDate;

/**
 * Test the select command in sql
 */
public class LeseTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbindung = DriverManager.getConnection(url, user, password);

        String sqlAbfrageFuerKunde = "SELECT * FROM kunde";
        String sqlAbfrageFuerBestellung = "SELECT * FROM bestellung";

        Statement transformator = verbindung.createStatement();
        ResultSet kunde = transformator.executeQuery(sqlAbfrageFuerKunde);

        System.out.println("-".repeat(20) + " Kunde " + "-".repeat(20));
        while (kunde.next()) {
            int id = kunde.getInt("kunde_id");
            String vorname = kunde.getString("vorname");
            String nachname = kunde.getString("nachname");
            String email = kunde.getString("email");
            LocalDate erstelltAm = kunde.getObject("erstelltAm", LocalDate.class);
            System.out.println("Id: " + id
            + " - Vorname: " + vorname
            + " - Nachname: " + nachname
            + " - Email: " + email
            + " - ErstelltAm: " + erstelltAm);
        }

        System.out.println("\n");
        ResultSet bestellung = transformator.executeQuery(sqlAbfrageFuerBestellung);
        System.out.println("-".repeat(20) + " Bestellung " + "-".repeat(20));
        while (bestellung.next()) {
            int id = bestellung.getInt("bestell_id");
            String name = bestellung.getString("name");
            double preis = bestellung.getDouble("preis");
            System.out.println("ID: " + id
            + " - Name: " + name
            + " - Preis: " + preis);
        }

        System.out.println("\nDatenbank lesen wurde beendet.");
    }
}
