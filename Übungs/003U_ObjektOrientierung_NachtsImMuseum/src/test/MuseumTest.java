package test;
import de.nacht.museum.GriechischeStatue;
import de.nacht.museum.Handy;
import de.nacht.museum.PacManAutomat;

/**
 * <pre>
 *     Ein Objekt von Typ wird erstellt / die Klasse GriechischeStatue und PacMan wird instanziert
 *     Ein Objekt vom Typ Handy wird erstellt / die Klasse wird instanziert.
 *     Dann wird über setter die HAS-A-Beziehung der beiden Objekte aufgebaut
 *
 * </pre>
 */

public class MuseumTest {
    public static void main(String[] args) {

        System.out.println("\n---------- Willkommen im Museum! ----------");

        GriechischeStatue statue = new GriechischeStatue();
        Handy handy = new Handy();
        handy.setHandyMarke("Pixel");
        statue.setStatueHandy(handy);

        PacManAutomat pac = new PacManAutomat();
        pac.setName("Pac");
        pac.setAlter(46);
        pac.setFarbe("Gelb");

        System.out.println("\n*** Es wird Nacht und die Ausstellungsstücke erwachen zum Leben. ***");

        System.out.println("Was ist passiert?\n");

        statue.fotoMachen();

        System.out.println();

        System.out.println(pac.getName() + " ist " + pac.getAlter() + " Jahre alt und hat die Farbe " + pac.getFarbe());
        pac.selbstSpielen();

    }
}
