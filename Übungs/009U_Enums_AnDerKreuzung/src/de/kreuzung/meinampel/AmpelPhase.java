package de.kreuzung.meinampel;

/**
 * Enum to store public static final attributes of AmpelPhase
 */
public enum AmpelPhase {
    ROT,
    ROT_GELB,
    GRUEN,
    GELB;

    /** Method to return the next phase based on current phase */
    public AmpelPhase naechstePhase(){
        switch (this){
            case ROT -> {
                return ROT_GELB;
            }
            case ROT_GELB -> {
                return GRUEN;
            }
            case GRUEN -> {
                return GELB;
            }
            case GELB -> {
                return ROT;
            }
            default -> {
                return null;
            }
        }
    }
}
