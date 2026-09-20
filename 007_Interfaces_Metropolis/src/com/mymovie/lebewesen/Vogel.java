package com.mymovie.lebewesen;

/**
 * <pre>
 *     In Metropolis gibt es einige Lebewesen. Hier wird ein Template für Vogel-Objekt erstellt.
 *
 *     class: Template/Formular/Vorlage für Objekte vom Typ Vogel: new Vogel(...);
 *            Referenztyp für Variablen,  die Adressen von Vogel-Objekten enthalten können und Objekte von
 *                      erbenden Klassen
 *
 *     Referenzen:
 *      Vogel vogelReferenz = new Vogel();  ----- federkleidPutzen, toString, hashCode, equals, getClass
 *      Object objectReferenz = new Vogel(); ----- toString, hashCode, equals, getClass
 *
 *     Casting:
 *      Vogel cast1 = (Vogel) objectReferenz;
 * </pre>
 */
public class Vogel {
    /**
     * Jeder Vogel hat Federn. Jeder Vogel bringt seine Federn in Ordnung.
     */
    public void federkleidPutzen(){
        System.out.println("Das Federkleid wird in Ordnung gebracht.");
    }
}
