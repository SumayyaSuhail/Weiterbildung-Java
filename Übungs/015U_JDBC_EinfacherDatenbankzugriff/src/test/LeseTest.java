package test;

import java.sql.*;
import java.time.LocalDate;

public class LeseTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";
        Connection verbindung = DriverManager.getConnection(url, user, password);

        String sqlAbfrageFuerKunden = "SELECT * FROM kunden";
        String sqlAbfrageFuerBestellungen = "SELECT * FROM bestellungen";

        Statement transformator = verbindung.createStatement();
        ResultSet kunden = transformator.executeQuery(sqlAbfrageFuerKunden);

        System.out.println("-".repeat(20) + " Kunden " + "-".repeat(20));
        while (kunden.next()) {
            int id = kunden.getInt("kunden_id");
            String vorname = kunden.getString("vorname");
            String nachname = kunden.getString("nachname");
            String email = kunden.getString("email");
            LocalDate erstelltAm = kunden.getObject("erstelltAm", LocalDate.class);
            System.out.println("Id: " + id
            + " - Vorname: " + vorname
            + " - Nachname: " + nachname
            + " - Email: " + email
            + " - ErstelltAm: " + erstelltAm);
        }

        System.out.println("\n");
        ResultSet bestellungen = transformator.executeQuery(sqlAbfrageFuerBestellungen);
        System.out.println("-".repeat(20) + " Bestellungen " + "-".repeat(20));
        while (bestellungen.next()) {
            int id = bestellungen.getInt("bestell_id");
            String name = bestellungen.getString("name");
            double preis = bestellungen.getDouble("preis");
            System.out.println("ID: " + id
            + " - Name: " + name
            + " - Preis: " + preis);
        }

        System.out.println("\nDatenbank lesen wurde beendet.");
    }
}
