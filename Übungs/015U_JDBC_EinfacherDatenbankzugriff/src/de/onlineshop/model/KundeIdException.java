package de.onlineshop.model;

/**
 * Wird ausgelöst, wenn die kundeId eines schon gespeicherten Kunde Objektes
 * geändert werden soll.
 */
public class KundeIdException extends RuntimeException{
    public KundeIdException() {
    }

    public KundeIdException(String message) {
        super(message);
    }
}
