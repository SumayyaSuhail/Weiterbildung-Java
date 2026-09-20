package de.supermarkt.alphamart;

import de.supermarkt.alphamart.produkte.Produkt;

/**
 * Regal stores products in array of products
 */
public class Regal {
    /**
     * List of products enclosed in Array of Datatype Product
     */
    private Produkt[] produkte;
    /**
     * Size of product array
     */
    private int kapazitaet;
    /**
     * How many products are filled in the product array
     */
    private int anzahl;

    public Regal(int kapazitaet) {
        this.kapazitaet = kapazitaet;
        produkte = new Produkt[kapazitaet];
        anzahl = 0;
    }

    /**
     * Fills the Regal with the product
     * @param neueProdukt product to be filled in the Regal
     * @return String with the result
     */
    public String aufFuellen(Produkt neueProdukt) {
        if (anzahl < kapazitaet) {
            produkte[anzahl] = neueProdukt;
            anzahl++;
            return "\nRegal ist mit " + neueProdukt + " aufgefüllt.\n";
        } else {
            return "\nRegal ist voll, derzeit können keine Produkte abgefüllt werden.\n";
        }
    }

    /**
     * A product is removed from regal when someone purchases it.
     * @param produkt product, the customer wishes to purchase.
     * @return true if purchase is possible, else false.
     */
    public boolean entnehmen(Produkt produkt) {
        for (int i = 0; i < anzahl; i++) {
            if (produkte[i] == produkt) {
                for (int j = i; j < anzahl - 1; j++) {
                    produkte[j] = produkte[j + 1];
                }
                produkte[anzahl - 1] = null;
                anzahl--;
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the current products available in regal
     */
    public void regalAnschauen(){
        for (int i = 0; i < anzahl; i++) {
            System.out.println(produkte[i].getProduktName() + ": " + produkte[i].getProduktPreis() + "€");
            System.out.println();
        }
    }
}
