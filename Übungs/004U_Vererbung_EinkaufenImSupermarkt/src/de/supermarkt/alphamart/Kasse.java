package de.supermarkt.alphamart;

public class Kasse {
    private double geldbestand;

    public Kasse() {
        geldbestand = 0;
    }
    public void einzahlen(double amount){
        geldbestand += amount;
    }

    public double getGeldbestand() {
        return geldbestand;
    }
}
