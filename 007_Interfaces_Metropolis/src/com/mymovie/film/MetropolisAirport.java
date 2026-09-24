package com.mymovie.film;

import com.mymovie.flughafen.Flieger;
import com.mymovie.flughafen.Tower;
import com.mymovie.flughafen.Wasserpolizei;
import com.mymovie.lebewesen.*;
import com.mymovie.maschinen.Batwing;
import com.mymovie.maschinen.Flugzeug;
import com.mymovie.maschinen.NichtVollGetanktException;
import com.mymovie.maschinen.Schiff;

/**
 * <pre>
 *     Beschreibt den Ablauf des Films >Metropolis Airport<
 *
 *     copyright Alfa Movies
 * </pre>
 *
 * @author Sumayya
 */
public class MetropolisAirport {

    public static void main(String[] args) {
        System.out.println("Willkommen auf des Flughafen von Metropolis.");
        System.out.println("Hier ist einiges los, genieße die Show.\n");

        Tower tower = new Tower();

        Spatz jack = new Spatz();
        Flugzeug beluga = new Flugzeug();
        Superman S = Superman.getInstance(); //Superman.SUPERMAN;(enum) // new Superman(); (normal)
        Batwing batmansFlieger = new Batwing(S);

        try {
            System.out.println("Jack " + jack.getClass().getSimpleName() + " kommt vorbei und möchte landen.");
            tower.erteilenLandeerlaubnis(jack);
            System.out.println();

            System.out.println("Beluga, ein " + beluga.getClass().getSimpleName() + " kommt vorbei und möchte landen.");
            tower.erteilenLandeerlaubnis(beluga);
            System.out.println();

            System.out.println(S.getClass().getSimpleName() + " kommt vorbei um die Welt zu retten.");
            tower.erteilenLandeerlaubnis(S);
            System.out.println();
        } catch (TelefonzelleNichtAuffindbarException | NichtVollGetanktException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println("Batman ist da, er möchte mit seinem " + batmansFlieger.getClass().getSimpleName()
                    + " landen");
            tower.erteilenLandeerlaubnis(batmansFlieger);
            System.out.println();
        } catch (TelefonzelleNichtAuffindbarException | NichtVollGetanktException exception) {
            System.out.println(exception.getMessage());
        }


        System.out.println("ACHTUNG, GEFAHR: alles was fliegen kann muss Metropolis sofort verlassen!\n");
        Flieger[] allesWasFliegt = {jack, beluga, S, batmansFlieger};
        for (Flieger flieger : allesWasFliegt) {
            try {
                System.out.println(flieger.getClass().getSimpleName() + " startet und fliegt weg");
                flieger.starten();
                flieger.fliegen();
                System.out.println();
                if (flieger instanceof Vogel) {
                    Vogel cast = (Vogel) flieger;
                    System.out.println("Typ des Vogels: " + cast.getClass().getSimpleName());
                    cast.federkleidPutzen();
                    System.out.println();
                }
            } catch (FederkleidNichtPerfektException exception) {
                System.out.println(exception.getMessage());
            }
        }

        Ente duck = new Ente();
        Schiff ship = new Schiff();
        Wasserpolizei wasserpolizei = new Wasserpolizei();

        System.out.println("Duck " + duck.getClass().getSimpleName() + " kommt vorbei, möchte tauchen und schwimmen.");
        wasserpolizei.erteilenSchwimmenerlaubnis(duck);
        System.out.println();

        System.out.println("Ship " + ship.getClass().getSimpleName() + " kommt vorbei, möchte tauchen und schwimmen.");
        wasserpolizei.erteilenSchwimmenerlaubnis(ship);
        System.out.println();
    }
}
