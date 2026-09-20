package de.altesschloss.derpassendeschluessel;

import java.util.Objects;

/**
 * besitzt Zacken und Kerben
 */
public class SchluesselBart{

    private int zacken;
    private int kerben;

    public SchluesselBart(int zacken, int kerben) {
        this.zacken = zacken;
        this.kerben = kerben;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchluesselBart that = (SchluesselBart) o;
        return zacken == that.zacken && kerben == that.kerben;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zacken, kerben);
    }

    @Override
    public String toString() {
        return "Zacken-" + zacken + ", Kerben-" + kerben;
    }
}
