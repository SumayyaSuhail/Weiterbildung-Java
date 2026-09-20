package com.mymovie.multiinterfaces;

import com.mymovie.flughafen.Fahrer;
import com.mymovie.flughafen.FlieWaTuet;
import com.mymovie.flughafen.Flieger;
import com.mymovie.flughafen.Schwimmer;

/**
 * Eine Testklasse für DasSuperDing, in der alle Referenzen für ein DasSuperDing Objekt angibt.
 */
public class DasSuperDingTest {
    public static void main(String[] args) {
        //Referenzen:
        DasSuperDing dingReferenz = new DasSuperDing();
        Object objectReferenz = new DasSuperDing();
        Fahrer fahrerReferenz = new DasSuperDing();
        Flieger fliegerReferenz = new DasSuperDing();
        FlieWaTuet flieReferenz = new DasSuperDing();
        Schwimmer schwimmerReferenz = new DasSuperDing();

        //Casting:
        DasSuperDing cast1 = (DasSuperDing) objectReferenz;
        DasSuperDing cast2 = (DasSuperDing) fahrerReferenz;
        DasSuperDing cast3 = (DasSuperDing) fliegerReferenz;
        DasSuperDing cast4 = (DasSuperDing) flieReferenz;
        DasSuperDing cast5 = (DasSuperDing) schwimmerReferenz;

        Fahrer cast6 = (Fahrer) objectReferenz;
        Flieger cast7 = (Flieger) objectReferenz;
        FlieWaTuet cast8 = (FlieWaTuet) objectReferenz;
        Schwimmer cast9 = (Schwimmer) objectReferenz;

        Fahrer cast10 = (Fahrer) fliegerReferenz;
        Fahrer cast11 = flieReferenz;
        Fahrer cast12 = (Fahrer) schwimmerReferenz;

        Flieger cast13 = (Flieger) fahrerReferenz;
        Flieger cast14 = flieReferenz;
        Flieger cast15 = (Flieger) schwimmerReferenz;

        FlieWaTuet cast16 = (FlieWaTuet) fahrerReferenz;
        FlieWaTuet cast17 = (FlieWaTuet) fliegerReferenz;
        FlieWaTuet cast18 = (FlieWaTuet) schwimmerReferenz;

        Schwimmer cast19 = (Schwimmer) fahrerReferenz;
        Schwimmer cast20 = (Schwimmer) fliegerReferenz;
        Schwimmer cast21 = flieReferenz;
    }
}
