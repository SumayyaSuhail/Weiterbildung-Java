package de.geldautomat.Exceptions;

public class KeineKontoDeckungException extends Exception{
    public KeineKontoDeckungException() {
    }

    public KeineKontoDeckungException(String message) {
        super(message);
    }
}
