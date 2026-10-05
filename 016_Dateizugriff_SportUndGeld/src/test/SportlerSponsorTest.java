package test;

import de.sportfoerderung.modal.Produkt;
import de.sportfoerderung.modal.Sponsor;
import de.sportfoerderung.modal.Sportler;

/**
 * Erstelle mindestens 1 Produkt, 2 Sportler und 2 Sponsoren
 * Füge die Beziehungen auf beiden Wegen hinzu (einmal über addSponsor,
 * einmal über addSportler)
 * Gib alle Objekte mit toString() aus und prüfe: Stimmen die Beziehungen?
 * Versuche, denselben Sponsor zweimal hinzuzufügen
 *
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class SportlerSponsorTest {
    public static void main(String[] args) {
        Produkt produkt = new Produkt("Laufschuh XR-500");

        Sponsor nike = new Sponsor("Nike", produkt);
        Sponsor adidas = new Sponsor("Adidas", produkt);

        String sportArt = "Leichtathletik";
        Sportler usain = new Sportler("Usain Bolt", sportArt);
        Sportler allyson = new Sportler("Allyson Felix", sportArt);

        nike.addSportler(usain);
        allyson.addSponsor(adidas);

        System.out.println("\nUsain: " + usain);
        System.out.println("\nAllyson: " + allyson);
        System.out.println("\nNike: " + nike);
        System.out.println("\nAdidas: " + adidas);

        nike.addSportler(usain);
        System.out.println("\nNike: " + nike);
        System.out.println("Usain: " + usain);
    }
}
