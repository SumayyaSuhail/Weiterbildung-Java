package de.sportfoerderung.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     Erstelle eine Klasse Sponsor mit mindestens einem sinnvollen Attribut (z.B. Name).
 *     Erstelle ein Attribut vom Typ Produkt
 *     Ergänze auch hier ein Attribut, das mehrere Sportler speichern kann.
 *     Erstelle folgende Methoden, bzw. lasse sie von der IDE erstellen:
 *     Getter für alle Attribute
 *     Setter für Attribute, die sich ändern können
 *     Eine Methode addSportler(Sportler sportler), die einen Sportler
 *     hinzufügt – aber nicht doppelt
 *     toString()
 * </pre>
 */
public class Sponsor implements Serializable {
    private String name;
    private Produkt produkt;
    private List<Sportler> sportlers = new ArrayList<>();

    public Sponsor(String name, Produkt produkt) {
        this.name = name;
        this.produkt = produkt;
    }
    public String getName() {
        return name;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public List<Sportler> getSportlers() {
        return sportlers;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public void setSportlers(List<Sportler> sportlers) {
        this.sportlers = sportlers;
    }

    public void addSportler(Sportler sportler) {
        if(!sportlers.contains(sportler)){
            sportlers.add(sportler);
            sportler.addSponsor(this);
        }
    }

    @Override
    public String toString() {
        String info = "";
        info = info + "Sponsor: " +
                "name='" + name + '\'' +
                ", produkt=" + produkt +
                ", sportlers=";
        for (Sportler sportler: sportlers) {
            info += sportler.getName();
        }
        return info;
    }
}
