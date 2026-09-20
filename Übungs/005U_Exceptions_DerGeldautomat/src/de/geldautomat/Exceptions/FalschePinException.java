package de.geldautomat.Exceptions;

public class FalschePinException extends Exception{
    public FalschePinException() {
    }

    public FalschePinException(String message) {
        super(message);
    }
}
