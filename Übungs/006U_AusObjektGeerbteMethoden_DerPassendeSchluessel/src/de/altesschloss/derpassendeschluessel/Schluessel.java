package de.altesschloss.derpassendeschluessel;

import java.util.Objects;

/**
 * Klasse Schluessel besitzt große, material, gewicht und schlüsselbart
 */
public class Schluessel {
    private double grosse;
    private String material;
    private double gewicht;
    private SchluesselBart bart;

    public Schluessel(double grosse, String material, double gewicht, SchluesselBart bart) {
        this.grosse = grosse;
        this.material = material;
        this.gewicht = gewicht;
        this.bart = bart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schluessel that = (Schluessel) o;
        return Double.compare(grosse, that.grosse) == 0 && Double.compare(gewicht, that.gewicht) == 0 && Objects.equals(material, that.material) && Objects.equals(bart, that.bart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grosse, material, gewicht, bart);
    }

    @Override
    public String toString() {
        return "Schlüssel: Große-" + grosse + ", Material-" + material + ", Gewicht-" + gewicht + ", " + bart;
    }
}
