package com.mymovie.lebewesen;

import com.mymovie.flughafen.Flieger;

import java.util.Random;

/**
 * <pre>
 *     Ein Spatz ist ein Vogel. (extends).
 *     Ein Spatz ist ein Flieger. (implements).
 *
 *     Referenzen:
 *     Spatz spatzReferenz = new Spatz(); --- starten, fliegen, landen, federkleidPutzen, toString ....
 *     Vogel vogelReferenz = new Spatz(); --- federkleidPutzen, toString ....
 *     Object objectReferenz = new Spatz(); --- toString ....
 *     Flieger fliegerReferenz = new Spatz(); --- starten, fliegen, landen, toString ....
 *
 *     Spatz cast1 = (Spatz) vogelReferenz;
 *     Spatz cast2 = (Spatz) objectReferenz;
 *     Vogel cast3 = (Vogel) objectReferenz;
 *
 *     Spatz cast4 = (Spatz) fliegerReferenz;
 *     Vogel cast5 = (Vogel) fliegerReferenz;
 *     Flieger cast6 = (Flieger) vogelReferenz;
 *     Flieger cast7 = (Flieger) objectReferenz;
 * </pre>
 */
public class Spatz extends Vogel implements Flieger {
    /**
     * übersetzung: Ich mache mich auf, Kirschen zu suchen.
     */
    @Override
    public void starten() throws FederkleidNichtPerfektException{
        Random wuerfel = new Random();
        boolean istPerfektGeputzt = wuerfel.nextBoolean();
        if(istPerfektGeputzt) {
            federkleidPutzen(); //geerbte Methode
            System.out.println("Piep");
        } else {
            throw new FederkleidNichtPerfektException("Federkleid nicht perfekt geputzt!\n");
        }
    }

    /**
     * übersetzung: Ich bin auf der Suche nach Kirschen
     */
    @Override
    public void fliegen(){
        System.out.println("Piep");
    }

    /**
     * übersetzung: OH; das sieht lecker aus!
     */
    @Override
    public void landen(){
        System.out.println("Piep");
        federkleidPutzen();
    }
}
