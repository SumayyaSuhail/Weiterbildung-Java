package test;

import de.ogergames.figuren.Charakter;
import de.ogergames.figuren.Held;
import de.ogergames.figuren.helden.KlugerKriegerMitHeuschnupfen;

import java.util.Scanner;

/**
 * Object ist die Elternklasse aller Klassen in Java.
 * Object ist die Wurzel jeder Vererbungshierarchie in Java
 */
public class ObjectTest {
    public static void main(String[] args) {
        Object referenzFuerAlles = new Held("Dracula die Fledermaus", "Peter");
        System.out.println(referenzFuerAlles.getClass());
        referenzFuerAlles = new Scanner(System.in);
        System.out.println(referenzFuerAlles.getClass());
        referenzFuerAlles = new Charakter();
        System.out.println(referenzFuerAlles.getClass());
        KlugerKriegerMitHeuschnupfen nerd = new KlugerKriegerMitHeuschnupfen();
        System.out.println(nerd.getClass());
        System.out.println(referenzFuerAlles);
        System.out.println(referenzFuerAlles.toString());
        System.out.println(nerd.toString());
        Object klasse = referenzFuerAlles.getClass();
        System.out.println(klasse);
        System.out.println("Datentyp von Nerd: " + nerd.getClass().getSimpleName());
        System.out.println("\n---------------------------------------------\n");
        System.out.println(nerd.erstellenStatusInformation());
        System.out.println("\n---------------------------------------------\n");
        System.out.println(nerd); //Ruft nerd.toString();
    }
}
