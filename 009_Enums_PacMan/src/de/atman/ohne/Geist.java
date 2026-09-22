package de.atman.ohne;

/**
 * <pre>
 *     Template für die 4 Geister im Pac Man Spiel.
 *     Referenztyp für die Geister.
 *
 *     Der Geist Blinky ist rot und hat die Geschwindigkeit 1.0.
 * </pre>
 */
public class Geist {
    /** Weil Geister so wichtig sind zb BLINKY in Großbuchstaben */
    private String name;
    /** zb rot */
    private String farbe;
    /** Geschwindigkeit: Felder pro Sekunde */
    private double geschwindigkeit;

    /** .... */
    public Geist(String name, String farbe, double geschwindigkeit) {
        this.name = name;
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
    }
    // todo pacmanFangen

    public String getFarbe() {
        return farbe;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    /**
     * Der Name des Geistes soll einfach anzusprechen sein, deshalb wird
     * er in der toString Methode zurückgegeben
     * @return Name des Geistes
     */
    @Override
    public String toString() {
        return name;
    }
}
