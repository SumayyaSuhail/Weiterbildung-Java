package de.meinhaus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Enthält eine Liste von Elektrogeräten (List<Elektrogeraet>). Überlege dir
 * wenige Attribute (z. B. name, flaeche).
 */
public class Raum implements Serializable {

    private String name;
    private double flaesche;
    private List<Elektrogeraet> elektrogeraetes = new ArrayList<>();

    public Raum(String name, double flaesche) {
        this.name = name;
        this.flaesche = flaesche;
    }

    public String getName() {
        return name;
    }

    public double getFlaesche() {
        return flaesche;
    }

    public List<Elektrogeraet> getElektrogeraetes() {
        return elektrogeraetes;
    }

    public void addElektrogeraet(Elektrogeraet geraet) {
        if (!elektrogeraetes.contains(geraet)) {
            elektrogeraetes.add(geraet);
        }
    }

    @Override
    public String toString() {
        return "Raum{" +
                "name='" + name + '\'' +
                ", flaesche=" + flaesche +
                ", elektrogeraetes=" + elektrogeraetes +
                '}';
    }
}
