package test;

import de.supermarkt.alphamart.Regal;
import de.supermarkt.alphamart.produkte.Lebensmittel;
import de.supermarkt.alphamart.produkte.NonFood;
import de.supermarkt.alphamart.produkte.Produkt;

public class RegalTest {
    public static void main(String[] args) {
        //Add products to Regal
        Produkt milch = new Produkt("Milch", 1);
        Produkt kaese = new Produkt("Käse", 1.99);
        Produkt saft = new Lebensmittel("Saft", 2, "10.09.2026");
        Produkt kleid = new NonFood("Kleid", 30);
        Regal regal = new Regal(3);
        regal.aufFuellen(milch);
        regal.aufFuellen(kaese);
        regal.aufFuellen(milch);
        regal.regalAnschauen();

        //Remove products from Regal
        regal.entnehmen(milch);
        regal.regalAnschauen();
        regal.entnehmen(saft);

        //Checks mhd of lebensmittel
        System.out.println(saft.kannVerkaufen());

        //Check nonfood sellable or not
        System.out.println(kleid.kannVerkaufen());
    }
}
