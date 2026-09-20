package de.imzoo.tieren;

import java.util.Random;

/**
 * <pre>
 * Elternklasse Insekten
 * In Zoo gibt es ein Insektarium mit verschiedenen Insekten.
 *
 * Objektbeschreibung
 * Dieses Insekt heißt "Zappel" und ist 3.5 cm groß.
 * Dieses Insekt hat eine Lebenserwartung von 60 Tagen.
 *
 * Dieses Insekt bewegt sich.
 * Dieses Insekt sucht nach Nahrung.
 * Dieses Insekt stellt seine aktuellen Statusinformationen zusammen: Name, Größe und Lebenserwartung.
 * </pre>
 */
public class Insekt {

    // ******************** Attribute ******************** //

    /** Name of the insect */
    protected String name;

    /** Size of the Insect in cm */
    protected double grosseInCm;

    /** Lifespan of the insect */
    protected int lebenserwartungInTagen;


    // ******************** Konstruktoren ******************** //
    public Insekt(String name, double grosseInCm){
        this.name = name;
        this.grosseInCm = grosseInCm;
        Random wuerfel = new Random();
        lebenserwartungInTagen = wuerfel.nextInt(1,100);
    }

    // ******************** Methoden ******************** //
    public void sichBewegen() {
        System.out.println(name + " bewegt sich.");
    }

    public void fressen() {
        System.out.println(name + " sucht nach Nahrung.");
    }

    public String statusAnzeigen() {
        String info = "";
        info = info + "Dieses Insekt heißt " + name + ".\n";
        info = info + "Dieses Insekt ist " + grosseInCm + " cm groß.\n";
        info = info + "Dieses Insekt hat eine Lebenserwartung von " + lebenserwartungInTagen + " Tagen.\n";
        return info;
    }
    // ******************** getter/setter ******************** //

}
