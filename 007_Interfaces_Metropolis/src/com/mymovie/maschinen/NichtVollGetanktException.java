package com.mymovie.maschinen;

public class NichtVollGetanktException extends Exception{
    public NichtVollGetanktException() {
    }

    public NichtVollGetanktException(String message) {
        super(message);
    }
}
