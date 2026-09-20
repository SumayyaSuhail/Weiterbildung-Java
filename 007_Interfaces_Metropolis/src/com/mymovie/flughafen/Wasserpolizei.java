package com.mymovie.flughafen;

/**
 * <pre>
 *     Ein Wasserpolizei Objekt überwacht den Flughafen von Metropolis
 *     Wer in Metropolis schwimmen möchte, braucht die Erlaubnis vom Wasserpolizei.
 *     Die Wasserpolizei ruft die Schwimmen-Methode auf.
 * </pre>
 */
public class Wasserpolizei {
    /**
     * Allgemeine Methode für alle Schwimmer
     * @param schwimmer Referenztyp für alle Typen, die das Interface implementieren
     */
    public void erteilenSchwimmenerlaubnis(Schwimmer schwimmer){
        System.out.println("Prüfungen waren erfolgreich, Schwimmen erlaubnis wird erteilt.");
        System.out.println(schwimmer.getClass().getSimpleName() + ", schön dass du da bist. Du darfst schwimmen.");
        if(schwimmer.kannTauchen()){
            System.out.println("Du kannst tauchen bevor du schwimmst!");
        }
        schwimmer.schwimmen();
    }
}
