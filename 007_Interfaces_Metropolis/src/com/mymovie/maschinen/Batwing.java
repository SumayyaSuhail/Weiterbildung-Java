package com.mymovie.maschinen;

import com.mymovie.flughafen.Flieger;
import com.mymovie.lebewesen.Superman;

import java.util.Random;

/**
 * <pre>
 *     Batman kann nicht fliegen, deshalb hat er sich einen Batwing gebaut.
 *
 *     Der Batwing ist eine Maschine (extends)
 *     Der Batwing ist ein Flieger (implements)
 *
 *     Flieger einFlieger = new Batwing();
 *     einFlieger.starten();
 *
 *     Referenzen:
 *     Batwing batwingReferenz = new Batwing(); --- starten, fliegen, landen, gewartetWerden, toString ....
 *     Maschine maschineReferenz = new Batwing(); --- gewartetWerden, toString ....
 *     Object objectReferenz = new Batwing(); --- toString ....
 *     Flieger fliegerReferenz = new Batwing(); --- starten, fliegen, landen, toString ....
 *
 *     Casting:
 *     Batwing cast1 = (Batwing) maschineReferenz;
 *     Batwing cast2 = (Batwing) objectReferenz;
 *     Maschine cast3 = (Maschine) objectReferenz;
 *
 *     Batwing cast4 = (Batwing) fliegerReferenz;
 *     Maschine cast5 = (Maschine) fliegerReferenz;
 *     Flieger cast6 = (Flieger) maschineReferenz;
 *     Flieger cast7 = (Flieger) objectReferenz;
 * </pre>
 */
public class Batwing extends Maschine implements Flieger {

    private Superman S;

    public Batwing(Superman S) {
        this.S = S;
    }

    /**
     * Manchmal ist der Batwing nicht voll getankt: Das ist ein Problem (und eine Ausnahme)
     */
    @Override
    public void starten() {
        gewartetWerden();
        System.out.println("Batman macht sich auf, Welt zu retten.");
    }

    /**
     * Der Batwing ist genau so schnell wie Superman!
     */
    @Override
    public void fliegen() {
        System.out.println("ZZZZZZZZZZZZZIIIIIIIISCHHHHHHHHHHH");
    }

    @Override
    public void landen() throws NichtVollGetanktException {
        Random wuerfel = new Random();
        boolean istVollGetankt = wuerfel.nextBoolean();
        if (istVollGetankt) {
            System.out.println("Batman ist gelandet, um die Welt zu retten.");
            int supermansWeltrettungen = S.getAnzahlWeltrettungen(); //Hier müsste der getter von Superman aufgerufen werden: übung
            System.out.println("Batman ist besser als Superman, deshalb hat er öfter als " + supermansWeltrettungen
                    + " Mal die Welt gerettet.");
            System.out.println("Batman rettet gerade die Welt, kein Zeit für Wartung, Tanken oder ähnliche " +
                    " Verzögerungen!");
        } else {
            throw new NichtVollGetanktException("Vorsicht! Batwing ist nicht voll getankt.");
        }
    }
}
