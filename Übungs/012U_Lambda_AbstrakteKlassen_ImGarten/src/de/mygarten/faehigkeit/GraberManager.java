package de.mygarten.faehigkeit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 *     Klasse vorstellen die verschiedenen Graber-Objekte
 * </pre>
 */
public class GraberManager {

    List<Graber> grabers = new ArrayList<>();

    /** Füllt eine Liste von Graber Objekten */
    public void registrieren(Graber graber){
        System.out.println(graber.getClass().getName() + " wurde erfolgreich registriert.");
        grabers.add(graber);
        System.out.println();
    }

    /** Läuft die Liste der Graber-Objekte in einer
     * Schleife durch und zeigt die Rückgaben der graben Methoden an
     */
    public void vorstellen(){
        Random wuerfel = new Random();
        int flaescheGroesse = wuerfel.nextInt(10,20);
        grabers.forEach(graber -> System.out.println(graber.graben(flaescheGroesse)));
    }

    /** Erhält welcher Graber den Auftrag um Graben und gibt den Typ des Grabers aus */
    public void beauftragen(){
        if (grabers.isEmpty()) {
            System.out.println("Keine Gräber registriert -- kein Auftrag möglich.");
        } else {
            System.out.println("Welcher Gräber soll beauftragt werden?");
            for (int i = 0; i < grabers.size(); i++) {
                System.out.println((i + 1) + ": " + grabers.get(i).getClass().getName());
            }

            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();

            Graber graber = grabers.get(index);
            System.out.println(graber.getClass().getName() + " hat den Auftrag erhalten!");
            graber.graben(10);
            graber.pauseMachen();
        }
    }
}
