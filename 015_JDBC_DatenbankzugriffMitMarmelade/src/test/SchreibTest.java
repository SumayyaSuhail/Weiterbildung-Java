package test;

import java.sql.*;
import java.time.LocalDate;

/**
 * <pre>
 *     Daten sollen in die Tabelle Marmelade geschrieben werden.
 *
 *     Schreiben in Datenbank über INSERT INTO.
 *     Schreiben mit Statement-Objekte:
 *     "INSERT INTO `marmelade` (`marmelade_id`, `name`, `obst`, `zuckergehalt`, `gekochtAm`, `bitter`)
 *     VALUES (NULL, 'Obst ist gefährlich', '"+ gelesenBirne"', '44', '2026-09-02', '0');"
 *
 *     Hier wird geschrieben mit einen Objekt vom Typ PreparedStatement.
 *     Ein PreparedStatement kann einen String mit Platzhaltern verarbeiten: ?
 *     "INSERT INTO marmelade VALUE(?,?,?)"
 *
 *     In JakartaEE: Java Persistence API: JPA
 *     Alternativ: Objekte in Dateien speichern.
 * </pre>
 */
public class SchreibTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/marmelade_db?createDatabaseIfNotExist=true";
        String user = "root";
        String passwort = "";

        Connection verbindung = DriverManager.getConnection(url, user, passwort);
        String sqlEingabe = "INSERT INTO MARMELADE VALUE(NULL,?,?,?,?,?)";

        String name = "Johannisbeeren Marmelade";
        String obst = "Rote Johannisbeeren";
        int zuckerGehalt = 50;
        LocalDate gekochtAm = LocalDate.now();
        boolean bitter = false;

        PreparedStatement transformator = verbindung.prepareStatement(sqlEingabe);
        System.out.println(transformator);
        transformator.setString(1,name);
        transformator.setString(2, obst);
        transformator.setInt(3, zuckerGehalt);
        transformator.setObject(4, gekochtAm);
        transformator.setBoolean(5, bitter);
        System.out.println(transformator);

        transformator.execute();
        System.out.println("\nSchreiben beendet");
    }
}
