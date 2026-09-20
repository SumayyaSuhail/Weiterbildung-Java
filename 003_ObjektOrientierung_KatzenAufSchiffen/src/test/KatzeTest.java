package test;

import de.katzen.schiff.Katze;
//Suchen von Katze, ersetzen durch de.katzen.schiff.Katze
/**
 * <pre>
 *     Die Klasse Katze hat keine main-Methode!
 *     Die Katze ist nicht zuständig für den Ablauf des Programms!
 *
 *     hier sollen Katze Objekte erstellt werden. DIe Objekte sollen gefüttert werden,
 *     sie sollen zum Erkunden angeregt werden und die Katze sollen den Auftrag bekommen,
 *     Mäuse zu fangen: Ablauf des Test-Programms -> main-Methode
 *
 *     Zuständigkeit der Klasse Katze: Sie liefert ein Template/Vorlage für Katze-Objekte und
 *     Anweisungen wie diese Objekte erstellt werden
 *                                     Sie liefert einen Datentyp für Referenzen mit denen
 *                                     Katze-Objekte angesprochen werden können
 *
 *     de.katzen.schiff.Katze: voll qualifierter Name: Damit unterscheidet sich diese Katze
 *     allen anderen Katze Klasse
 * </pre>
 */
public class KatzeTest {
    /** wie immer ....*/
    public static void main(String[] args) {
        de.katzen.schiff.Katze kitty = new de.katzen.schiff.Katze();
        Katze jones = new Katze();
        //        jones.name = "Jones"; nicht möglich: name ist private
        jones.setName("Jones");
        jones.setAlter(5);

        System.out.println("\n----- Jones wird gefüttert -----!");
        jones.gefuettertWerden();
        jones.gefuettertWerden();

        System.out.println("\nist Jones hungrig? wie alt ist Jones?");
        System.out.println(jones.getName() + " ist " + jones.getAlter() + " Jahre alt.");
        if (jones.isHungrig()){
            System.out.println(jones.getName() + " hat Hunger");
        } else {
            System.out.println(jones.getName() + " ist satt");
        }

        System.out.println("\nJones soll Mäuse jagen.");
        jones.mausFangen();

        System.out.println("\nJones soll sich umsehen.");
        jones.erkunden();
    }
}
