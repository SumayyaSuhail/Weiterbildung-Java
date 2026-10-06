package de.meinhaus.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Enthält eine Liste von Räumen (List<Raum>). Überlege dir wenige (!)
 * passende Attribute (z. B. adresse, baujahr).
 */
public class Haus implements Serializable {

    private String adresse;
    private int baujahr;
    private List<Raum> raums = new ArrayList<>();

    public Haus(String adresse, int baujahr) {
        this.adresse = adresse;
        this.baujahr = baujahr;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public List<Raum> getRaums() {
        return raums;
    }

    public void addRaum(Raum raum) {
        if (!raums.contains(raum)) {
            raums.add(raum);
        }
    }

    @Override
    public String toString() {
        return "Haus{" +
                "adresse='" + adresse + '\'' +
                ", baujahr=" + baujahr +
                ", raums=" + raums +
                '}';
    }
}
