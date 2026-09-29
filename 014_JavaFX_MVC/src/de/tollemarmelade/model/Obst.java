package de.tollemarmelade.model;

/**
 * <pre>
 *     In dem Menu Obst gibt MenuItems zu den einzelnen Obstorten.
 * </pre>
 */
public enum Obst {
    APFEL("Apfel"),
    BIRNE("Birne"),
    ZITRONE("Zitrone");

    private String anzeigenName;

    Obst(String anzeigenName) {
        this.anzeigenName = anzeigenName;
    }

    public String getAnzeigenName() {
        return anzeigenName;
    }
}
