package de.dieausnahme.gesamt;

/** .... */
public class ZeitungNichtAbbestelltException extends Exception{
    public ZeitungNichtAbbestelltException() {
    }

    public ZeitungNichtAbbestelltException(String message) {
        super(message);
    }
}
