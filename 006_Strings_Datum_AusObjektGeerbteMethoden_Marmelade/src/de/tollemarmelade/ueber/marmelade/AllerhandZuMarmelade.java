package de.tollemarmelade.ueber.marmelade;

import java.time.LocalDate;

/**
 * <pre>
 *     Erstellt Marmelade Objekte, vergleicht Marmelade Objekte und ändert Marmelade Objekte
 *     Vergleich mit == Operator: Variableninhalte werden verglichen: Adressen der Objekte
 * </pre>
 */
public class AllerhandZuMarmelade {
    public static void main(String[] args) {
        Marmelade ersteMarmelade = new Marmelade();
        Marmelade zweiteMarmelade = new Marmelade();
        Marmelade zusatzMarmelade = ersteMarmelade;

        System.out.println(ersteMarmelade);
        System.out.println(zweiteMarmelade);
        System.out.println(zusatzMarmelade);

        boolean vergleich = ersteMarmelade == zweiteMarmelade;
        System.out.println("ersteMarmelade == zweiteMarmelade: " + vergleich);

        vergleich = ersteMarmelade == zusatzMarmelade;
        System.out.println("ersteMarmelade == zusatzMarmelade: " + vergleich);

        zweiteMarmelade.setName("Vitaminbooster");
        System.out.println(ersteMarmelade);

        zusatzMarmelade.setName("Vitaminbooster");
        System.out.println(ersteMarmelade);
        //Mit beiden Variablen wird das selbe Objekt angesprochen

        System.out.println("\n ---------- equals Vergleiche ---------- \n");
        Marmelade fuerDenVergleich1 = new Marmelade();
        Marmelade fuerDenVergleich2 = new Marmelade();
        System.out.println(fuerDenVergleich1);
        System.out.println(fuerDenVergleich2);
        vergleich = fuerDenVergleich1.equals(fuerDenVergleich2);
        System.out.println("fuerDenVergleich1.equals(fuerDenVergleich2): " + vergleich); //Wunsch: true
        System.out.println(ersteMarmelade.equals(zusatzMarmelade));

        System.out.println();
        Marmelade neu1 = new Marmelade("Lecker Schmecker", "Birne",
                "Basilikum", "Klaus", 50, LocalDate.of(2026,10,1));
        Marmelade neu2 = new Marmelade("Nur für Grünfans", "Birne",
                "Basilikum", "Klaus", 50, LocalDate.of(2026,10,1));
        Marmelade neu3 = new Marmelade("Gelbes Zeug", "Marillen",
                "Basilikum", "Klaus", 50, LocalDate.of(2025,10,1));
        vergleich = neu1.equals(neu2);
        System.out.println("neu1.equals(neu2): " + vergleich);

        vergleich = neu1.equals(neu3);
        System.out.println("neu1.equals(neu3): " + vergleich);

        System.out.println("Neu1: " + neu1.hashCode());
        System.out.println("Neu2: " + neu2.hashCode());
        System.out.println();
        System.out.println("Neu3: " + neu3.hashCode());
        System.out.println("erste Marmelade: " + ersteMarmelade.hashCode());

    }
}
