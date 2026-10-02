package de.tollemarmelade.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * <pre>
 *     Ein POJO(Plain Old Java Object) Klasse, die der Tabelle 'Marmelade' entspricht.
 *
 *     Ein Zeile in der Tabelle entspricht einem Objekt dieser Klasse.
 *
 *     Passend zu den Spalten in der Tabelle gibt es Attribute in der Klasse.
 * </pre>
 */
public class Marmelade {
    /**
     * Entspricht der Spalte marmelade_id.
     * Eine solche ID wird in der Objekt-Orientierung nicht gebraucht,
     * aber hier soll ein Datensatz aus einer Datenbank repräsentiert werden.
     * Deshalb ist dieses Attribut hier notwendig.
     * Die ID kommt immer aus der Datenbank (AI - Auto Increment)
     */
    private Integer marmeladeId; // = null;
    /**
     * Entspricht den varchar in der Datenbank
     */
    private String name;
    private String obst;
    /** Entspricht int in der Tabelle */
    private int zuckergehalt; // = 0;
    /** Entspricht Date in der Tabelle */
    private LocalDate gekochtAm;
    /** Entspricht tinyInt in der MySQL Datenbank */
    private boolean bitter;

    /** ein 'default' Objekt, schnelles Testen */
    public Marmelade() {
        name = "Himbeertraum";
        obst = "Himbeeren";
        zuckergehalt = 55;
        gekochtAm = LocalDate.of(2025,9,1);
        bitter = false;
    }

    /** Konstruktor 'mit allem', zum Lesen aus der Datenbank */
    public Marmelade(Integer marmeladeId, String name, String obst, int zuckergehalt, LocalDate gekochtAm, boolean bitter) {
        this.marmeladeId = marmeladeId;
        this.name = name;
        this.obst = obst;
        this.zuckergehalt = zuckergehalt;
        this.gekochtAm = gekochtAm;
        this.bitter = bitter;
    }

    /** Konstruktor ohne marmelade_id: Zum erstellen eines Objektes, das in der Datenbank noch nicht existiert */
    public Marmelade(String name, String obst, int zuckergehalt, LocalDate gekochtAm, boolean bitter) {
        this.name = name;
        this.obst = obst;
        this.zuckergehalt = zuckergehalt;
        this.gekochtAm = gekochtAm;
        this.bitter = bitter;
    }

    // ********** Getter/Setter ********** //
    public Integer getMarmeladeId() {
        return marmeladeId;
    }

    public String getName() {
        return name;
    }

    public String getObst() {
        return obst;
    }

    public int getZuckergehalt() {
        return zuckergehalt;
    }

    public LocalDate getGekochtAm() {
        return gekochtAm;
    }

    public boolean isBitter() {
        return bitter;
    }
    /** Ein Wert, der geändert werden kann */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ein Marmelade Objekt wird erstellt (marmeladeId ist null) und dann in die Datenbank geschrieben:
     * Aus der Datenbank wird der erstellte Primärschlüssel erfragt und das Objekt mit dem
     * Schlüssel aktualisiert.
     * @param marmeladeId die von der Datenbank vergebene marmelade_id
     */
    public void setMarmeladeId(Integer marmeladeId) {
        if (this.marmeladeId != null) {
            throw new MarmeladeIdException("Objekt bereits gespeichert mit: " + this.marmeladeId);
        }
        this.marmeladeId = marmeladeId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Marmelade marmelade = (Marmelade) object;
        return zuckergehalt == marmelade.zuckergehalt && bitter == marmelade.bitter && Objects.equals(obst, marmelade.obst) && Objects.equals(gekochtAm, marmelade.gekochtAm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obst, zuckergehalt, gekochtAm, bitter);
    }

    @Override
    public String toString() {
        return "Marmelade{" +
                "marmeladeId=" + marmeladeId +
                ", name='" + name + '\'' +
                ", obst='" + obst + '\'' +
                ", zuckergehalt=" + zuckergehalt +
                ", gekochtAm=" + gekochtAm +
                ", bitter=" + bitter +
                '}';
    }
}
