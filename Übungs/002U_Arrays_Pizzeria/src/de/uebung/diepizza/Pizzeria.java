package de.uebung.diepizza;

/**
 * <pev>
 *     Übung mit Arrays und Methoden - 02/09/26
 * </pev>
 */
public class Pizzeria {
    /**
     * Organisiert den Ablauf des Programms.
     * @param args wird in diesem Programm nicht verwendet.
     */
    public static void main(String[] args) {
        System.out.println("---------- Willkommen in der Pizzeria! ----------");
        int anzahlPizzaSorten = sortenAnzahlDeklarieren();

        String[] pizzaSorten = new String[anzahlPizzaSorten];
        sortenNameDeklarieren(pizzaSorten);

        double[] preise = new double[anzahlPizzaSorten];
        sortenPreiseDeklarieren(pizzaSorten, preise);

        int[] bestellNummern = new int[anzahlPizzaSorten];
        bestellNummern[0] = 100;
        bestellNummern[1] = 101;
        bestellNummern[4] = 104;
        sortenBestellNummerDeklarieren(pizzaSorten, bestellNummern);

        pizzaKarteAusgeben(pizzaSorten, preise, bestellNummern);

        preisaendern(preise);
        pizzaKarteAusgeben(pizzaSorten, preise, bestellNummern);
    }

    /**
     * <pev>
     *     Methode: Interaktiv erfragen, wie viele Sorten Pizza angeboten werden sollen
     * </pev>
     */
    public static int sortenAnzahlDeklarieren(){
        System.out.println("Wie viele Sorten Pizza sollen angeboten werden?");
        return new java.util.Scanner(System.in).nextInt();
    }

    /**
     * <pre>
     *     Interaktiv Sorten ergänzen
     *     String neueSorte: new java.util.Scanner(System.in).nextLine();
     *     if(str == null){...}
     * </pre>
     * @param pizzaSorten Pizza Sorten Array
     */
    public static void sortenNameDeklarieren(String[] pizzaSorten){
        for (int i = 0; i < pizzaSorten.length; i++) {
            System.out.println("Gib Pizza Sorten " + (i+1) + " ein: ");
            String neueSorte = new java.util.Scanner(System.in).nextLine();
            pizzaSorten[i]=neueSorte;
        }
    }

    /**
     * <pre>
     *      Interaktiv Preise zu den Pizza-Sorten erfragen
     *      double neuerPreis: new java.util.Scanner(System.in).nextDouble();
     *      Beispiel:
     *      Was kostet die Pizza Salami (Sorte aus dem Sorten-Array)
     *      Eingabe durch Benutzer: 3,99 (Eingabe: , (Komma) als Nachkommatrennzeichen)
     *      </pre>
     * @param pizzaSorten Pizza Sorten Array
     * @param preise Array für PizzaPreise
     */
    public static void sortenPreiseDeklarieren(String[] pizzaSorten, double[] preise){
        for (int i = 0; i < preise.length; i++) {
            System.out.println("Was kostet die Pizza " + pizzaSorten[i] + "?");
            double neuerPreis = new java.util.Scanner(System.in).nextDouble();
            preise[i] = neuerPreis;
        }
    }

    /**
     * <pre>
     *     Methode: Interaktiv fehlende Bestellnummern ergänzen
     *     int neueBestellnummer: new java.util.Scanner(System.in).nextInt();
     *     Beispiel:
     *     Unter welcher Bestellnummer soll die Pizza Salami (aus dem Sorten Array) bestellt werden?
     * </pre>
     * @param pizzaSorten Pizza Sorten Array
     * @param bestellNummern Array für PizzaBestellNummer
     */
    public static void sortenBestellNummerDeklarieren(String[] pizzaSorten, int[] bestellNummern){
        for (int i = 0; i < pizzaSorten.length; i++) {
            if(bestellNummern[i] == 0){
                System.out.println("Unter welcher Bestellnummer soll die Pizza " + pizzaSorten[i] + " bestellt werden?");
                int neueBestellnummer = new java.util.Scanner(System.in).nextInt();
                bestellNummern[i] = neueBestellnummer;
            }
        }
    }

    /**
     * Methode: Ausgabe der Pizza-Karte
     * @param pizzaSorten Pizza Sorten Array
     * @param preise Array für PizzaPreise
     * @param bestellNummern Array für PizzaBestellNummer
     */
    public static void pizzaKarteAusgeben(String[] pizzaSorten, double[] preise, int[] bestellNummern){
        System.out.println("---------- MENU KARTE ----------\n");
        System.out.println("BestellNummer\tPreis\tPizza Sorten");
        for (int i = 0; i < pizzaSorten.length; i++) {
            System.out.println(bestellNummern[i] + "\t\t" + preise[i] + "\t" + pizzaSorten[i] + "\n");
        }
    }

    /**
     * <pre>
     *     Methode: Preise über 8 € sollen um 1 € verringert werden//Preise unter 3 € um 10 Cent erhöhen.
     * </pre>
     * @param preise Array für PizzaPreise
     */
    public static void preisaendern(double[] preise){
        for (int i = 0; i < preise.length; i++) {
            if(preise[i] > 8){
                preise[i] -= 1;
            } else if (preise[i] < 3) {
                preise[i] += 0.10;
            }
        }
    }
}
