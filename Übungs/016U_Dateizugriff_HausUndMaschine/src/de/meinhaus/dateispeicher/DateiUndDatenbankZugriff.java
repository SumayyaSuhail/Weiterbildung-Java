package de.meinhaus.dateispeicher;

import de.meinhaus.model.Haus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementiert Methoden zum Speichern Laden von Häusern in einer
 * Liste(List<Haus>).
 * Verwende Java-Serialisierung (implements Serializable) in allen relevanten
 * Klassen.
 * Ergänze eine Methode public void addHaus(Haus haus), die ein neues Haus zur
 * gespeicherten Liste hinzufügt.
 * Ergänze eine Methode public void updateHaus(Haus haus), die ein Haus aus der
 * Liste ändert.
 * Ergänze eine Methode public void deleteHaus(Haus haus), die ein Haus aus der
 * gespeicherten Liste löscht.
 */
public class DateiUndDatenbankZugriff {

    private List<Haus> haeusern;

    public DateiUndDatenbankZugriff() {
        haeusern = new ArrayList<>();
    }

    /**
     * Method to save the list of haus into the file
     *
     * @param ziel the target file
     */
    public void speichernHaeuser(File ziel) {
        try (
                ObjectOutputStream dekoSchreiber = new ObjectOutputStream(new FileOutputStream(ziel))
        ) {
            dekoSchreiber.writeObject(haeusern);

        } catch (IOException ausnahme) {
            ausnahme.printStackTrace();
        }
    }

    public List<Haus> ladenHaeuser(File quelle) {
        try (
                ObjectInputStream dekoLeser = new ObjectInputStream(new FileInputStream(quelle))
        ) {

            Object geleseneObjekt = dekoLeser.readObject();
            return (List<Haus>) geleseneObjekt;

        } catch (IOException | ClassNotFoundException ausnahme) {
            ausnahme.printStackTrace();
        }
        return null;
    }

    /**
     * Methode die ein neues Haus zur gespeicherten Liste hinzufügt.
     *
     * @param haus neue Haus
     */
    public void addHaus(Haus haus) {
        haeusern.add(haus);
    }

    /**
     * Methode die ein Haus aus der Liste ändert.
     *
     * @param haus the Haus to be Updated
     */
    public void updateHaus(Haus haus) {

    }

    /**
     * Methode, die ein Haus aus der gespeicherten Liste löscht.
     *
     * @param haus
     */
    public void deleteHaus(Haus haus) {

    }
}
