package com.mymovie.lebewesen;

import com.mymovie.flughafen.Flieger;
import com.mymovie.flughafen.Schwimmer;

/**
 * <pre>
 *     Eine Ente ist ein Vogel. (extends).
 *     Eine Ente ist ein Flieger. (implements).
 *     Eine Ente ist ein Schwimmer. (implements).
 *
 *     Referenzen:
 *     Ente enteReferenz = new Ente(); --- schwimmen, kannTauchen, starten, fliegen, landen, federkleidPutzen, toString ....
 *     Vogel vogelReferenz = new Ente(); --- federkleidPutzen, toString ....
 *     Object objectReferenz = new Ente(); --- toString ....
 *     Flieger fliegerReferenz = new Ente(); --- starten, fliegen, landen, toString ....
 *     Schwimmer schwimmerReferenz = new Ente(); --- schwimmer, kannTauchen, toString ....
 *
 *     Ente cast1 = (Ente) vogelReferenz;
 *     Ente cast2 = (Ente) objectReferenz;
 *     Ente cast3 = (Ente) fliegerReferenz;
 *     Ente cast4 = (Ente) schwimmerReferenz;
 *
 *     Vogel cast5 = (Vogel) objectReferenz;
 *     Flieger cast6 = (Flieger) objectReferenz;
 *     Schwimmer cast7 = (Schwimmer) objectReferenz;
 *
 *     Vogel cast8 = (Vogel) fliegerReferenz;
 *     Flieger cast9 = (Flieger) vogelReferenz;
 *     Vogel cast10 = (Vogel) schwimmerReferenz;
 *     Schwimmer cast11 = (Schwimmer) vogelReferenz;
 *     Flieger cast12 = (Flieger) schwimmerReferenz;
 *     Schwimmer cast13 = (Schwimmer) fliegerReferenz;
 * </pre>
 */
public class Ente extends Vogel implements Flieger, Schwimmer {

    @Override
    public void starten() {
        federkleidPutzen();
        System.out.println("Quak");
    }

    @Override
    public void fliegen() {
        System.out.println("Quak");
    }

    @Override
    public void landen() {
        System.out.println("Quak");
        federkleidPutzen();
    }

    @Override
    public void schwimmen() {
        System.out.println("Quak Quak");
    }

    @Override
    public boolean kannTauchen() {
        return true;
    }
}
