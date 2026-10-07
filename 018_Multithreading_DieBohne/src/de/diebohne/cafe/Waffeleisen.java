package de.diebohne.cafe;

import static de.diebohne.cafe.DieBohneApp.FARBE2;
import static de.diebohne.cafe.DieBohneApp.RESET;

/**
 * Backt im Laufe des Tages 10 Portionen Waffeln
 */
public class Waffeleisen extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int restWaffelPortionen = 9 - i;
            System.out.println(FARBE2 + "Ein großer Stapel Waffeln wird gebacken "
                    + "und heute werden noch " + restWaffelPortionen + " Stapel gebacken." + RESET);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore){}
        }
    }
}
