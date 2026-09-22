package de.atman.mit;

import java.util.Random;

/**
 * <pre>
 *     Template für Objekte vom Typ GeistImSpiel. (wie class!)
 *     Referenztyp für Objekte vom Typ GeistImSpiel. (wie class!)
 *
 *     Zusätzlich: Alle Objekte dieses Typs werden <b>nur</b> hier erstellt.
 *     enum erstellt:
 *     public static final BLINKY = new GeistImSpiel();
 *     public static final PINKY = new GeistImSpiel();
 *
 *     Elemente eine enums müssen als erstes angegeben werden,
 *     werden mit Komma getrennt,
 *     Aufzählung wird abgeschlossen mit ;
 *     Attribut name wurde nicht vergeben.
 *
 *     enums können nicht erben oder vererbt werden.
 * </pre>
 */
public enum GeistImSpiel {
    BLINKY("rot", 1.0),
    PINKY("pink", 0.95),
    INKY("cyanblue", 0.9),
    CLYDE("orange", 0.85);

    /** die Farbe des Geistes */
    private String farbe;
    /** Geschwindigkeit in Feldern pro Sekunde */
    private double geschwindigkeit;
    /** jeder Geist "merkt" sich, wie oft er PacMan schon gefangen hat */
    private int anzahlGefangenerPacMans;

    /**
     * Konstruktoren eines Enums <b>müssen</b> private sein:
     * public, protected darf nicht verwendet werden, weil sie sowieso private sind, kann 'private' weggelassen werden
     * @param farbe Die Farbe
     * @param geschwindigkeit Geschwindigkeit in Feld/Sekunde
     */
    private GeistImSpiel(String farbe, double geschwindigkeit){
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
    }

    /**
     * <pre>
     *     der Geist versucht PacMan zu fangen.
     *
     *     PacMans FluchtGeschwindigkeit wird ausgewürfelt(Simulation eines Spielers)
     *     Ist der Geist schneller oder genau so schnell wie PacMan, wird PacMan gefangen und
     *     die Anzahl der gefangenen PacMans wird erhöht.
     *
     *     Obwohl die Enum Elemente public, static und final sind, kann sich ihre Zustand verändern
     * </pre>
     * @return ob PacMan gefangen wurde
     */
    public boolean pacManFangen(){
        Random wuerfel = new Random();
        double fluchtGeschwindigkeit = wuerfel.nextDouble(0.8, 1.11);
        boolean pacManGefangen = geschwindigkeit >= fluchtGeschwindigkeit;
        if(pacManGefangen){
            anzahlGefangenerPacMans++;
        }
        return pacManGefangen;
    }

    public String getFarbe() {
        return farbe;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getAnzahlGefangenerPacMans() {
        return anzahlGefangenerPacMans;
    }
}
