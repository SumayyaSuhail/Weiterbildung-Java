package de.tollemarmelade.model;

/**
 * Wird ausgelöst, wenn die marmeladeId eines schon gespeicherten Marmelade Objektes
 * geändert werden soll.
 */
public class MarmeladeIdException extends RuntimeException{
    public MarmeladeIdException() {
    }

    public MarmeladeIdException(String message) {
        super(message);
    }
}
