package de.geldautomat;

import de.geldautomat.Exceptions.KarteNichtLesbarException;

public class Bank {
    private Kunde[] kunden = new Kunde[5];
    int anzahl;

    public void kundeHinzufuegen(Kunde neuKunde) {
        boolean erledigt = false;
        for (int i = 0; i < kunden.length; i++) {
            if (kunden[i] == null) {
                kunden[i] = neuKunde;
                erledigt = true;
                anzahl++;
                break;
            }
        }
        if (!erledigt) {
            System.out.println("Bank ist voll. Neue Kunde kann nicht hinzugefügt werden!");
        }
    }

    public Kunde findeKundeZuKonto(String kontoNummer) throws KarteNichtLesbarException {
        for (int i = 0; i < anzahl ; i++) {
            if (kunden[i].getKonto().getKontoNummer().equals(kontoNummer)) {
                return kunden[i];
            }
        }
        throw new KarteNichtLesbarException("Falsche Karte eingegeben!");
    }
}
