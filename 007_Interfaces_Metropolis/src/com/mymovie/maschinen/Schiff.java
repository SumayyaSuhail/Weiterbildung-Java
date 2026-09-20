package com.mymovie.maschinen;

import com.mymovie.flughafen.Schwimmer;

/**
 * <pre>
 *     Ein Schiff ist ein Maschine (extends)
 *     Ein Schiff ist ein Schwimmer (implements)
 *
 *     Referenzen:
 *     Schiff schiffReferenz = new Schiff(); --- schwimmen, kannTauchen, gewartetWerden, toString ....
 *     Maschine maschineReferenz = new Schiff(); --- gewartetWerden, toString ....
 *     Object objectReferenz = new Schiff(); --- toString ....
 *     Schwimmer schwimmerReferenz = new Schiff(); --- schwimmen, kannTauchen, toString ....
 *
 *     Casting:
 *     Schiff cast1 = (Schiff) maschineReferenz;
 *     Schiff cast2 = (Schiff) objectReferenz;
 *     Maschine cast3 = (Maschine) objectReferenz;
 *
 *     Schiff cast4 = (Schiff) schwimmerReferenz;
 *     Maschine cast5 = (Maschine) schwimmerReferenz;
 *     Schwimmer cast6 = (Schwimmer) maschineReferenz;
 *     Schwimmer cast7 = (Schwimmer) objectReferenz;
 * </pre>
 */
public class Schiff extends Maschine implements Schwimmer {
    @Override
    public void schwimmen() {
        gewartetWerden();
        System.out.println("Das Schiff gleitet sanft über die Wellen.");
    }

    @Override
    public boolean kannTauchen() {
        System.out.println("DAS SCHIFF KANN NICHT TAUCHEN!");
        return false;
    }
}
