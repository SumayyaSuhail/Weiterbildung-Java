package cafe;
//Dies ist ein Zeilenkommentar: Startet mit // und endet am Ende der Zeile
//package: In welchem Verzeichnis befindet sich die Datei: DieBohne.java

/*
Dies ist ein Blockkommentar
 */

/**
 * Dies ist ein Dokumentationskommentar.
 * So werden Klassen und ihre Inhalte dokumentiert.
 * Dokumentiert werden Klassen, Attribute, Methoden und Konstruktoren
 * Aus dem Dokumentationskommentar werden Webseiten erstellt. Damit können Klassen
 * verwendet werden, ohne den Code lesen zu müssen.
 */
public class DieBohne {
    /**
     * Die main-Methode startet eine Java Anwendung.
     * public static void main(String[] notwendig zum Starten eine Java Anwendung.
     * Wenn die main-Methode endet, endet die Java Anwendung.
     * sout + enter -> System.out.println();
     * Konvention: Variablen Bezeichner (lieblingskaffee, preisSommerKaffee): starten mit einen Kleinbuchstaben und dann
     * CamerlCase. (Worttrennung über Großbuchstaben, keine Unterstriche!)     */
    public static void main(String[] args) {
        System.out.println("Willkommen in Cafe \" Die Bohne\" \n");
        System.out.println("\u0D06");

        String lieblingskaffee;
//        System.out.println(lieblingskaffee); Nicht möglich; Variablen können nur nach der Initialisierung
//        verwendet werden.
        lieblingskaffee = "Latte Macchiato";
        System.out.println(lieblingskaffee);
        double preisLieblingskaffee = 3.99;
        int bestellnummerLieblingskaffee = 101;

        System.out.println("Unser " + lieblingskaffee + " kostet " + preisLieblingskaffee + " €. " +
                "Bestellt wird mit " + bestellnummerLieblingskaffee);

        String sommerKaffee = "EisKaffee";
        double preisSommerKaffee = 2.53;
        int bestellnummerSommerKaffee = 202;

        System.out.println("Unser " + sommerKaffee + " kostet " + preisSommerKaffee + " €. " +
                "Bestellt wird mit " + bestellnummerSommerKaffee);

        String winterKaffee = "Irish Coffee";
        double preisWinterKaffee = 8.88;
        int bestellnummerWinterKaffee = 303;

        System.out.println("Unser " + winterKaffee + " kostet " + preisWinterKaffee + " €. " +
                "Bestellt wird mit " + bestellnummerWinterKaffee);

        System.out.println();
        System.out.println("Wie heißt du?");
        String kundenName = new java.util.Scanner(System.in).nextLine();
//        new java.util.Scanner(System.in).nextLine(); Liest einen eingegebenen text aus der Konsole
        System.out.println(kundenName + ", willkommen in Cafe, welcher Kaffee soll es sein. Bitte gibt " +
                "die BestellNummer ein");

        int bestellung = new java.util.Scanner(System.in).nextInt();
        System.out.println(kundenName + " hat bestellt die BestellNummer " + bestellung);

        if(bestellung == bestellnummerLieblingskaffee){
            System.out.println(lieblingskaffee + " ist auch genau richtig für diese Uhrzeit");
        }

        if(bestellung == bestellnummerSommerKaffee){
            System.out.println(sommerKaffee + " passt zum Wetter!");
        } else {
            System.out.println(sommerKaffee + " wäre jetzt auch gar nicht angebracht");
        }

        if (bestellung == bestellnummerWinterKaffee) {
            System.out.println("Brrrr, kalt, da passt ein " + winterKaffee + " sehr gut");
        } else if (bestellung == 404){
            System.out.println("Das ist ein Fehler!");
        }
        System.out.println("Das haben wir erledigt, gib eine weiter Bestellnummer ein");
        bestellung = new java.util.Scanner(System.in).nextInt();
        if (bestellung != bestellnummerLieblingskaffee
                && bestellung != bestellnummerSommerKaffee
                && bestellung == bestellnummerWinterKaffee){
            System.out.println("Diese Sorte haben wir nicht in Program.");
        } else {
            System.out.println("Auch dieser Kaffee kommt gleich");
        }

        // && Operator: Logisches UND: gesamt nur dann true, wenn alle Teile true sind
        if(bestellung == bestellnummerLieblingskaffee
                || bestellung == bestellnummerSommerKaffee
                || bestellung == bestellnummerWinterKaffee){
            System.out.println("Den Kaffee gibt es, wir haben diese Sorte");
        }
        else {
            System.out.println("Diese Sorte haben wir nicht");
        }
    }
}
