package de.atman.mit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 *     Demonstriert die Verwendung von Enums.
 *
 *     Methoden aus enums werden gezeigt.
 *     Enum:
 *     erstellt einen Namen für jedes enum Element: Aus dem Bezeichner.
 *     überschreibt die toString Methode: der Name (und damit der Bezeichner des Elements) wird zurückgegeben.
 *
 *     values(): static Methode, die ein Array mit allen enum Elementen zurückgibt, in der Reihenfolge in der
 *              sie in enum angelegt wurden.
 *     ordinal(): gibt den Index eines Enum Elements im Enum Array an
 *     valueOf(): Factory, die aus einem String das gleichnamig enum Element erstellt.
 * </pre>
 */
public class BlickAufGeistImSpiel {
    public static void main(String[] args) {
        System.out.println(GeistImSpiel.INKY + " ist " + GeistImSpiel.INKY.getFarbe());
        GeistImSpiel[] dieGeister = GeistImSpiel.values();
        for (GeistImSpiel geistImSpiel : dieGeister) {
            System.out.print(geistImSpiel + " ");
        }
        System.out.println();

        int inkyIndex = GeistImSpiel.INKY.ordinal();
        System.out.println("Der Index von " + GeistImSpiel.INKY + " ist " + inkyIndex);
        System.out.println("\nWelchen Geist möchtest du gerne losschicken?");
        System.out.println("Blinky, Pinky, Inky oder Clyde?");

        Scanner leser = new Scanner(System.in);
        String eingegebenerName = leser.nextLine();
        GeistImSpiel wunschGeist = GeistImSpiel.valueOf(eingegebenerName.toUpperCase());
        System.out.println(wunschGeist + " macht sich auf die Jagd mit " + wunschGeist.getGeschwindigkeit() +
                " Felder pro Sekunde.");

        switch (wunschGeist){
            case BLINKY -> System.out.println("Blinky verfolgt Pac-Man ohne Umwege");
            case PINKY -> System.out.println("Pinky versucht, Pac-Man den Weg anzuschneiden");
            case INKY -> System.out.println("Inky nähert sich auf einem überraschenden Weg");
            case CLYDE -> System.out.println("Clyde entscheidet sich spontan, Abstandhalten oder Nachlaufen");
        }

        switch (wunschGeist){
            case BLINKY, INKY -> {
                System.out.println("Ja");
                System.out.println("Oder auch nicht");
            }
            default -> {
                System.out.println("Auch wenn kein passender Case gefunden wurde:");
                System.out.println("Default ist die Alternative");
            }
        }
        switch (wunschGeist){
            case BLINKY:
                System.out.println("Hier ist BLINKY");
                break;
            case PINKY:
                System.out.println("Hier ist PINKY");
                break;
            default:
                System.out.println("Keine Ahnung");
        }

        System.out.println("\n" + "#".repeat(50) + "\n");
        boolean erfolgreich = wunschGeist.pacManFangen();
        if(erfolgreich){
            System.out.println(wunschGeist + " hat Pac-Man gefangen.");
        } else {
            System.out.println("Pac-Man konnte " + wunschGeist + " entkommen");
        }

        System.out.println(Arrays.toString(GeistImSpiel.values()));
    }
}
