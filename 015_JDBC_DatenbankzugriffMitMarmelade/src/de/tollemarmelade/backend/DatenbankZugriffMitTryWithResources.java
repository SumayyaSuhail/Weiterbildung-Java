package de.tollemarmelade.backend;

import de.tollemarmelade.model.Marmelade;
import de.tollemarmelade.model.MarmeladeIdException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     In Datenbankzugriffen werden viele Objekte erstellt, die Resource beanspruchen.
 *     Diese müssen mit close-Aufrufen freigegeben werden.
 *
 *     Hier wird mit try-with-resources der (lange) finally block umgangen.
 * </pre>
 */
public class DatenbankZugriffMitTryWithResources {

    private String url = "jdbc:mysql://127.0.0.1:3306/marmelade_db?createDatabaseIfNotExist=true";
    private String user = "root";
    private String passwort = "";

    public DatenbankZugriffMitTryWithResources() {
    }

    public DatenbankZugriffMitTryWithResources(String url, String user, String passwort) {
        this.url = url;
        this.user = user;
        this.passwort = passwort;
    }

    public DatenbankZugriffMitTryWithResources(String pfadZuProperties) {
        System.out.println("Noch nicht implementiert");
    }

    /**
     * Liest alle Datensätzen aus der Marmelade Tabelle aus.
     * Erstellt aus jeden Datensatz ein Objekt.
     * Füllt eine Liste mit den gelesenen Objekten.
     *
     * @return die Liste aller Marmeladen in der Tabelle.
     */
    public List<Marmelade> lesenMarmeladen() {
        List<Marmelade> marmeladen = new ArrayList<>();
        String sqlAbfrage = "SELECT * FROM Marmelade";

        try (
                Connection verbindung = DriverManager.getConnection(url, user, passwort);
                Statement transformator = verbindung.createStatement();
                ResultSet antwort = transformator.executeQuery(sqlAbfrage)
        ) {
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
            }
        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
        // Hier sind alle 3 Resources geschlossen!

        return marmeladen;
    }

    /**
     * Nutzt try-with-resources statt finally
     *
     * @param zuSpeichern ein Marmelade Objekt, das noch nicht gespeichert wurde
     *  kein return der neu erstellte Primärschlüssel, neue marmeladeId
     */
    public void schreibenInMarmelade(Marmelade zuSpeichern) {
        if(zuSpeichern.getMarmeladeId() != null) {
            throw new MarmeladeIdException("Diese Marmelade ist schon geschrieben worden");
        }
        String sqlEingabe = "INSERT INTO MARMELADE VALUE(NULL,?,?,?,?,?)";

        try (
                Connection verbindung = DriverManager.getConnection(url, user, passwort);
                PreparedStatement transformator = verbindung.prepareStatement(sqlEingabe, Statement.RETURN_GENERATED_KEYS)
        ) {
            transformator.setString(1,zuSpeichern.getName());
            transformator.setString(2, zuSpeichern.getObst());
            transformator.setInt(3, zuSpeichern.getZuckergehalt());
            transformator.setObject(4, zuSpeichern.getGekochtAm());
            transformator.setBoolean(5, zuSpeichern.isBitter());

            transformator.execute(); //Schreibt einen neuen Datensatz

            //Um die ID in Objekt zu setzen:
            ResultSet antwortMitSchluessel = transformator.getGeneratedKeys();
            antwortMitSchluessel.next();
            int erzeugteId = antwortMitSchluessel.getInt(1);
            zuSpeichern.setMarmeladeId(erzeugteId); //Autoboxing

        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
    }
}
