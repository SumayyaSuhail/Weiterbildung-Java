package de.altesschloss.derpassendeschluessel;

/**
 * besitzt einen passenden Schlüssel
 * kann geöffnet oder verschlossen sein
 */
public class Tuer {
    /** Name of the door */
    private String name;
    /** Original key of the door */
    private Schluessel originalSchluessel;
    private boolean verschlossen;

    public Tuer(String name, Schluessel originalSchluessel) {
        this.name = name;
        this.originalSchluessel = originalSchluessel;
        this.verschlossen = true;
    }

    /**
     * tries to open the door with the keys
     * if hashcode of the key matches to original key of the door, key is compared to original with .equals().
     * if keys matches, door is opened and true is returned.
     * @param probeSchluessel key compared to original
     * @return true if door is opened, false otherwise.
     */
    public boolean versuchen(Schluessel probeSchluessel) {
        System.out.println("\n---------- Magische Sicherung prüfen ----------");
        if (probeSchluessel.hashCode() != originalSchluessel.hashCode()) {
            System.out.println("*** Sicherung stimmt nicht! ***");
            return false;
        }

        System.out.println("\n---------- Sicherung stimmt! Prüfe den Schlüssel selbst ----------");
        if (probeSchluessel.equals(originalSchluessel)) {
            verschlossen = false;
            System.out.println("*** Passt! Die Tür " + name + " öffnet sich.\n");
            return true;
        }

        System.out.println("*** Schlüssel passt doch nicht. ***\n");
        return false;
    }

    public String getName(){
        return name;
    }

    public boolean isVerschlossen() {
        return verschlossen;
    }
}
