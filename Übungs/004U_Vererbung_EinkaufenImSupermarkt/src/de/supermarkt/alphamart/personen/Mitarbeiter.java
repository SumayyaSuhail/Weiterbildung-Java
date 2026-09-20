package de.supermarkt.alphamart.personen;

import de.supermarkt.alphamart.Regal;
import de.supermarkt.alphamart.produkte.Produkt;

public class Mitarbeiter extends Person{
    protected int mitarbeiterNummer;

    public Mitarbeiter(int mitarbeiterNummer, String name) {
        super(name);
        this.mitarbeiterNummer = mitarbeiterNummer;
    }

    /**
     * Mitarbeiter fills the Regal with produkt if there is space
     * @param regal contains array of products
     * @param produkt product to be filled into the regal
     */
    public void regalAufFuellen(Regal regal, Produkt produkt){
        String ergebnis = regal.aufFuellen(produkt);
        System.out.println(name + " (Nr. " + mitarbeiterNummer + "): " + ergebnis);
    }

    public int getMitarbeiterNummer() {
        return mitarbeiterNummer;
    }
}
