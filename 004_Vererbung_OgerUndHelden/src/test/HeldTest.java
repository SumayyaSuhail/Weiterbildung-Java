package test;

import de.ogergames.figuren.Charakter;
import de.ogergames.figuren.Held;

/**
 * <pre>
 *     Zeigt den Einstieg in Polymorphismus anhand der Klasse
 *     <b>Held</b>, die die Klasse Charakter erweitert.
 * </pre>
 */
public class HeldTest {

    /**
     * <pre>
     *     willi.verwunden(dracula);
     *     Hier wird an die Methode verwunden ein Held Objekt übergeben:
     *     Möglich, weil ein Held alles hat und kann, was ein Charakter hat und kann:
     *     extends: "Ein Held ist ein Charakter", Beziehung IS-A-Beziehung
     *     überall, wo die Adresse eines Charakter Objekts erwartet wird, kann auch die
     *     Adresse eines Held Objekts verwendet werden.
     *     Ein Held kann als Charakter "angesprochen" werden.
     * </pre>
     * @param args ignoriert
     */
    public static void main(String[] args) {
        Held dracula = new Held("Dracula der Blutige", "Justus Jonas");
        Charakter willi = new Charakter();

        System.out.println("Dracula:\n" + dracula.erstellenStatusInformation());
        System.out.println("Willi:\n" + willi.erstellenStatusInformation());

        dracula.verwunden(willi);
        willi.verwunden(dracula);

        System.out.println("Dracula:\n" + dracula.erstellenStatusInformation());
        System.out.println("Willi:\n" + willi.erstellenStatusInformation());
        System.out.println("\n--------------------------------------------------------\n");

        Charakter faulpelz = new Held("Bob Andrews");
        // Möglich, weil ein Held ein Charakter ist.
        System.out.println(faulpelz.erstellenStatusInformation());

        Charakter[] figuren = {dracula, willi, faulpelz};
        for (Charakter figur: figuren) {
            System.out.println(figur.erstellenStatusInformation());
        }
        //System.out.println(faulpelz.getHeldenname());

    }
}
