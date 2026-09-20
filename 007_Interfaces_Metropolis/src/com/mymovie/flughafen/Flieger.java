package com.mymovie.flughafen;

import com.mymovie.lebewesen.FederkleidNichtPerfektException;
import com.mymovie.lebewesen.TelefonzelleNichtAuffindbarException;
import com.mymovie.maschinen.NichtVollGetanktException;

/**
 * <pre>
 *     interface: erstellt einen Referenztyp: Flieger eins = ....
 *     interface erstellt KEINEN Objekttyp: new Flieger(); ist nicht möglich
 *     interface haben keinen Konstruktor und keine (Objekt) Attribute
 *
 *     ABER: interfaces können von Klassen implementiert werden.
 *     Damit zb Flieger flieger1 = new Hornisse();
 *     Interfaces erstellen auch eine IS-A-Beziehung: Ein Batwing ist ein Flieger
 *
 *     Interface haben Methoden ohne Körper, nur Signatur: hei0t Abstrakte Methode
 * </pre>
 */
public interface Flieger {
    /**
     * Ein <b>Abstrakte</b> Methode: {....} fehlt,
     * Superman landet anders als ein Spatz
     */
    public void landen() throws TelefonzelleNichtAuffindbarException, NichtVollGetanktException;

    /**
     * Methoden im Interface sind public, deshalb kann das Schlüsselwort weggelassen werden
     */
    void fliegen();

    /**
     * Jeder, der ein Flieger ist, kann auch starten
     */
    void starten() throws FederkleidNichtPerfektException;
}
