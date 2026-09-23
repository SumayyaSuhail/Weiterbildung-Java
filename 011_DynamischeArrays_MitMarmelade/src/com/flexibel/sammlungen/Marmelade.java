package com.flexibel.sammlungen;

import java.time.LocalDate;
import java.util.Objects;

/**
 * <pre>
 *     Template for Marmelade Objekte, Referenztyp für Marmelade-Objekte.
 *
 *     Marmelade Klasse fasst zusammen: Name, Obst, besondere Zutat, Koch, Zuckergehalt, Herstellungsdatum.
 *
 *     Marmelade hat: Name, Obst, besondere Zutat, Koch, Zuckergehalt, Herstellungsdatum.
 *     Marmelade kann: NICHTS (getter/setter/toString)
 *
 *     Klassen, deren Aufgabe das Zusammenfassen von Daten ist, nennt man
 *     Plain Old Java Objects: POJO
 *     Data Transfer Objects: DTO
 *     Entity: Objekte entsprechen oft einer Zeile in einer Datenbank Tabelle
 *
 *     Meistens: keine Vererbung bei DTO's/POJO's/Entities
 * </pre>
 */
public class Marmelade {
    /**
     * Name der Marmelade, kann immer passend zur Situation  geändert werden zb Herstferien-Versüßer
     */
    private String name;
    /**
     * aktuell nur ein String, später vielleicht ein eigener Datentyp
     */
    private String obst;
    /**
     * ein ungewöhnlicher Kick, zb Basilikum, Ingwer, Amaretto...
     */
    private String besondereZutat;
    /**
     * aktuell nur ein String, später vielleiocht ein eigener Datentyp
     */
    private String koch;
    /**
     * wird in Prozent angegeben
     */
    private int zuckergehalt;
    /**
     * Herstellungsdatum
     */
    private LocalDate gekochtAm;

    /**
     * "Default-Objekt". ein Beipielobjekt zum Test, für Vergleiche, ...
     */
    public Marmelade() {
        name = "Herbstzauber";
        obst = "Apfel";
        besondereZutat = "Rum";
        koch = "Bibbi";
        zuckergehalt = 40;
        gekochtAm = LocalDate.of(2026, 9, 1);
    }

    /**
     * "richtiger Konstruktor
     */
    public Marmelade(String name, String obst, String besondereZutat, String koch, int zuckergehalt, LocalDate gekochtAm) {
        this.name = name;
        this.obst = obst;
        this.besondereZutat = besondereZutat;
        this.koch = koch;
        this.zuckergehalt = zuckergehalt;
        this.gekochtAm = gekochtAm;
    }

    public String getName() {
        return name;
    }

    public String getObst() {
        return obst;
    }

    public String getBesondereZutat() {
        return besondereZutat;
    }

    public String getKoch() {
        return koch;
    }

    public int getZuckergehalt() {
        return zuckergehalt;
    }

    public LocalDate getGekochtAm() {
        return gekochtAm;
    }

    /**
     * Falls der Name sich ändern soll
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Marmelade{" +
                "name='" + name + '\'' +
                ", obst='" + obst + '\'' +
                ", besondereZutat='" + besondereZutat + '\'' +
                ", koch='" + koch + '\'' +
                ", zuckergehalt=" + zuckergehalt +
                ", gekochtAm=" + gekochtAm +
                '}';
    }

    // ******************** überschreiben der equals-Methode ******************** //

//    @Override
//    public boolean equals(Object vergleichsObjekt) {
//        if (this == vergleichsObjekt) return true;
//        if (vergleichsObjekt == null || getClass() != vergleichsObjekt.getClass()) return false;
//        Marmelade vergleichsMarmelade = (Marmelade) vergleichsObjekt;
//        return zuckergehalt == vergleichsMarmelade.zuckergehalt
//                && Objects.equals(obst, vergleichsMarmelade.obst)
//                && Objects.equals(besondereZutat, vergleichsMarmelade.besondereZutat)
//                && Objects.equals(gekochtAm, vergleichsMarmelade.gekochtAm);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(obst, besondereZutat, zuckergehalt, gekochtAm);
//    }


//    @Override
//    public boolean equals(Object vergleichsObjekt) {
//        if (this == vergleichsObjekt) return true;
//        if (vergleichsObjekt == null || getClass() != vergleichsObjekt.getClass()) return false;
//
//        Marmelade vergleichsMarmelade = (Marmelade) vergleichsObjekt;
//        return zuckergehalt == vergleichsMarmelade.zuckergehalt
//                && Objects.equals(obst, vergleichsMarmelade.obst)
//                && Objects.equals(besondereZutat, vergleichsMarmelade.besondereZutat)
//                && Objects.equals(gekochtAm, vergleichsMarmelade.gekochtAm);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hashCode(obst);
//        result = 31 * result + Objects.hashCode(besondereZutat);
//        result = 31 * result + zuckergehalt;
//        result = 31 * result + Objects.hashCode(gekochtAm);
//        return result;
//    }


//    @Override
//    public boolean equals(Object vergleichsObjekt) {
//        if (this == vergleichsObjekt){
//            return true;
//        }
//        if (vergleichsObjekt == null){
//            return false;
//        }
//        if (this.getClass() != vergleichsObjekt.getClass()){
//            return false;
//        }
//        Marmelade vergleichsMarmelade = (Marmelade) vergleichsObjekt;
//        // Wenn die Obstsorten verschieden sind, soll false zurück gegeben werden (Strings equals!)
//        if(!this.obst.equals(vergleichsMarmelade.obst)){
//            return false;
//        }
//        if(!this.besondereZutat.equals(vergleichsMarmelade.besondereZutat)){
//            return false;
//        }
//        // Hier in diesem Beispiel spielt der Koch beim Vergleich keine Rolle
//        if (this.zuckergehalt != vergleichsMarmelade.zuckergehalt){
//            return false;
//        }
//        if (!this.gekochtAm.equals(vergleichsMarmelade.gekochtAm)){
//            return false;
//        }
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return zuckergehalt + obst.hashCode() + besondereZutat.hashCode() + gekochtAm.hashCode();
//    }

}
