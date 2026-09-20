package de.dieausnahme.gesamt;

/**
 * <pre>
 *     Wird ausgelöst, wenn des Sensor des Fensters eine Blockade bemerkt, wenn das Fenster
 *     geschlossen werden soll.
 *     extends Exception: Also eine Checked Exception
 * </pre>
 */
public class KissenImFensterException extends Exception{
    public KissenImFensterException() {
    }

    public KissenImFensterException(String message) {
        super(message);
    }
}
