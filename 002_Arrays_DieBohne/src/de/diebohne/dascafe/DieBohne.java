package de.diebohne.dascafe;
//Packages stellen eine Pfadangabe dar
//Packages sind eindeutig: über die eigene Domain.

/**
 * <pre>
 *     Demonstriert den Aufbau und die Verwendung von <b>Arrays</b>
 *
 *     Arrays sind Sammlungen gleichartiger Elemente (zb Vorname im Schulungsraum,
 *     Tage der Woche....)
 *
 *     Arrays in Java sind <b>Objekte</b>!
 *     Hier: Einstieg in Objekt-Orientierung in Java.
 * </pre>
 */
public class DieBohne {

    /**
     * <pre>
     *     Organisiert den Ablauf des Programms
     *
     *     String[] getraenke; Variablen -Deklaration mit dem Datentyp: String[] (String-Array)
     *     new String[7]; erstellt ein Objekt: immer mit <b>new</b>
     *     new String[7]; erstellt ein Objekt vom Typ String-Array mit 7 Elementen
     *      getraenke  = new String[7]; Objekt wird erstellt und die Speicheradresse des Objekts wird der
     *      Variablen zugewiesen.
     *      Variablen, die Speicheradressen enthalten können heißen <b>Referenz</b>-Variablen
     *
     *      Alle Elemente eine Arrays sind <b>vorinitialisiert</b>.
     *      int[] : vorinitialisiert mit 0
     *      double[]: vorinitialisiert mit 0.0
     *      boolean[]: vorinitialisiert mit false
     *      String[]: vorinitialisiert mit null
     *
     *      getraenke.length: Die Referenz wir über den . Operator benutzt um mit dem Objekt in Kontakt zu treten.
     *      hier: .length fragt das Array Objekt, wie viele Element es enthält
     * </pre>
     * @param args wird in diesem Programm nicht verwendet
     */
    public static void main(String[] args) {
        System.out.println("Willkommen\n");

        String sorte1 = "Latte Macchiato";
        String sorte2 = "Eiskaffee";
        String sorte3 = "Irish Coffee";

        String[] getraenke;
        getraenke = new String[7];//Indizes: 0,1,2,3,4,5,6 //int i = 0; i < 7; i++
        System.out.println("Referenz getraenke: " + getraenke);
        getraenke[0] = sorte1;
        getraenke[1] = sorte2;
        getraenke[2] = "Irish Coffee";
        getraenke[6] = "Apfelsaft";
        getraenke[5] = "Pfefferminztee";
        getraenke[4] = "Kakao";
        //getraenke[3] wurde nicht gefüllt...
        for(int i = 0; i < 7; i++){
            System.out.println("Position " + i + " enthält " + getraenke[i]);
        }

        double[] preise = new double[getraenke.length];
        System.out.println("Anzahl der Preise: " + preise.length);
        preise[0] = 3.99;
        preise[1] = 2.95;
        preise[2] = 8.99;
        for (int i = 0; i < preise.length; i++){
            if(preise[i] == 0.0){
                preise[i] = 2.44 + i;
            }
            System.out.println(getraenke[i] + " kostet " + preise[i] + " €");
        }
        System.out.println("\n");
        fuellenGetraenkeArray(getraenke);
        System.out.println(getraenke[3]);

        for (int i = 0; i < getraenke.length; i++) {
            System.out.print(getraenke[i] + " ");//Print: Ausgabe ohne Zeilenumbruch
        }
        System.out.println();
        for(String sorte: getraenke){  //*for each Schleife, oder korrekt erweitere for-Schleife(extended for-loop)
            System.out.print(sorte + " ");
        }
        System.out.println();

        //Abkürzende Schreibweise, um Arrays zu initialisieren
        int[] bestellnummern = {100, 101, 102, 103, 104, 105, 106};
        //wie: int[] bestellnummern = new int[7], bestellnummern[0] = 100; ...
        System.out.println("Anzahl der Bestellnummern: " + bestellnummern.length);

//        getraenke[7] = "Bier";
        //Der Compiler kann dieses Problem nicht sehen, aber das Programm wird mit einer Exception unterbrochen.

        getraenke = vergroessern(getraenke, 3);
        getraenke[7] = "Bier";
        System.out.println("\nBis bald.");
    }

    /**
     * Hier wird ein größeres Array angelegt: new-Aufruf
     * Deshalb ist eine Rückgabe notwendig, um das neue Array beim Aufrufer verwenden zu konnen
     * @param klein Array mit den ursprünglichen Sorten
     * @param anzahlZusaetzlicheSorten so viele weitere Sorten sollen angeboten werden
     * @return ein <b>neues</b> Array, das die Werte/Elemente der alten Arrays enthält
     */
    public static String[] vergroessern(String[] klein, int anzahlZusaetzlicheSorten){
        String[] gross = new String[klein.length + anzahlZusaetzlicheSorten];

        //Kopiert die Werte des ursprünglichen Arrays in das größere Array hinein.
        for (int i = 0; i < klein.length; i++) {
            gross[i] = klein[i];
        }
        return gross;
    }
    /**
     * <prev>
     *     Parameter wird eine Variable vom Typ String[] eingegeben:
     *     fuellenGetraenkeArray(getraenke): Aufruf gibt eine Kopie der Adresse in die Methode.
     *     damit wird sorten[3] den Inhalt des einen String[] Objekt ändern.
     * </prev>
     * @param sorten Adresse/Referenz des Objekts das in der main mit new erstellt wurde
     */
    public static void fuellenGetraenkeArray(String[] sorten){
        for (int i = 0; i < sorten.length; i++){
            if(sorten[i] == null){
                sorten[i] = "Wasser";
                //Später interaktiv oder aus einer Datei oder...
            }
        }
    }
}
