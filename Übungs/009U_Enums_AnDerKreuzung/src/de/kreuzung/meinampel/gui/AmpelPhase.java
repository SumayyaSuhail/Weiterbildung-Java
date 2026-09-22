package de.kreuzung.meinampel.gui;

public enum AmpelPhase {
    ROT(3,true,false,false),
    ROT_GELB(2,true,true, false),
    GRUEN(4,false,false,true),
    GELB(1,false,true,false);

    /** Dauer der Anzeige */
    private int dauer;

    /** gibt an, ob das rote Licht leichtet*/
    private boolean rotAn;

    /** gibt an, ob das rote Licht leichtet*/
    private boolean gelbAn;

    /** gibt an, ob das rote Licht leichtet*/
    private boolean gruenAn;

    AmpelPhase(int dauer, boolean rotAn, boolean gelbAn, boolean gruenAn) {
        this.dauer = dauer;
        this.rotAn = rotAn;
        this.gelbAn = gelbAn;
        this.gruenAn = gruenAn;
    }

    public int getDauer() {
        return dauer;
    }

    public boolean isRotAn() {
        return rotAn;
    }

    public boolean isGelbAn() {
        return gelbAn;
    }

    public boolean isGruenAn() {
        return gruenAn;
    }

}

