package de.supermarkt.alphamart.produkte;

public class Produkt {
    protected String produktName;
    protected double produktPreis;

    public Produkt(String produktName, double produktPreis) {
        this.produktName = produktName;
        this.produktPreis = produktPreis;
    }

    /**
     * All products can be sold, overwritten in child classes
     * @return true
     */
    public boolean kannVerkaufen(){
        return true;
    }

    @Override
    public String toString() {
        return produktName + ": (" + produktPreis + "€)";
    }

    public String getProduktName() {
        return produktName;
    }

    public double getProduktPreis() {
        return produktPreis;
    }
}
