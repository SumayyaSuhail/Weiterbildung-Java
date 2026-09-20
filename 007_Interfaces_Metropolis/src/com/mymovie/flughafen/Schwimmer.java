package com.mymovie.flughafen;

/**
 * Interface Schwimmer - to invoke schwimmen Methode
 */
public interface Schwimmer {

    /** Manche Maschine und manche Vogel können schwimmen */
    void schwimmen();

    /** Nur Vogel kann tauchen und maschine nicht */
    boolean kannTauchen();
}
