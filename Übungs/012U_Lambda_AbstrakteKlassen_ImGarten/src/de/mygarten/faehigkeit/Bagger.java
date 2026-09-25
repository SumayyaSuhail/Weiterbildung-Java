package de.mygarten.faehigkeit;

import java.util.Random;

/**
 * <pre>
 *     Abstract class that implements Interface do not need to overwrite methods.
 *     Abstract class cannot be final
 *     Abstract class contains constructor, attributes and methods of it's own
 * </pre>
 */
public abstract class Bagger implements Graber{

    protected int stundenProEinsatz;

    public Bagger(){
        Random wuerfel = new Random();
        stundenProEinsatz = wuerfel.nextInt(1,9);
    }

    public abstract String zeitAngeben();

    @Override
    public String graben(int flaecheGroesse) {
        return "Ein anonymer Spezial-Bagger gräbt " + flaecheGroesse + " Quadratmeter um -- keine besonderen Forderungen.";
    }
}
