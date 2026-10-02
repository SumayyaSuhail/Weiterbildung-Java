package de.onlineshop.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * <pre>
 *     Ein POJO Klasse, die der Tabelle 'Kunden' entspricht.
 *
 *     Ein Zeile in der Tabelle entspricht einem Objekt dieser Klasse.
 *
 *     Passend zu den Spalten in der Tabelle gibt es Attribute in der Klasse.
 * </pre>
 */
public class Kunde {
    private Integer kundeId;
    private String vorname;
    private String nachname;
    private String email;
    private LocalDate erstelltAm;

    /** default Objekt zum Testen */
    public Kunde() {
        vorname = "David";
        nachname = "Fischer";
        email = "david.fischer@gmail.com";
        erstelltAm = LocalDate.of(2026, 5, 15);
    }

    /** Konstruktor 'mit allem', zum Lesen aus der Datenbank */
    public Kunde(Integer kundeId, String vorname, String nachname, String email, LocalDate erstelltAm) {
        this.kundeId = kundeId;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.erstelltAm = erstelltAm;
    }

    /** Konstruktor ohne kunde_id: Zum erstellen eines Objektes, das in der Datenbank noch nicht existiert */
    public Kunde(String vorname, String nachname, String email, LocalDate erstelltAm) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.erstelltAm = erstelltAm;
    }

    // ********** Getter/Setter ********** //
    public LocalDate getErstelltAm() {
        return erstelltAm;
    }

    public String getEmail() {
        return email;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public Integer getKundeId() {
        return kundeId;
    }

    public void setKundeId(Integer kundeId) {
        if (this.kundeId != null) {
            throw new KundeIdException("Objekt bereits gespeichert mit: " + this.kundeId);
        }
        this.kundeId = kundeId;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Kunde kunde = (Kunde) object;
        return Objects.equals(vorname, kunde.vorname) && Objects.equals(nachname, kunde.nachname) && Objects.equals(email, kunde.email) && Objects.equals(erstelltAm, kunde.erstelltAm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, nachname, email, erstelltAm);
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundeId=" + kundeId +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", email='" + email + '\'' +
                ", erstelltAm=" + erstelltAm +
                '}';
    }
}
