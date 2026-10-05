package de.sportfoerderung.modal;

import java.io.Serializable;
import java.util.Objects;

/**
 * <pre>
 *     Erstelle eine Klasse Produkt mit mindestens einem sinnvollen Attribut (z.B. Name).
 *     Lasse dir Konstruktoren, getter, setter, hashCode, equals und toString sinnvoll erstellen.
 * </pre>
 */
public class Produkt implements Serializable {
    private String name;

    public Produkt() {
    }

    public Produkt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Produkt produkt = (Produkt) object;
        return Objects.equals(name, produkt.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                '}';
    }
}
