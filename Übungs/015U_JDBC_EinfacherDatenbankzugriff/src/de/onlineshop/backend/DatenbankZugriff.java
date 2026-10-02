package de.onlineshop.backend;

import de.onlineshop.model.Bestellung;
import de.onlineshop.model.BestellungIdException;
import de.onlineshop.model.Kunde;
import de.onlineshop.model.KundeIdException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Alles, was in der Anwendung an Datenbankzugriffen notwendig ist, soll hier passieren.
 */
public class DatenbankZugriff {

    private String url = "jdbc:mysql://127.0.0.1:3306/online_store_db?createDatabaseIfNotExist=true";
    private String user = "root";
    private String password = "";

    public DatenbankZugriff() {
    }

    /**
     * Method to list all Kunde from Kunden Tabel
     *
     * @return list of Kunde
     */
    public List<Kunde> lesenKunde() {
        List<Kunde> kunden = new ArrayList<>();
        String sqlAbfrage = "SELECT * FROM Kunde";
        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                Statement transformator = verbindung.createStatement();
                ResultSet antwort = transformator.executeQuery(sqlAbfrage)
        ) {

            while (antwort.next()) {
                int id = antwort.getInt("kunde_id");
                String vorname = antwort.getString("vorname");
                String nachname = antwort.getString("nachname");
                String email = antwort.getString("email");
                LocalDate erstelltAm = antwort.getObject("erstelltAm", LocalDate.class);

                Kunde kunde = new Kunde(id, vorname, nachname, email, erstelltAm);
                kunden.add(kunde);
            }

        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
        return kunden;
    }

    /**
     * Method to list all bestellung from Bestellungen Table
     *
     * @return list of bestellung
     */
    public List<Bestellung> lesenBestellung() {
        List<Bestellung> bestellungen = new ArrayList<>();
        String sqlAbfrage = "SELECT * FROM Bestellung";
        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                Statement transformator = verbindung.createStatement();
                ResultSet antwort = transformator.executeQuery(sqlAbfrage)
        ) {

            while (antwort.next()) {
                int id = antwort.getInt("bestell_id");
                String name = antwort.getString("name");
                double preis = antwort.getDouble("preis");

                Bestellung bestellung = new Bestellung(id, name, preis);
                bestellungen.add(bestellung);
            }

        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
        return bestellungen;
    }

