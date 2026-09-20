package com.mymovie.flughafen;

import com.mymovie.lebewesen.Spatz;
import com.mymovie.lebewesen.Superman;
import com.mymovie.lebewesen.TelefonzelleNichtAuffindbarException;
import com.mymovie.maschinen.Flugzeug;
import com.mymovie.maschinen.NichtVollGetanktException;

/**
 * <pre>
 *     Ein Tower Objekt überwacht den Flughafen von Metropolis
 *     Wer in Metropolis landen möchte, braucht die Erlaubnis vom Tower.
 *     Der Tower ruft die Landen-Methode auf.
 *
 *     Später: Luftraum-überwachung mit Aufruf der fliegen Methode, Erteilen vom Starterlaubnis....
 *
 *     Gebraucht wird: Referenztyp für Spatz, Flugzeug, Superman, Batwing, Hornisse....
 *     mit Methode landen (starten, fliegen), gebraucht wird kein Objekt-Typ, keinen Inhalt für
 *     die landen Methode.
 * </pre>
 */
public class Tower {
    /**
     * Allgemeine Methode für alle Flieger: Spatz, Superman, Flugzeug ....
     * @param flieger ein Parameter vom Typ eines interfaces: Referenztyp für alle Typen, die das Interface implementieren
     */
    public void erteilenLandeerlaubnis(Flieger flieger) throws TelefonzelleNichtAuffindbarException, NichtVollGetanktException {
        System.out.println("Prüfungen waren erfolgreich, Lande erlaubnis wird erteilt.");
        System.out.println(flieger.getClass().getSimpleName() + ", schön dass du da bist. Du darfst laden.");
        flieger.landen();
    }
/*
    public void erteilenLandeerlaubnis(Spatz flieger){
        System.out.println("Prüfungen waren erfolgreich, Lande erlaubnis wird erteilt.");
        System.out.println(flieger.getClass().getSimpleName() + ", schön dass du da bist. Du darfst laden.");
        flieger.landen();
    }

    public void erteilenLandeerlaubnis(Flugzeug flieger){
        System.out.println("Prüfungen waren erfolgreich, Lande erlaubnis wird erteilt.");
        System.out.println(flieger.getClass().getSimpleName() + ", schön dass du da bist. Du darfst laden.");
        flieger.landen();
    }

    public void erteilenLandeerlaubnis(Superman flieger){
        System.out.println("Prüfungen waren erfolgreich, Lande erlaubnis wird erteilt.");
        System.out.println(flieger.getClass().getSimpleName() + ", schön dass du da bist. Du darfst laden.");
        flieger.landen();
    }

 */
}
