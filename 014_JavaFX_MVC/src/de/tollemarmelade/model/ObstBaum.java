package de.tollemarmelade.model;

/**
 * <pre>
 *     Ein Obstbaum hat einen Namen und einen Wasserstand.
 *     Der Wasserstand beginnt bei 0 und kann höchstens 3 erreichen.
 * </pre>
 */
public enum ObstBaum {
    APFEL("ApfelBaum"),
    BIRNE("BirneBaum"),
    ZITRONE("ZitroneBaum");

    private final String anzeigeName;
    private int wasserStand = 0;

    ObstBaum(String anzeigeName){
        this.anzeigeName = anzeigeName;
    }

    /** Die Methode giessen() erhöht den Wasserstand um 1, sofern der Höchstwert noch nicht erreicht ist. */
    public void giessen(){
        if(wasserStand < 3) {
            wasserStand++;
        }
    }

    /**
     * Kucht wasserStand voll ist oder nicht
     * @return boolean
     */
    public boolean istVoll(){
        return (wasserStand >= 3);
    }

    public String getAnzeigeName() {
        return anzeigeName;
    }

    public int getWasserStand() {
        return wasserStand;
    }
}
