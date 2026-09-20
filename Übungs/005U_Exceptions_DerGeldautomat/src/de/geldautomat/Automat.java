package de.geldautomat;

import de.geldautomat.Exceptions.AutomatLeerException;
import de.geldautomat.Exceptions.FalscherBetragException;
import de.geldautomat.Exceptions.KeineKontoDeckungException;

public class Automat {
    private double geldbestand;

    public Automat(double geldbestand) {
        this.geldbestand = geldbestand;
    }

    public void betragAuszahlen(double betrag, Konto konto)
            throws FalscherBetragException, AutomatLeerException, KeineKontoDeckungException {

        if (betrag <= 0 || betrag % 10 != 0) {
            throw new FalscherBetragException("Betrag muss positiv und ein Vielfaches von 10 sein.");
        }
        if (betrag > geldbestand) {
            throw new AutomatLeerException("Automat hat nicht genug Geld (" + geldbestand + "€ verfügbar).");
        }

        konto.abheben(betrag);
        geldbestand -= betrag;
    }
}
