package de.atman.ohne;

/**
 * <pre>
 *     Versuche mit den Geistern und dem Spiel
 * </pre>
 */
public class BlickAufPacMan {
    public static void main(String[] args) {
//        Geist[] dieGeister = PacManSpiel.ALLE_GEISTER;
        Geist[] dieGeister = PacManSpiel.erstellenDerGeister();
        System.out.println("Die Geister im Spiel: ");
        for (Geist geist : dieGeister) {
            System.out.print(geist + " "); //ruft geist.toString auf
        }
        System.out.println();
        System.out.println(PacManSpiel.INKY + " hat die Farbe " + PacManSpiel.INKY.getFarbe() + " und " +
                "bewegt sich mit der Geschwindigkeit " + PacManSpiel.INKY.getGeschwindigkeit() + " Felder pro Sekunde.");

        System.out.println("\nHarry Hacker kommt zum Spielen....");
        System.out.println("Harry sagt, 4 Geister sind viel zu viele....");
        dieGeister[0] = null;
        dieGeister[1] = null;
        dieGeister[3] = null;
        System.out.println("Die Geister in Harrys Spiel: ");
        for (Geist geist : dieGeister) {
            System.out.print(geist + " ");
        }
        System.out.println();
        System.out.println("\nBenno Brav kommt zum Spielen");
//        Geist[] bennoGeister = PacManSpiel.ALLE_GEISTER;
        Geist[] bennoGeister = PacManSpiel.erstellenDerGeister();
        System.out.println("Die Geister in Bennos Spiel: ");
        for (Geist geist : bennoGeister) {
            System.out.print(geist + " ");
        }
        System.out.println();
//        PacManSpiel.ALLE_GEISTER = new Geist[3]; Nicht möglich: ALLE_GEISTER ist final!
    }
}
