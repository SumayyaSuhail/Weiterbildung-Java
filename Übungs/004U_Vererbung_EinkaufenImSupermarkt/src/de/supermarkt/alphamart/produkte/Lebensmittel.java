package de.supermarkt.alphamart.produkte;

public class Lebensmittel extends Produkt{

    private String mindestensHaltbarBis;

    public Lebensmittel(String produktName, double produktPreis, String mindestensHaltbarBis) {
        super(produktName, produktPreis);
        this.mindestensHaltbarBis = mindestensHaltbarBis;
    }

    /**
     * Overrides method to check if the expiry date is vorbei
     * @return true if the product can still be sold
     */
    @Override
    public boolean kannVerkaufen() {
        String heute = "10.09.2026";
        return mindestensHaltbarBis.compareTo(heute) >= 0;
    }
}
