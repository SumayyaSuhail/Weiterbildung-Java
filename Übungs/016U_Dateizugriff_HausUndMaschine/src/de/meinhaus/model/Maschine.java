package de.meinhaus.model;

import java.io.Serializable;

/**
 * Eine abstrakte Basisklasse mit Attributen, die für alle Maschinen
 * sinnvoll sind (z. B. hersteller, leistung).
 */
public abstract class Maschine implements Serializable {

    private String hersteller;
    private double leistung;

    public Maschine(String hersteller, double leistung) {
        this.hersteller = hersteller;
        this.leistung = leistung;
    }

    public String getHersteller() {
        return hersteller;
    }

    public double getLeistung() {
        return leistung;
    }

    @Override
    public String toString() {
        return "Maschine{" +
                "hersteller='" + hersteller + '\'' +
                ", leistung='" + leistung + '\'' +
                '}';
    }
}
