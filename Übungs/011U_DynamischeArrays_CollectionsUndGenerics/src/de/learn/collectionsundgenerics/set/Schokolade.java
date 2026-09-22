package de.learn.collectionsundgenerics.set;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Schokolade enthält name der Schokolade, zucker gehalt und mindestens haltbar bis.
 * Hat auch übergeschriebenen methoden equals und hashCode.
 */
public class Schokolade {
    private String name;
    private int zuckerGehalt;
    private LocalDate MHB;

    public Schokolade(String name, int zuckerGehalt){
        this.name = name;
        this.zuckerGehalt = zuckerGehalt;
        MHB = LocalDate.now();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Schokolade that = (Schokolade) object;
        return zuckerGehalt == that.zuckerGehalt && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
