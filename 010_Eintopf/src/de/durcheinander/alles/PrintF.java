package de.durcheinander.alles;

/**
 * <pre>
 *     Demonstriert die formatierte Ausgabe mit printf.
 *
 *     (format-Methode nutzt das gleiche System)
 * </pre>
 */
public class PrintF {
    public static void main(String[] args) {
        String name1 = "Wilhelmine";
        int alter1 = 9;
        double groesse1 = 1.4;
        int schuelerNummer1 = 42;

        String name2 = "Jo";
        int alter2 = 12;
        double groesse2 = 1.51;
        int schuelerNummer2 = 101;

        System.out.println(name1 + " ist " + alter1 + " Jahre alt, sie ist " + groesse1 + "m groß und hat die Nummer " + schuelerNummer1);
        System.out.println(name2 + " ist " + alter2 + " Jahre alt, sie ist " + groesse2 + "m groß und hat die Nummer " + schuelerNummer2);

        System.out.println();

        System.out.printf("%-12s ist %2d Jahre alt, sie ist %.2fm groß und hat die Nummer %05d%n", name1, alter1, groesse1, schuelerNummer1);
        System.out.printf("%-12s ist %2d Jahre alt, sie ist %.2fm groß und hat die Nummer %05d%n", name2, alter2, groesse2, schuelerNummer2);
    }
}
