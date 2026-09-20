package com.mymovie.maschinen;

/**
 * <pre>
 *     In Metropolis gibt es einige Maschinen. Hier wird ein Template für Maschine-Objekt erstellt.
 *
 *     class: Template/Formular/Vorlage für Objekte vom Typ Maschine: new Maschine(...);
 *            Referenztyp für Variablen,  die Adressen von Maschine-Objekten enthalten können und Objekte von
 *                      erbenden Klassen
 *
 *     Referenzen:
 *      Maschine maschineReferenz = new Maschine();  ----- gewartetWerden, toString, hashCode, equals, getClass
 *      Object objectReferenz = new Maschine(); ----- toString, hashCode, equals, getClass
 *
 *     Casting:
 *      Maschine cast1 = (Maschine) objectReferenz;
 * </pre>
 */
public class Maschine {

    /** Jede Maschine muss gewartet werden */
    public void gewartetWerden(){
        System.out.println("Jetzt sollte alles laufen....");
    }
}
