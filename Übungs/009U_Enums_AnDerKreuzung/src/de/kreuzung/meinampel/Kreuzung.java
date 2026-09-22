package de.kreuzung.meinampel;

import java.util.Random;

/**
 * Takes a random phase based on the index and calls umschalten method 5 times.
 */
public class Kreuzung {
    public static void main(String[] args) {
        AmpelPhase[] phaseArray = AmpelPhase.values();
        Random wuerfel = new Random();
        int phaseIndex = wuerfel.nextInt(0,4);

        Ampel meinAmpel = new Ampel(phaseArray[phaseIndex]);
        for (int i = 0; i < 5; i++) {
            meinAmpel.umschalten();
            System.out.println(meinAmpel);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                System.out.println("Exception mit Thread.");
            }
        }
    }
}
