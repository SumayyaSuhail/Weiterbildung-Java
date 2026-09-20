package de.altesschloss.derpassendeschluessel;

/**
 * The old castle visited by John
 * consist of an array of doors
 * methods: Adds door to the array
 */
public class Schloss {
    private Tuer[] tuers;
    private int anzahl;

    public Schloss(){
        tuers = new Tuer[4];
        anzahl = 0;
    }

    /**
     * Adds new door to the doorArray if it does not reach the limit
     * @param neueTuer new door to be added
     */
    public void tuerHinzufuegen(Tuer neueTuer) {
        if (anzahl < tuers.length) {
            tuers[anzahl] = neueTuer;
            anzahl++;
        }
    }
}
