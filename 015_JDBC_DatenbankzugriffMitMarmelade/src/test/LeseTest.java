package test;

import java.sql.*;
import java.time.LocalDate;

/**
 * <pre>
 *     In der Datenbank marmelade_db gibt es eine Tabelle Marmelade.
 *     Die soll hier ausgelesen werden.
 *
 *     Testet den Tabellennamen, die Spaltennamen und die Datentypen.
 * </pre>
 */
public class LeseTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/marmelade_db?createDatabaseIfNotExist=true";
        String user = "root";
        String passwort = "";

        Connection verbindung = DriverManager.getConnection(url, user, passwort);

        String sqlAbfrage = "SELECT * FROM Marmelade";
        Statement transformator = verbindung.createStatement();
        System.out.println(transformator);

        ResultSet antwort = transformator.executeQuery(sqlAbfrage);
        System.out.println(antwort);

        while (antwort.next()) {
            //System.out.println("Datensatz gefunden.");
            int id = antwort.getInt("marmelade_id");
            String name = antwort.getString("name");
            String obst = antwort.getString("obst");
            int zuckergehalt = antwort.getInt("zuckergehalt");
            LocalDate gekochtAm = antwort.getObject("gekochtAm", LocalDate.class);
            //LocalDate gekochtAm = antwort.getDate("gekochtAM").toLocalDate();
            boolean bitter = antwort.getBoolean("bitter");
            System.out.println("Id: " + id
                    + " - Name: " + name
                    + " - Obst: " + obst
                    + " - Zuckergehalt: " + zuckergehalt + "%"
                    + " - GekochtAm: " + gekochtAm
                    + " - Bitter: " + bitter);
        }

//        while (antwort.next()) {
//            int id = antwort.getInt(1);
//            String name = antwort.getString(2);
//            String obst = antwort.getString(3);
//            int zuckergehalt = antwort.getInt(4);
//            LocalDate gekochtAm = antwort.getObject(5, LocalDate.class);
//            boolean bitter = antwort.getBoolean(6);
//            System.out.println("Id: " + id
//                    + " - Name: " + name
//                    + " - Obst: " + obst
//                    + " - Zuckergehalt: " + zuckergehalt + "%"
//                    + " - GekochtAm: " + gekochtAm
//                    + " - Bitter: " + bitter);
//        }

        System.out.println("\nDatenbank lesen wurde beendet.");
    }
}
