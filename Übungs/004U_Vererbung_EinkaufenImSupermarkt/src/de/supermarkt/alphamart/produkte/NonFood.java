package de.supermarkt.alphamart.produkte;

import java.util.Random;

public class NonFood extends Produkt{

    private int tageImRegal;

    public NonFood(String produktName, double produktPreis) {
        super(produktName, produktPreis);
    }

    /**
     * Overrides the method to check if the product has been too long in the shelf
     * @return false, if the product is unmodern and cannot be sold, true otherwise.
     */
    @Override
    public boolean kannVerkaufen() {
        Random wuerfel = new Random();
        this.tageImRegal = wuerfel.nextInt(100);
        if(tageImRegal > 50){
            System.out.println("Unmodern!");
            return false;
        }
        return true;
    }
}
