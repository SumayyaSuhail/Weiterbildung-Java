package de.tollemarmelade.ueber.marmelade;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * <pre>
 *     Stringvergleiche, String-Methoden und Strings, die direkt initialisiert werden
 *
 *     In Java werden Strings manchmal in einem <i>String Pool</i> gespeichert.
 *     String info = "Info";
 *     -> Kontrolle: Existiert dieser String im Stringpool?
 *     ja:      Adresse aus dem Pool wird in die Variable info geschrieben.
 *     nein:    String wird im String-Pool gespeichert, dann wird die Adresse zugewiesen.
 *
 *     Wegen String-Pool: String Objekte sind unveränderbar, immutable
 * </pre>
 */
public class AllerhandZuStrings {
    public static void main(String[] args) {
        String wichtig1 = "Kaffee".toUpperCase();
        String wichtig2 = "Kaffee".toUpperCase();
        String wichtigerZusatz = wichtig1;

        System.out.println(wichtig1);
        System.out.println(wichtig2);
        System.out.println(wichtigerZusatz);

        boolean vergleich = wichtig1 == wichtig2;
        System.out.println("wichtig1 == wichtig2: " + vergleich);

        vergleich = wichtig1 == wichtigerZusatz;
        System.out.println("wichtig1 == wichtigerZusatz: " + vergleich);

        String auchgut1 = "Tee";
        String auchgut2 = "Tee";
        String auchgut3 = "Wasser";

        vergleich = auchgut1 == auchgut2;
        System.out.println("auchgut1 == auchgut2: " + vergleich);

        vergleich = auchgut1 == auchgut3;
        System.out.println("auchgut1 == auchgut3: " + vergleich);

        String person1 = "Justus";
        String person2 = "Justus";
        person1.toUpperCase();
        System.out.println(person1);
        System.out.println(person2);

        String person1InGross = person1.toUpperCase();
        //String Methoden verändern den String nicht, erstellen neue Strings.
        System.out.println(auchgut1.toUpperCase()); //erstellt ein neues Objekt

        System.out.println("\n ---------- jetzt wird gelesen ---------- \n");
        String passwort = "s3cret";
        System.out.println("Spricht das Passwort und tritt ein.");
        Scanner leser = new Scanner(System.in);
        String eingegeben = leser.nextLine();
        if(eingegeben == passwort){
            System.out.println("Nur immer rein mit dir");
        } else {
            System.out.println("Du musst leider draußen bleiben.");
        }
        System.out.println("Hahaha, nur ein kleiner Scherz: Strings sollten immer über den Inhalt verglichen werden");

        if(eingegeben.equals(passwort)){
            System.out.println("Jetzt aber, komm rein");
        } else {
            System.out.println("No, immer noch nicht, das war falsch");
        }
        vergleich = wichtig1.equals(new Marmelade());
        System.out.println("wichtig1.equals(new Marmelade(): " + vergleich);
        System.out.println("HashCode der Passworts: " + passwort.hashCode());
        System.out.println("HashCode der Eingabe: " + eingegeben.hashCode());
    }
}
