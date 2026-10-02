package de.tollemarmelade.backend;

import de.tollemarmelade.model.Marmelade;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     Alles, was in der Anwendung an Datenbankzugriffen notwendig ist, soll hier passieren.
 *     Außerhalb dieser Klasse soll nichts auf das tatsächliche Backend hinweisen:
 *     Außerhalb dieser Klasse soll nicht bekannt sein, ob das Backend eine Datenbank ist.
 * </pre>
 */
public class DatenbankZugriffMitFinally {

    private String url = "jdbc:mysql://127.0.0.1:3306/marmelade_db?createDatabaseIfNotExist=true";
    private String user = "root";
    private String passwort = "";

    public DatenbankZugriffMitFinally() {}

    public DatenbankZugriffMitFinally(String url, String user, String passwort) {
        this.url = url;
        this.user = user;
        this.passwort = passwort;
    }

    public DatenbankZugriffMitFinally(String pfadZuProperties) {
        System.out.println("Noch nicht implementiert");
    }

    public List<Marmelade> lesenAusTabelle() {
        List<Marmelade> marmeladen = new ArrayList<>();
        String sqlAbfrage = "SELECT * FROM Marmelade";
        Connection verbindung = null;
        Statement transformator = null;
        ResultSet antwort = null;
        try {
            verbindung = DriverManager.getConnection(url, user, passwort);
            transformator = verbindung.createStatement();
            antwort = transformator.executeQuery(sqlAbfrage);

            while (antwort.next()) {
                //System.out.println("Datensatz gefunden.");
                int id = antwort.getInt("marmelade_id");
                String name = antwort.getString("name");
                String obst = antwort.getString("obst");
                int zuckergehalt = antwort.getInt("zuckergehalt");
                LocalDate gekochtAm = antwort.getObject("gekochtAm", LocalDate.class);
                //LocalDate gekochtAm = antwort.getDate("gekochtAM").toLocalDate();
                boolean bitter = antwort.getBoolean("bitter");

                Marmelade marmelade = new Marmelade(id, name, obst, zuckergehalt, gekochtAm, bitter);
                marmeladen.add(marmelade);
                System.out.println(marmelade);
            }
        } catch (SQLException datenbankAusnahme) {
            ;datenbankAusnahme.printStackTrace();
            // Nur hilfreich während der Entwicklung.
        } finally {
            //wird ausgeführt, egal ob eine Exception geworfen wird, oder nicht.
            if(antwort != null) {
                try {
                    antwort.close();
                } catch (SQLException ausnahme) {
                    System.out.println("Problem beim Schließen des ResultSets");
                    ausnahme.printStackTrace();
                }
            }
            if(transformator != null) {
                try {
                    transformator.close();
                } catch (SQLException ausnahme) {
                    System.out.println("Problem beim Schließen des Statement Objekts");
                    ausnahme.printStackTrace();
                }
            }
            if(verbindung != null) {
                try {
                    verbindung.close();
                } catch (SQLException ausnahme) {
                    System.out.println("Problem beim Schließen des Connection Objekts");
                    ausnahme.printStackTrace();
                }
            }
        }
        return marmeladen;
    }
}
