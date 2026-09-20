package test;

import de.ogergames.figuren.Charakter;
import de.ogergames.kaempfen.Turnier;

/**
 * Testet verbessert die Klasse Charakter
 */
public class CharakterTest {
    /** wie immer .... */
    public static void main(String[] args) {
        Charakter tom = new Charakter();
        Charakter jerry = new Charakter();

        System.out.println("Tom:\n" + tom.erstellenStatusInformation());
        System.out.println("Jerry:\n" + jerry.erstellenStatusInformation());

        Turnier duell = new Turnier();
        duell.duellieren(tom, "Tom", jerry, "Jerry");

        Charakter tomTriell = new Charakter();
        Charakter jerryTriell = new Charakter();
        Charakter spike = new Charakter();
        Turnier triell = new Turnier();
        triell.triellieren(tomTriell, "Tom", jerryTriell, "Jerry", spike, "Spike");
        triell.erklaertSiegerTriell(tomTriell, "Tom", jerryTriell, "Jerry", spike, "Spike");
    }
}
