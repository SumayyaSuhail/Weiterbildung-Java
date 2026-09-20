package test;

import de.imzoo.tieren.Biene;
import de.imzoo.tieren.Heuschrecke;
import de.imzoo.tieren.Insekt;

/**
 * Testet die Elternklasse Insekten und Kind klassen - Biene und Heuschrecke
 */
public class InsektenTest {

    public static void main(String[] args) {

        // ******************** 1) Begrüßung ******************** //
        System.out.println("Willkommen im Zoo!\n");

        // ******************** 2) Objekte erstellen, verschiedene Referenztypen testen ******************** //

        System.out.println("********** Insekt - Zappel **********\n");
        Insekt zappel = new Insekt("Zappel", 3.5);
        zappel.sichBewegen();
        zappel.fressen();
        System.out.println("\nStatus: " + zappel.statusAnzeigen());

        // Referenztyp = Klasse selbst
        System.out.println("********** Biene - Bee **********\n");
        Biene bee = new Biene("Bee", 1.5);
        bee.sichBewegen();
        bee.honigProduzieren();
        bee.honigProduzieren();
        System.out.println("\nStatus: " + bee.statusAnzeigen());

        System.out.println("********** Heuschrecke - Hopper **********\n");
        Heuschrecke hopper = new Heuschrecke("Hopper", 5.0, 40.0);
        hopper.sichBewegen();
        System.out.println("\nStatus: " + hopper.statusAnzeigen());

        // Referenztyp = Elternklasse
        Insekt insekt1 = new Biene("Willi", 1.3);
        Insekt insekt2 = new Heuschrecke("Grashüpfer", 4.5, 35.0);

    }
}
