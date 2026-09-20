package de.geldautomat.Exceptions;

public class FalscherBetragException extends Exception{
    public FalscherBetragException() {
    }

    public FalscherBetragException(String message) {
        super(message);
    }
}
