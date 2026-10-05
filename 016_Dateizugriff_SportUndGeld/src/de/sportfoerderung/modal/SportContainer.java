package de.sportfoerderung.modal;

import java.io.Serializable;
import java.util.List;

/**
 * Gedacht, um viele Sportler/Sponsoren/Produkte in einem Vorgang in eine Datei zu speichern.
 * Oft werden solche Klassen auch Wrapper genannt, zb SportlerWrapper, SponsorenWrapper
 */
public class SportContainer implements Serializable {
    private List<Sportler> vieleSportler;
    private List<Sponsor> vieleSponsoren;
    private List<Produkt> vieleProdukte;

    public SportContainer(List<Sportler> vieleSportler, List<Sponsor> vieleSponsoren, List<Produkt> vieleProdukte) {
        this.vieleSportler = vieleSportler;
        this.vieleSponsoren = vieleSponsoren;
        this.vieleProdukte = vieleProdukte;
    }

    public List<Sportler> getVieleSportler() {
        return vieleSportler;
    }

    public List<Sponsor> getVieleSponsoren() {
        return vieleSponsoren;
    }

    public List<Produkt> getVieleProdukte() {
        return vieleProdukte;
    }
}
