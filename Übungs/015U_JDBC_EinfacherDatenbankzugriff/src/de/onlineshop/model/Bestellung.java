package de.onlineshop.model;

import java.util.Objects;

/**
 * <pre>
 *     Ein POJO Klasse, die der Tabelle 'Bestellungen' entspricht.
 *
 *     Ein Zeile in der Tabelle entspricht einem Objekt dieser Klasse.
 *
 *     Passend zu den Spalten in der Tabelle gibt es Attribute in der Klasse.
 * </pre>
 */
public class Bestellung {

    private Integer bestellID;
    private String name;
    private double preis;

    /** default Objekt zum Testen */
    public Bestellung() {
        name = "Kopfhörer";
        preis = 49.90;
    }

    /** Konstruktor 'mit allem', zum Lesen aus der Datenbank */
    public Bestellung(Integer bestellID, String name, double preis) {
        this.bestellID = bestellID;
        this.name = name;
        this.preis = preis;
    }

    /** Konstruktor ohne bestell_id: Zum erstellen eines Objektes, das in der Datenbank noch nicht existiert */
    public Bestellung(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    // ********** Getter/Setter ********** //

    public Integer getBestellID() {
        return bestellID;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public void setBestellID(Integer bestellID) {
        if (this.bestellID != null) {
            throw new BestellungIdException("Objekt bereits gespeichert mit: " + this.bestellID);
        }
        this.bestellID = bestellID;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bestellung that = (Bestellung) object;
        return Double.compare(preis, that.preis) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preis);
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "bestellID=" + bestellID +
                ", name='" + name + '\'' +
                ", preis=" + preis +
                '}';
    }
}

