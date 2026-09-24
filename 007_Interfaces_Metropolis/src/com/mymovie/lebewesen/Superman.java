package com.mymovie.lebewesen;

import com.mymovie.flughafen.Flieger;
import com.mymovie.maschinen.Batwing;

import java.util.Random;

/**
 * <pre>
 *     Superman ist ein Flieger (implements)
 *
 *     Superman rettet die Welt.
 *     Wenn Superman landet, die Welt ein weiteres Mal gerettet.
 *     Superman zählt die Anzahl seiner Weltrettungen mit.
 *     Die ganze Welt darf wissen, wie oft Superman die Welt schon gerettet hat.
 *
 *     Referenzen:
 *     Superman supermanReferenz = new Superman(); --- starten, fliegen, landen, toString ....
 *     Object objectReferenz = new Superman(); --- toString ....
 *     Flieger fliegerReferenz = new Superman(); --- starten, fliegen, landen, toString ....
 *
 *     Castings:
 *     Superman cast1 = (Superman) objectReference;
 *     Superman cast2 = (Superman) fliegerReferenz;
 *     Flieger cast3 = (Flieger) objectReferenz;
 *
 *     PROBLEM: Es kann nur einen geben! Singleton
 *     Lösung: Singleton Design Pattern
 * </pre>
 */
public class Superman implements Flieger {

    /** Vorgabe aus Klassendiagramm des Singleton Design Patterns */
    private static Superman superman;

    private int anzahlWeltrettungen;

    /** Vorgabe aus dem Klassendiagramm: private wegen - in Diagramm  */
    private Superman() {}

    /**
     * Erstellt beim ersten Mal, wenn diese Methode aufgerufen wird,
     * das einzige Superman Objekt. Bei jeden weiteren Aufruf wird nur
     * die Referenz dieses einzigen Superman-Objekts zurückgegeben.
     * @return Referenz auf den einigen Superman!
     */
    public static Superman getInstance() {
        if (superman == null){
            superman = new Superman();
        }
        return superman;
    }

    /**
     * In einer Telefonzelle zieht sich Superman um und macht sich auf die Welt zu retten.
     * Problem: Es gibt immer weniger Telefonzellen....
     */
    @Override
    public void starten() {
        System.out.println("Auf auf, die Welt muss gerettet werden!");
    }

    /**
     * Nichts und niemand fliegt so schnell wie Superman!
     * Oder ?!
     */
    @Override
    public void fliegen() {
        System.out.println("WUUUUUUSCHHHHHH");
    }

    /**
     * Anzahl der Weltrettungen wird hochgezählt.
     */
    @Override
    public void landen() throws TelefonzelleNichtAuffindbarException {
        Random wuerfel = new Random();
        boolean findetTelefonzelle = wuerfel.nextBoolean();
        if (findetTelefonzelle) {
            anzahlWeltrettungen++;
            System.out.println("Die Welt ist zum " + anzahlWeltrettungen + "te Mal gerettet!");
        } else {
            throw new TelefonzelleNichtAuffindbarException("Kein Telefonzelle gefunden!");
        }
    }

    public int getAnzahlWeltrettungen() {
        return anzahlWeltrettungen;
    }
}
