package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <pre>
 *     Erstellt eine Verbindung zu einer relationalen Datenbank.
 *
 *     Testet die notwendigen VerbindungInformationen.
 *     URL: Da liegt die Datenbank.
 *     USER
 *     Password
 *
 *     Protocol://domain:port/seite or datenbackname?Parameter
 *     example: https://google.de:443/search?q=java
 *     URL für Datenbankzugriff mit Java:
 *     jdbc:mysql://127.0.0.1:3306/marmelade_db?createDatabaseIfNotExist=true
 *     jdbc:mysql://localhost:3306/marmelade_db?createDatabaseIfNotExist=true
 *     User: root
 *     Passwort: "" (leeres Passwort)
 *
 *     Java mit Relationalen DatenBanken:
 *     Java Database Connectivity: JDBC im Package java.sql
 *
 *     1) SQLException: No suitable driver found
 *          Möglich ein Fehler in der URL
 *          Möglich: der Treiber wurde nicht geladen, weil er nicht im Classpath liegt.
 *
 *     2) com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure
 *          Der Server ist nicht erreichbar. Lösung: Datenbank einschalten.
 * </pre>
 */
public class VerbindungsTest {
    /**
     * Hier werden Verbindungsdaten getestet
     * @param args ignoriert
     * @throws SQLException wird hier nicht gefangen: es soll gezeigt werden, wenn es eine Ausnahme gibt
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/marmelade_db?createDatabaseIfNotExist=true";
        String user = "root";
        String passwort = "";

        Connection verbindung = DriverManager.getConnection(url, user, passwort);
        System.out.println(verbindung);
    }
}
