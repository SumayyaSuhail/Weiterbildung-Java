package de.tollemarmelade.ueber.marmelade;

import java.util.Arrays;

/**
 * <pre>
 *     Zu allen primitiv Datentypen gibt es Wrapperklassen.
 *
 *     Wrapper können zb genutzt werden, um Minimum und Maximum der Primitiven
 *     Zahlen Datentypen anzugeben.
 *
 *     Wrapper helfen bei der Konkatenation mit Strings:
 *     "Milchkaffee kostet " + preisMilchKaffee;
 *
 *     Manchmal brauch man Objekte und hat primitive Datentypen:
 *     Lösung Wrapper
 *             Integer wrapperZahl = Integer.valueOf(primitiveZahl); heißt: Boxing
 *             int wertDesWrappers = wrapperZahl.intValue(); heißt: Unboxing
 * </pre>
 */
public class AllerhandZuWrappern {
    public static void main(String[] args) {
        int primitiveZahl = 17;
        Integer wrapperZahl = Integer.valueOf(primitiveZahl);
        System.out.println("Das OBJEKT wrapperZahl hat Methoden: " + wrapperZahl.toString());
//        System.out.println("Der primitive int kann das nicht: " + primitiveZahl.toString());

        int wertDesWrappers = wrapperZahl.intValue();

        // Automatisches Boxing und Unboxing
        wrapperZahl = 23;
        wertDesWrappers = wrapperZahl;

        // Nützliche Wrapper Methoden
        System.out.println("Maximale int: " + Integer.MAX_VALUE);
        System.out.println("String zu int: " + Integer.parseInt("123"));
        System.out.println("toString: " + wrapperZahl.toString());

        Object eineZahl = 17; //Autoboxing in einen Integer Referenztyp Object geht immer
        System.out.println(eineZahl.getClass().getSimpleName());

        // gemischtes Array
        String sorte = "Latte Macchiato";
        double preis = 3.99;
        int bestellnummer = 101;

        Object[] sortenInfo = new Object[3];
        sortenInfo[0] = sorte;
        sortenInfo[1] = preis; //Autoboxing in Double
        sortenInfo[2] = bestellnummer; //Autoboxing  in int.

        //Vergleiche: Vorsicht Falle
        int p1 = 1000;
        int p2 = 1000;
        System.out.println("Sind p1 und p2 gleich? " + (p1 == p2));

        Integer w1 = 127; //Grenze ist 127
        Integer w2 = 127;
        System.out.println("Sind w1 und w2 gleich? " + (w1 == w2));

    }
}
