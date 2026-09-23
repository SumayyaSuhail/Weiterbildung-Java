package com.flexibel.sammlungen;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <pre>
 *     Demonstriert dynamische Sammkungen in Java.
 *
 *     Als Referenztyp wird in dem ersten Beispiel das Collection Interface verwendet.
 *     Als Objekttyp wird im ersten Schritt Klasse ArrayList verwendet.
 *     Das Collection Framework ist im package java.util und Unterpackages.
 * </pre>
 */
public class EinstiegInCollections {
    public static void main(String[] args) {
        Collection getraenke = new ArrayList(); // String [] getraenke = new String [3];
        System.out.println("Wie viele Getränke sind schon in der Liste? " + getraenke.size()); //getraenke.length: 3 liefern
        getraenke.add("Kaffee");
        System.out.println("Wie viele Getränke sind schon in der Liste? " + getraenke.size());
        getraenke.add("Wasser");
        getraenke.add("Saft");
        getraenke.add("Kaffee");
        getraenke.add("Limo");

        for (Object element : getraenke) {
            System.out.print(element + " ");
        }
        System.out.println();

        Marmelade ersteMarmelade = new Marmelade();
        Marmelade zweiteMarmelade = new Marmelade();
        getraenke.add(ersteMarmelade);
        getraenke.add(LocalTime.now());
        getraenke.add(42);
        getraenke.add(zweiteMarmelade);

        for (Object element : getraenke) {
            System.out.println(element);
        }
        System.out.println();

        getraenke.remove(zweiteMarmelade);
        System.out.println("-".repeat(50));
        for (Object element : getraenke) {
            System.out.println(element);
        }
        System.out.println("=".repeat(70));
        getraenke.forEach(element -> System.out.println(element));
    }
}
