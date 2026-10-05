package de.sportfoerderung.dateispeicher;

import de.sportfoerderung.modal.Produkt;
import de.sportfoerderung.modal.Sponsor;
import de.sportfoerderung.modal.Sportler;

import java.io.File;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     Dateien, Dateizugriffe, Datenströme sollen verwaltet werden.
 *     Dazu wird ein Objekt erstellt für den Dateizugriff,
 *     String Objekte werden erstellt, die in Dateien geschrieben werden
 *     POJO Objekte werden erstellt zum geschrieben und gelesen werden.
 * </pre>
 */
public class Verwalter {
    public static void main(String[] args) {

        System.out.println("----- Das Programm startet um " + LocalTime.now() + " -----\n");

        File texte = new File("texte");
        File bilder = new File("bilder");
        File objekte = new File("objekte");

        texte.mkdir();
        bilder.mkdir();
        objekte.mkdir();

        DateiZugriff james = new DateiZugriff();

        File zeitDatei = new File("texte/zeit.txt");
        String aktuelleUhrzeit = "Geschrieben um " + LocalTime.now();
        james.schreibenInDatei(zeitDatei, aktuelleUhrzeit);

        String ausDatei = james.textLesenAusDatei(zeitDatei);
        System.out.println(ausDatei);

        System.out.println("\n----- Kopieren startet um " + LocalTime.now() + " -----\n");
        File original = new File("bilder/Kaffee.png");
        File kopie1 = new File("bilder/Kopie1.png");
        //james.undekoriertKopieren(original, kopie1);

        System.out.println("\n----- Gepuffertes Kopieren startet um " + LocalTime.now() + " -----\n");
        File kopie2 = new File("bilder/Kopie2.png");
        james.dekoriertKopieren(original, kopie2);

        System.out.println("\n----- Sport und Geld: Sportler, Sponsoren und Produkte werde geschrieben -----\n");
        File sportSpeicher = new File("objekte/sportler.sug");

//        Produkt debugHelfer = new Produkt("Gummiente");
//        Sponsor nerd = new Sponsor("Alles für Nerds", debugHelfer);
//        Sportler codeKarli = new Sportler("Karli Code", "Power Coding");
//        codeKarli.addSponsor(nerd);
//        System.out.println(codeKarli);
//        System.out.println(nerd);
//        james.speichernInDatei(sportSpeicher, codeKarli);

        Sportler sportlerAusDatei = james.lesenSportlerAusDatei(sportSpeicher);
        System.out.println(sportlerAusDatei);
        System.out.println(sportlerAusDatei.getSponsoren());

        System.out.println("\n----- Das Programm endet um " + LocalTime.now() + " -----");
    }
}
