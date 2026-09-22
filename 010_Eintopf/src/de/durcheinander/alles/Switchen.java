package de.durcheinander.alles;

import java.time.DayOfWeek;
import java.util.Random;

/**
 * <pre>
 *     switch-case ermöglicht Methfachverzeigung in Java.
 *     Geswitcht werden kann nur über: int (byte, short, char) - String-enum-Elemente
 *     case: ein konstanter Wer zb ROT, 15, "Montag"
 * </pre>
 */
public class Switchen {
    public static void main(String[] args) {
        Random wuerfel = new Random();
        int zufallsZahl = wuerfel.nextInt(1, 7); //1,2,3,4,5,6
        System.out.println("Gewürfelt wurde die " + zufallsZahl + ".\n");
        switch (zufallsZahl) {
            case 1:
                System.out.println("So ein Pech");
                System.out.println("So kommst du gar nicht weiter");
                break;
            case 2:
                System.out.println("Gar nicht so schlecht, aber es könnte besser sein");
            case 3:
                System.out.println("Gerade mal so mittelmäßig;");
                break;
            case 4:
            case 5:
                System.out.println("Obere Hälfe: du hattest Glück!");
                break;
            default:
                System.out.println("Kommt, wenn kein andere Zahl gepasst hat");
                break;
        }
        System.out.println("\n" + "-".repeat(50) + "\n");
        switch (zufallsZahl) {
            case 3 -> System.out.println("--- 3 ---");
            default -> System.out.println("--- Eine andere Zahl ---");
            case 1, 2 -> System.out.println("--- Eine kleine Zahl ---");
        }
        System.out.println("\n--- Switchen mit Strings ---\n");
        String[] tiere = {"Hund", "Katze", "Maus", "Elefant", "Spinne"};
        String lieblingsTier = tiere[wuerfel.nextInt(tiere.length)];
        switch (lieblingsTier) {
            case "Hund" -> System.out.println("Das Lieblingstier macht " + "WAU WAU");
            case "Katze" -> System.out.println("Das Lieblingstier macht " + "MIAU");
            case "Maus" -> System.out.println("Das Lieblingstier macht " + "Fii");
            default -> System.out.println("Das lieblingstier macht " + "nichts, der Ton wurde noch nicht aufgenommen.");
        }
        System.out.println("Unser Lieblingstier macht " +
                switch (lieblingsTier) {
                    case "Hund" -> "Wau Wau";
                    case "Katze" -> "Miau";
                    case "Maus" -> "Fii";
                    default -> "nichts, noch nicht aufgenommen";
                }
        );

        DayOfWeek wochenTag = DayOfWeek.values()[wuerfel.nextInt(DayOfWeek.values().length)];
        System.out.println("Der Best Tag um " +
                switch (wochenTag) {
                    case MONDAY -> "Java";
                    case TUESDAY -> "PHP";
                    case WEDNESDAY -> "C#";
                    case THURSDAY -> "JavaScript";
                    case FRIDAY -> "R";
                    case SATURDAY, SUNDAY -> "nicht";
                }
                + " zu programmieren");
    }

    public static String switchenMitReturn(int ausgewuerfelt){
        int rest = ausgewuerfelt % 4;
        return switch (rest){
            case 0 -> "Null";
            case 1 -> "Eins";
            case 2 -> "Zwei";
            case 3 -> "Drei";
            default -> "Sollte nicht passieren";
        };
    }
}