    /**
     * Method to write a new Kunde to Kunde Table
     *
     * @param kundeZuSpeichern ein Kunde Objekt, das noch nicht gespeichert wurde
     */
    public void schreibenInKunde(Kunde kundeZuSpeichern) {
        if (kundeZuSpeichern.getKundeId() != null) {
            throw new KundeIdException("Diese Kunde ist schon geschrieben worden");
        }
        String sqlEingabe = "INSERT INTO Kunde VALUE(NULL,?,?,?,?)";
        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                PreparedStatement transformator = verbindung.prepareStatement(sqlEingabe, Statement.RETURN_GENERATED_KEYS)
        ) {
            transformator.setString(1, kundeZuSpeichern.getVorname());
            transformator.setString(2, kundeZuSpeichern.getNachname());
            transformator.setString(3, kundeZuSpeichern.getEmail());
            transformator.setObject(4, kundeZuSpeichern.getErstelltAm());
            transformator.execute();

            //Um die ID in Objekt zu setzen:
            ResultSet antwortMitSchluessel = transformator.getGeneratedKeys();
            antwortMitSchluessel.next();
            int erzeugteId = antwortMitSchluessel.getInt(1);
            kundeZuSpeichern.setKundeId(erzeugteId); //Autoboxing

        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Method to write a new Bestellung to Bestellung Table
     *
     * @param bestellungZuSpeichern eine Bestellung Objekt, das noch nicht gespeichert wurde
     */
    public void schreibenInBestellung(Bestellung bestellungZuSpeichern) {
        if (bestellungZuSpeichern.getBestellID() != null) {
            throw new BestellungIdException("Diese Bestellung ist schon geschrieben worden");
        }
        String sqlEingabe = "INSERT INTO Bestellung VALUE(NULL,?,?)";

        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                PreparedStatement transformator = verbindung.prepareStatement(sqlEingabe, Statement.RETURN_GENERATED_KEYS)
        ) {

            transformator.setString(1, bestellungZuSpeichern.getName());
            transformator.setDouble(2, bestellungZuSpeichern.getPreis());
            transformator.execute();

            ResultSet antwortMitSchluessel = transformator.getGeneratedKeys();
            antwortMitSchluessel.next();
            int erzeugteId = antwortMitSchluessel.getInt(1);
            bestellungZuSpeichern.setBestellID(erzeugteId);

        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Method to update a Kunde in the Kunde Table
     *
     * @param kundeZuAktualisieren the object to be updated
     * @param vorname updated with this vorname
     */
    public Kunde updateInKunde(Kunde kundeZuAktualisieren, String vorname) {
        String sqlUpdate = "UPDATE kunde SET VORNAME=? WHERE kunde_id=?";
        if (kundeZuAktualisieren.getKundeId() == null) {
            throw new KundeIdException("Dieser Kunde wurde noch nicht gespeichert -- kann nicht aktualisiert werden");
        }

        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                PreparedStatement transformator = verbindung.prepareStatement(sqlUpdate)
        ) {
            transformator.setString(1, vorname);
            transformator.setInt(2, kundeZuAktualisieren.getKundeId());
            transformator.execute();

            kundeZuAktualisieren.setVorname(vorname);
        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
        return kundeZuAktualisieren;
    }

    /**
     * Method to update a Bestellung in the Bestellung Table
     *
     * @param bestellungZuAktualisieren the object to be updated
     * @param neuPreis updated with this preis
     */
    public Bestellung updateInBestellung(Bestellung bestellungZuAktualisieren, double neuPreis) {
        String sqlUpdate = "Update bestellung SET PREIS=? WHERE bestell_id = ?";

        if (bestellungZuAktualisieren.getBestellID() == null) {
            throw new BestellungIdException("Dieser Bestellung wurde noch nicht gespeichert -- kann nicht aktualisiert werden");
        }

        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                PreparedStatement transformator = verbindung.prepareStatement(sqlUpdate);
        ) {
            transformator.setDouble(1, neuPreis);
            transformator.setInt(2, bestellungZuAktualisieren.getBestellID());

            transformator.execute();
            bestellungZuAktualisieren.setPreis(neuPreis);

        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
        return bestellungZuAktualisieren;
    }

    /**
     * Method to delete a Kunde from the Kunde Table
     *
     * @param kundeZumLoeschen the object to be deleted
     */
    public void deleteInKunde(Kunde kundeZumLoeschen) {
        String sqlDelete = "DELETE FROM kunde WHERE kunde_id = ?";
        if (kundeZumLoeschen.getKundeId() == null) {
            throw new KundeIdException("Dieser Kunde wurde noch nicht gespeichert -- kann nicht gelöscht werden");
        }

        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                PreparedStatement transformator = verbindung.prepareStatement(sqlDelete)
        ) {
            transformator.setInt(1, kundeZumLoeschen.getKundeId());
            transformator.execute();
        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    /**
     * Method to delete a Bestellung from the Bestellung Table
     *
     * @param bestellungZumLoeschen the object to be deleted
     */
    public void deleteInBestellung(Bestellung bestellungZumLoeschen) {
        String sqlDelete = "DELETE FROM bestellung WHERE bestell_id = ?";
        if (bestellungZumLoeschen.getBestellID() == null) {
            throw new KundeIdException("Dieser Bestellung wurde noch nicht gespeichert -- kann nicht gelöscht werden");
        }

        try (
                Connection verbindung = DriverManager.getConnection(url, user, password);
                PreparedStatement transformator = verbindung.prepareStatement(sqlDelete)
        ) {
            transformator.setInt(1, bestellungZumLoeschen.getBestellID());
            transformator.execute();
        } catch (SQLException ausnahme) {
            ausnahme.printStackTrace();
        }
    }
}
