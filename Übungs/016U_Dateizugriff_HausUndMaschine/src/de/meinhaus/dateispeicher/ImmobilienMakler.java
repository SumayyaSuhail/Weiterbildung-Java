package de.meinhaus.dateispeicher;

import de.meinhaus.model.Haus;

import java.io.File;
import java.util.List;

/**
 * Lies die Liste wieder aus der Datei. Gib alle gespeicherten
 * Häuser auf der Konsole aus.
 */
public class ImmobilienMakler {
    public static void main(String[] args) {

        DateiUndDatenbankZugriff zugriff = new DateiUndDatenbankZugriff();
        File quelle = new File("objekte/hauslist");

        List<Haus> haeusern = zugriff.ladenHaeuser(quelle);
        haeusern.forEach(haus -> System.out.println(haus));
    }
}
