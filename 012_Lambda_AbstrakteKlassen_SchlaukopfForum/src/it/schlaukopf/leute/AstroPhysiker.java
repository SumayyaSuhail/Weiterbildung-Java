package it.schlaukopf.leute;

import java.util.Random;

/**
 * <pre>
 *     Ein Astrophsiker ist ein Physiker und damit auch ein Schlaukopf.
 *
 *     Für das Forum werden Objekte gebraucht, deshalb soll diese Klasse
 *     instanziert werden können: konkrete Klasse.
 * </pre>
 */
public class AstroPhysiker extends Physiker {

    /**
     * Implizit wird der Konstruktor aus der Physiker Klasse aufgerufen.
     * Damit wird die Anzahl zerstörter Messgeräte ausgewürfelt.
     */
    public AstroPhysiker() {
        //super(); wird durchgeführt!
        System.out.println("Die verwendetet Teleskope sind sehr sehr teuer."
                + "Ich passe auf, dass sie selten kaputt gehen. Trotzdem ist das schon " + azahlZerstoerterMessgeraete
                + " Mal passiert.");
    }

    /**
     * Die Methode forschen ist in der Klasse Physiker abstrakt:
     * Sie muss hier implementiert werden, weil diese Klasse nicht abstrakt ist.
     */
    @Override
    public void forschen() {
        System.out.println("Ich beobachte das Universum, sammle Datum und finde dunkle Materie, Rote Riesen, " +
                "weiße Zwerge und so allerlei. Manchmal geht auch dabei ein Messgerät kaputt");
        Random wuerfel = new Random();
        int zufall = wuerfel.nextInt(100);
        if (zufall > 70) {
            azahlZerstoerterMessgeraete++;
            System.out.println("Ups, Kaputt, das war Nr " + azahlZerstoerterMessgeraete + "...");
        }
    }

    /**
     * Die Reden Methode ist im Interface Schlaukopf abstrakt:
     * Sie muss hier implementiert werden.
     * @return Die Erkenntnis des Astrophysikers
     */
    @Override
    public String reden() {
        return "Je mehr wir über das Universum erfahren, desto mehr Fragen haben wir.";
    }

    /**
     * Ein Fähigkeit des Astrophysikers.
     */
    public void schwarzeLoecherSuchen() {
        System.out.println("Schwarze Löcher sind schwer zu finden, sie sind so dunkel!");
    }
}
