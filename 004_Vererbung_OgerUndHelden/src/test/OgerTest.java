package test;

import de.ogergames.figuren.Oger;

import java.util.Random;

/**
 * zeigt, wie static Klassen Attribute von allen Objekten einer Klasse gemeinsam genutzt werden.
 */
public class OgerTest {
    public static void main(String[] args) {
        System.out.println("Anfangs, vor dem ersten Konstruktoraufruf hat ogerIdGenerator den Wert: " +
                Oger.getOgerIdGenerator());
        Oger eins = new Oger();
        System.out.println(eins);
        Oger zwei = new Oger();
        System.out.println(zwei);
        Random wuerfel = new Random();
        int anzahl = wuerfel.nextInt(100);
        System.out.println("Schleifendurchläufe: " + anzahl);
        for (int i = 0; i < anzahl; i++) {
            Oger neu = new Oger();
        }
        Oger nachDerSchleifer = new Oger();
        System.out.println("Nach " + nachDerSchleifer);
        System.out.println("Nach vielen Konstruktoren hat der Generator den Wert: " + Oger.getOgerIdGenerator());
        System.out.println("Alle Oger wohnen in " + Oger.ZU_HAUSE);
    }
}
