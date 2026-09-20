package de.supermarkt.alphamart.personen;

import de.supermarkt.alphamart.Regal;
import de.supermarkt.alphamart.produkte.Produkt;

public class Kunde extends Person {
    private int geld;

    public Kunde(String name) {
        super(name);
    }

    /**
     * Checks if the product can be purchased based on expiry date for lebensmittel and days in Regal for nonfood
     * The product is purchased only if it is there in the Regal
     * @param produkt product the customer wishes to buy
     */
    public void kaufen(Regal regal, Produkt produkt) {

        if (!produkt.kannVerkaufen()) {
            System.out.println(name + ": " + produkt.getProduktName() + " ist nicht mehr verkaufsfähig.\n");
        } else {
            if(regal.entnehmen(produkt)){
                System.out.println(name + " kauft " + produkt + ".\n");
            } else {
                System.out.println("Das Produkt, " + produkt + " ist im Regal nicht zu finden.\n");
            }
        }
    }
}
