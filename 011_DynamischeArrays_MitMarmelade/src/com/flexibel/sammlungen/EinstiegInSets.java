package com.flexibel.sammlungen;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *     Ein Set ist eine Collection: Interface, das das Collection Interface erweitert.
 *
 *     Unterschied zu List:
 *     Ein Set enthält keine Duplikate: Duplikate: equals Vergleich ergibt true.
 *     Ein Set ist unsortiert. Keinen Index, kein add(index, element)
 *     Set: Rückgabe der add-Methode enthält wichtige Informationen
 * </pre>
 */
public class EinstiegInSets {
    public static void main(String[] args) {
        Set<String> eindeutigeNamen = new HashSet<>();
        boolean wurdeZugefuegt = eindeutigeNamen.add("Justus");
        System.out.println("Justus wurde zugefügt: " + wurdeZugefuegt);
        wurdeZugefuegt = eindeutigeNamen.add("Peter");
        System.out.println("Peter wurde zugefügt: " + wurdeZugefuegt);
        wurdeZugefuegt = eindeutigeNamen.add("Justus");
        System.out.println("Justus wurde zugefügt: " + wurdeZugefuegt);
        eindeutigeNamen.add("Bob");
        eindeutigeNamen.add("Tante Mathilda");
        eindeutigeNamen.add("Drago");
        eindeutigeNamen.forEach(name -> System.out.print(name + " - "));
        System.out.println();
    }
}
