package test;

import de.katzen.schiff.Katze;
import de.katzen.schiff.Schiff;

/**
 * <pre>
 *     Ein Objekt von Typ wird erstellt / die Klasse Schiff wird instanziert
 *     Ein Objekt vom Typ Katze wird erstellt / die Klasse wird instanziert.
 *     Dann wird über setter die HAS-A-Beziehung der beiden Objekte aufgebaut
 * </pre>
 */
public class SchiffTest {
    /** wie immer */
    public static void main(String[] args) {
        Schiff nostromo = new Schiff();
        Katze jones = new Katze();

        nostromo.setName("Nostromo");
        jones.setName("Jones");

        nostromo.setKapitaen("Dallas");
        nostromo.setSchiffsKatze(jones);

        jones.setAlter(5);

        System.out.println("Schiff: " + nostromo.getName());
        System.out.println("Kapitän: " + nostromo.getKapitaen());
        System.out.println("SchiffKatze: " + nostromo.getSchiffKatze().getName());

        System.out.println("\n---------- Jones wird gefüttert ----------");
        nostromo.katzeFuetternLassen();

        System.out.println("\n---------- Besprechung durchführen ----------");
        nostromo.bespreschungDurchfuehren("Seltsame Geräusche im Lüftungsschacht");

        System.out.println("\n---------- Ein Tag auf See ----------");
        nostromo.monsterBegegnen("Kraken");
        nostromo.monsterBegegnen("Weißen Hai");
        nostromo.monsterBegegnen("Alien");
    }
}
