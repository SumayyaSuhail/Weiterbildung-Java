package de.tollemarmelade.ueber.marmelade;

/**
 * Wird ausgelöst, wenn beim Erstellen eines Datums der Wert des Monats kleiner 1 oder größer 12
 */
public class KeinGueltigesDatumException extends RuntimeException {
    public KeinGueltigesDatumException() {
    }

    public KeinGueltigesDatumException(String message) {
        super(message);
    }
}
