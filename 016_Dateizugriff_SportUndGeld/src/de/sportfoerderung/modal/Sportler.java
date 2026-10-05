package de.sportfoerderung.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <pre>
 *     Erstelle eine Klasse Sportler mit folgenden Attributen (halte es kurz – 2 bis 3 reichen):
 *     z.B. Name des Sportlers
 *     z.B. Sportart
 *     Ergänze außerdem ein Attribut, das mehrere Sponsoren speichern kann.
 *     Erstelle folgende Methoden, bzw. lasse sie von der IDE erstellen:
 *     Getter für alle Attribute
 *     Setter für Attribute, die sich ändern können
 *     Eine Methode addSponsor(Sponsor sponsor), die einen Sponsor
 *     hinzufügt – aber nicht doppelt
 *     toString()
 * </pre>
 */
public class Sportler implements Serializable {

    private String name;
    private String sportArt;
    private List<Sponsor> sponsoren = new ArrayList<>();

    public Sportler(String name, String sportArt){
        this.name = name;
        this.sportArt = sportArt;
    }
    public String getName() {
        return name;
    }

    public String getSportArt() {
        return sportArt;
    }

    public List<Sponsor> getSponsoren() {
        return sponsoren;
    }

    public void setSponsoren(List<Sponsor> sponsoren) {
        this.sponsoren = sponsoren;
    }

    public void addSponsor(Sponsor sponsor) {
        if (!sponsoren.contains(sponsor)){
            sponsoren.add(sponsor);
            sponsor.addSportler(this);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Sportler sportler = (Sportler) object;
        return Objects.equals(name, sportler.name) && Objects.equals(sportArt, sportler.sportArt) && Objects.equals(sponsoren, sportler.sponsoren);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sportArt, sponsoren);
    }

    @Override
    public String toString() {
        String info = "";
        info = info + "Sportler: " +
                "name='" + name + '\'' +
                ", sportArt='" + sportArt + '\'' +
                ", sponsoren=";
        for (Sponsor sponsor : sponsoren) {
            info += sponsor.getName();
        }
        return info;
    }
}
