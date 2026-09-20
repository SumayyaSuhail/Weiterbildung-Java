package com.mymovie.multiinterfaces;

import com.mymovie.flughafen.FlieWaTuet;

public class DasSuperDing implements FlieWaTuet {
    @Override
    public void himbeerSaftTanken() {
        System.out.println("himbeerSaftTanken");
    }

    @Override
    public void landen() {
        System.out.println("landen");
    }

    @Override
    public void fliegen() {
        System.out.println("fliegen");
    }

    @Override
    public void starten() {
        System.out.println("starten");
    }

    @Override
    public void schwimmen() {
        System.out.println("schwimmen");
    }

    @Override
    public boolean kannTauchen() {
        return false;
    }

    @Override
    public void fahren() {
        System.out.println("fahren");
    }
}
