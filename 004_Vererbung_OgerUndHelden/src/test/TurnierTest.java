package test;

import de.ogergames.figuren.Charakter;
import de.ogergames.figuren.Held;
import de.ogergames.kaempfen.Turnier;

import java.util.Random;

/**
 * Testet verbessert die Klasse Turnier
 */
public class TurnierTest {

    /**
     * einen Charakter erstellen,
     * ein Held, Krieger oder KlugerKrieger erstellen,
     * beide Kämpfer in zufälliger Reihenfolge an interaktivDuellieren übergeben,
     * erkennen, ob ein Kämpfer ein Held ist,
     * einen Helden vor jedem Zug zwischen Angreifen und Ausruhen wählen lassen,
     * einen normalen Charakter automatisch angreifen lassen,
     * das Duell beenden, sobald ein Kämpfer ausgeschieden ist,
     * bei einem Helden den Heldennamen ausgeben,
     * bei einem normalen Charakter "Die Monster haben gesiegt." ausgeben
     * @param args wird hier ignoriert
     */
    public static void main(String[] args) {

        Charakter erster = new Charakter();
        Charakter zweiter = new Held("User2");
        Turnier duell = new Turnier();

        System.out.println("Normal Charakter:\n" + erster.erstellenStatusInformation());
        System.out.println("Held:\n" + zweiter.erstellenStatusInformation());
        System.out.println("\n-------------------------------------------------------\n");

        Random wuerfel = new Random();
        int reihenFolge = wuerfel.nextInt(2); //möglich 0,1
        if(reihenFolge == 0){
            System.out.println("Normal Charakter(Erster) beginnt!\n");
            duell.interaktivDuellieren(erster, zweiter);
        } else {
            System.out.println("Held(Erster) beginnt!\n");
            duell.interaktivDuellieren(zweiter, erster);
        }
    }
}
