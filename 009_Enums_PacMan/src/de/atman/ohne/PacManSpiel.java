package de.atman.ohne;

/**
 * <pre>
 *     Eine sehr verkürzte Form des Pacman Spiels.
 *
 *     Das Spiel hat vier Geister:
 *     Blinky, Pinky, Inky und Clyde.
 * </pre>
 */
public class PacManSpiel {
    /** der erste Geist, der schnellste Geist, er bewegt sich mit einem ganzen Feld pro Sekunde */
    public static final Geist BLINKY = new Geist("BLINKY", "rot", 1.0);
    /** PINKY ist etwas langsamer als BLINKY */
    public static final Geist PINKY = new Geist("PINKY", "pink", 0.95);
    /** INKY ist langsamer als BLINKY und PINKY, aber schneller als CLYDE */
    public static final Geist INKY = new Geist("INKY", "cyanblau", 0.9);
    /** der langsamste Geist */
    public static final Geist CLYDE = new Geist("CLYDE", "orange", 0.85);

    private static final Geist[] ALLE_GEISTER = {BLINKY, PINKY, INKY, CLYDE};

    public static Geist[] erstellenDerGeister(){
        Geist[] alleGeister = {BLINKY, PINKY, INKY, CLYDE};
        alleGeister = ALLE_GEISTER.clone();
        return alleGeister;
    }
}
