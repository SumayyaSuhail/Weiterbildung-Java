package de.meinhaus.model;

import java.io.Serializable;

/**
 * Enthält zusätzliche Attribute (z. B.
 * stromverbrauch, geraetetyp).
 */
public class Elektrogeraet extends Maschine implements Serializable {
    private double stromVerbrauch;
    private String geraeteTyp;

    public Elektrogeraet(String hersteller, double leistung, String geraeteTyp, double stromVerbrauch) {
        super(hersteller, leistung);
        this.geraeteTyp = geraeteTyp;
        this.stromVerbrauch = stromVerbrauch;
    }

    public double getStromVerbrauch() {
        return stromVerbrauch;
    }

    public String getGeraeteTyp() {
        return geraeteTyp;
    }

    @Override
    public String toString() {
        return "Elektrogeraet{" +
                "hersteller=" + getHersteller() +
                "leistung=" + getLeistung() +
                "stromVerbrauch=" + stromVerbrauch +
                ", geraeteTyp='" + geraeteTyp + '\'' +
                '}';
    }
}
