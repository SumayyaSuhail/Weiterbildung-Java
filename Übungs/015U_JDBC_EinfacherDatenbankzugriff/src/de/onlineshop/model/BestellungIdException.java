package de.onlineshop.model;

/**
 * Wird ausgelöst, wenn die bestellId eines schon gespeicherten Bestellung Objektes
 * geändert werden soll.
 */
public class BestellungIdException extends RuntimeException{
    public BestellungIdException() {
    }

    public BestellungIdException(String message) {
        super(message);
    }
}
