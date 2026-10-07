package de.diebohne.cafe;

import java.util.concurrent.ThreadLocalRandom;

import static de.diebohne.cafe.DieBohneApp.*;
/**
 * <pre>
 *     Die Maschine kocht Kaffee.
 *
 *     Sie wird morgens eingeschaltet, dann läuft sie und kocht 10 Kannen Kaffee.
 *
 *     Manchmal läuft sie über, dann ruft sie einen Putzroboter, der die Maschine sauber macht und
 *     dann kocht sie weiter. (Später)
 *
 *     Ziel: Die Kaffeemaschine läuft gleichzeitig mit dem restlichen Ablauf im Café.
 *     (zb gleichzeitig mit dem Waffeleisen.)
 * </pre>
 */
public class Kaffeemaschine extends Thread{

    private PutzRoboter cleany;

    public Kaffeemaschine(PutzRoboter cleany) {
        this.cleany = cleany;
    }

    /**
     * Kocht 10 Kannen Kaffee
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int restKannen = 9-i;
            System.out.println(FARBE1 + "Eine Kanne Kaffee wird gekocht. Heute sollen " +
                    "noch " + restKannen + " gekocht werden." + DieBohneApp.RESET);

            if(ThreadLocalRandom.current().nextDouble() < 0.5) {
                System.out.println(VORSICHT + "Achtung: Die KaffeeMaschine läuft über!" + RESET);
                cleany.gewecktWerden();
            }
            try{
                Thread.sleep(100);
            } catch (InterruptedException ignore) {}
        }
    }
}
