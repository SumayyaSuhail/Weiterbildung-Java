package de.geldautomat;

import de.geldautomat.Exceptions.FalschePinException;
import de.geldautomat.Exceptions.KeineKontoDeckungException;

public class Konto {
    private String kontoNummer;
    private String pin;
    private double aktuellerKontoStand;

    public Konto(String kontoNummer, String pin, double aktuellerKontoStand){
        this.kontoNummer = kontoNummer;
        this.pin = pin;
        this.aktuellerKontoStand = aktuellerKontoStand;
    }

    public boolean pinPruefen(String eingegebenePin) {
        return this.pin.equals(eingegebenePin);
    }

    public void abheben(double betrag) throws KeineKontoDeckungException {
        if (betrag > aktuellerKontoStand) {
            throw new KeineKontoDeckungException("\nInsufficient Balance! Bitte geben Sie weniger als " + aktuellerKontoStand + "€.");
        }
        aktuellerKontoStand -= betrag;
    }

    public String getKontoNummer() {
        return kontoNummer;
    }

    public double getAktuellerKontoStand() {
        return aktuellerKontoStand;
    }

    public void setAktuellerKontoStand(double aktuellerKontoStand) {
        this.aktuellerKontoStand = aktuellerKontoStand;
    }
}
