package de.nacht.museum;

/**
 * <pre>
 *     Objektbeschreibung
 *     Ein Pac-Man-Automat der Pac heißt.
 *     Pac ist 46 Jahre alt.
 *     Pac hat die Farbe Gelb.
 *
 *     Der Pac-Man-Automat spielt sich selbst.
 * </pre>
 */
public class PacManAutomat {
    // region ******************** Attribute/Eigenschaften/Felder ******************** //
    private String name;
    private int alter;
    private String farbe;

    // endregion

    // region ******************** Methoden/Fähigkeiten/Jobs ******************** //

    public void selbstSpielen(){
        System.out.println(name + " spielt sich selbst.");
    }

    //endregion

    // region ******************** getter/setter ******************** //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
