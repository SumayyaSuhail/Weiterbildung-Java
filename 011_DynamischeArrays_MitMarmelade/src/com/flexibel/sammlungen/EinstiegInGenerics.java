package com.flexibel.sammlungen;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <pre>
 *     Aktuell können Collections alle Arten von Objekte enthalten.
 *     Das soll hier geändert werden.
 *
 *     Wunsch: Sammlungen die nur einen bestimmten Datentyp enthalten(zb Strings, Marmelade...)
 * </pre>
 */
public class EinstiegInGenerics {
    public static void main(String[] args) {
        Collection nurTexte = new StringListe();
        Object text = "Info91";
        nurTexte.add(text);
        nurTexte.add(new Marmelade());
        nurTexte.forEach(element -> System.out.println(element.getClass().getSimpleName()));

        System.out.println("-".repeat(50));

        Collection nurMarmelade = new MarmeladeListe();
        Marmelade ersteMarmelade = new Marmelade();
        nurMarmelade.add(ersteMarmelade);
        nurMarmelade.add(text);
        nurMarmelade.forEach(element -> System.out.println(element.getClass().getSimpleName() + ": " + element));

        System.out.println("-".repeat(50));

        Collection<Marmelade> marmelades = new ArrayList<>();
        marmelades.add(new Marmelade());
//        marmelades.add("Lecker Marmelade"); Compiler sagt nein!
        for (Marmelade element : marmelades) {
            System.out.println(element.getKoch());
        }

        Collection<Integer> zahlen = new ArrayList<>();
        zahlen.add(1);
        zahlen.add(2);
        zahlen.forEach(element -> System.out.println(element));
    }
}
