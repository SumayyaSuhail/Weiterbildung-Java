package de.ogergames.figuren.helden;

import de.ogergames.figuren.Charakter;

import java.util.Random;

/**
 * <pre>
 *     Ein Kluger Krieger mit Heuschnupfen ist ein Kluger Krieger (extends)
 *
 *     Wenn er niest, verliert er zwei Lebenspunkte.
 *     Wegen der ganzen Heuschnupfen Medikamente kann er sich besser ausruhen: er regeneriert immer 5 Punkte zusätzlich.
 *     Er hat oft schlechte Laune, deshalb verursacht er beim verwunden immer einen Schadenspunkt mehr.
 *     Manchmal muss er bei verwunden niesen.
 * </pre>
 */
public class KlugerKriegerMitHeuschnupfen extends KlugerKrieger{

    @Override
    public void ausruhen() {
        // TODO: zusätzlicher Bonus
        super.ausruhen();
    }

    /** reduziert die Lebenspunkte um zwei, dadurch scheidet er vielleicht aus */
    public void niesen(){
        verwundetWerden(2);
    }

//    Diese Methode kann nicht verwendet werden: Die Methode in der Elternklasse ist final.
//    Alles, was mit dem Referenztyp KlugerKrieger angesprochen werden soll, muss die verwunden
//    Methode nehmen, wie die in KlugerKrieger steht: final
//    @Override
//    public void verwunden(Charakter gegner) {
//        System.out.println("HATSCHIII " + kampfschrei.toUpperCase());
//        Random wuerfel = new Random();
//        int zufallszahl = wuerfel.nextInt(100);
//        if (zufallszahl < 30) {
//            niesen();
//        }
//        if (nochDabei) {
//            gegner.verwundetWerden(schadensrate + 1);
//        }
//    }
}
