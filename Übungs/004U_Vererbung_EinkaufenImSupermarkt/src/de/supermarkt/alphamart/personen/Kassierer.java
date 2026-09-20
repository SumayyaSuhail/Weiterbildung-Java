package de.supermarkt.alphamart.personen;

import de.supermarkt.alphamart.Kasse;

public class Kassierer extends Mitarbeiter{

    public Kassierer(int mitarbeiterNummer, String name) {
        super(mitarbeiterNummer, name);
    }

    /**
     * Kassierer kassiert einen Einkauf und erhöht den Kassenbestand.
     */
    public void kassieren(Kasse kasse, double betrag){
        kasse.einzahlen(betrag);
        System.out.println(getName() + " kassiert " + betrag + "€. Neuer Kassenbestand: "
                + kasse.getGeldbestand() + "€\n");
    }


}
