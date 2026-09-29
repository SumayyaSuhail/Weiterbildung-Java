package de.tollemarmelade.model;

import java.util.List;

/**
 * zu allen Obstsorten gibt es passende besondere Zutaten.
 * Der user soll sich nach Obstauswahl ein besondere Zutat heraus suchen können
 */
public class BesondereZutaten {

    /** List.of() erstellt eine List-Objekt, das nich veränderbar ist */
    public static List<String> FUER_APFEL = List.of("Whisky", "Marshmallows", "Zimt");

    public static final List<String> FUER_BIRNE = List.of("Vanille", "Preiselbeeren", "Rosmarin");

    public static final List<String> FUER_ZITRONE = List.of("Petersilie", "Rum", "Lavendel");

    public static List<String> zutatenFuer (Obst obst) {
        return switch (obst) {
            case APFEL -> FUER_APFEL;
            case BIRNE -> FUER_BIRNE;
            case ZITRONE -> FUER_ZITRONE;
        };
    }
}
