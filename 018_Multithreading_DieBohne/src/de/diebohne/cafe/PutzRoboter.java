package de.diebohne.cafe;

import static de.diebohne.cafe.DieBohneApp.FARBE4;
import static de.diebohne.cafe.DieBohneApp.RESET;

/**
 * <pre>
 *     Der Putzroboter macht die meiste Zeit nichts.
 *     Er ist nicht im Runnable Zustand, der Scheduler kommt nicht dran:
 *     Thread.sleep() sorgt dafür, dass er nicht gewählt werden kann
 *     Damit er trotzdem irgendwann etwas tut, soll er aus dem Schlaf geweckt werden können: interrupt.
 *     Das löst die InterruptedException aus
 * </pre>
 */
public class PutzRoboter extends Thread{

    public void gewecktWerden() {
        interrupt();
    }

    @Override
    public void run() {
        while (true)  {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException geweckt) {
                System.out.println(FARBE4 + "brummel, brummel, alles wieder sauber!" + RESET);
            }
        }
    }
}
