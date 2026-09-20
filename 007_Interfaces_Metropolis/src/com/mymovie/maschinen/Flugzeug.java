package com.mymovie.maschinen;

import com.mymovie.flughafen.Flieger;

/**
 * <pre>
 *     Ein Flugzeug ist ein Maschine (extends)
 *     Ein Flugzeug ist ein Flieger (implements)
 *
 *     Referenzen:
 *     Flugzeug flugzeugReferenz = new Flugzeug(); --- starten, fliegen, landen, gewartetWerden, toString ....
 *     Maschine maschineReferenz = new Flugzeug(); --- gewartetWerden, toString ....
 *     Object objectReferenz = new Flugzeug(); --- toString ....
 *     Flieger fliegerReferenz = new Flugzeug(); --- starten, fliegen, landen, toString ....
 *
 *     Casting:
 *     Flugzeug cast1 = (Flugzeug) maschineReferenz;
 *     Flugzeug cast2 = (Flugzeug) objectReferenz;
 *     Maschine cast3 = (Maschine) objectReferenz;
 *
 *     Flugzeug cast4 = (Flugzeug) fliegerReferenz;
 *     Maschine cast5 = (Maschine) fliegerReferenz;
 *     Flieger cast6 = (Flieger) maschineReferenz;
 *     Flieger cast7 = (Flieger) objectReferenz;
 * </pre>
 */
public class Flugzeug extends Maschine implements Flieger {

    @Override
    public void starten(){
        gewartetWerden();
        System.out.println("Ohren zu, es wird laut!");
    }

    @Override
    public void fliegen(){
        System.out.println("~~~~~ über den Wolken ~~~~~");
    }

    @Override
    public void landen(){
        System.out.println("JETZT WIRD ES SO RICHTIG LAUT");
        gewartetWerden();
    }
}
