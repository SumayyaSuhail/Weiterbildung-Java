package test;

import de.ogergames.figuren.Charakter;
import de.ogergames.figuren.Held;

import java.util.Random;

/**
 * <pre>
 *     Demonstriert den Polymorphismus in Java: Objektadressen können in verschiedenartigen Referenzen
 *     gespeichert werden.
 * </pre>
 */
public class PolymorphismusBeiHelden {

    /**
     * Der Ablauf des Programms
     * Held heldRef1 = new Held("User1"); Referenztyp = Objekttyp
     * Held heldRef2 = new Charakter(); nicht möglich: Adresse eines Elternklassen-Objekts kann nicht
     *      in einer Kindklasse Referenz/Variable gespeichert werden: Compiler-Fehler
     * Charakter charRef2 = new Held("User2"); ist möglich: Die Adresse eines Kindklassen-Objekts kann
     *      in einer Elternklassen Referenz/Variable gespeichert werden: IS-A-Beziehung "Polymorphismus"
     * charRefX.erstellenStatusInformation() ruft die zum <b>Objekt</b> passende Mathode auf.
     * "Objekte handeln, nicht Referenzen", alle Objekt Methoden werden in Java <i>virtuell</i> aufgerufen:
     *          Immer die Methode des Objekts!
     *
     * charRef2.ausruhen(); ist zur Compilezeit nicht möglich!
     *  Wunsch: das Objekt, dessen Adresse in charRef2 steht, soll sich ausruhen
     *      Held heldHelfer1 = (Held) charRef2; Erlaubt dem Compiler die Adresse aus der Variablen vom
     *      Typ Charakter in eine Variable vom Typ Held zu speichern: (Held) : Casting
     * @param args wird hier ignoriert
     */
    public static void main(String[] args) {
        Held heldRef1 = new Held("User1");
        Charakter charRef1 = new Charakter();

//        Held heldRef2 = new Charakter();
        Charakter charRef2 = new Held("User2");
        System.out.println("charRef1:\n" + charRef1.erstellenStatusInformation());
        System.out.println("charRef2:\n" + charRef2.erstellenStatusInformation());
        System.out.println("\n--------------------------------------------------\n");
        charRef1.verwunden(charRef2);
        heldRef1.verwunden(charRef1);
        heldRef1.verwunden(charRef2);
        heldRef1.verwunden(heldRef1);
        charRef2.verwunden(heldRef1);
        // ...
        heldRef1.ausruhen();
        // charRef2.ausruhen();
        // charRef1.ausruhen();
        Held heldHelfer1 = (Held) charRef2;
        heldHelfer1.ausruhen();
        heldHelfer1.ausruhen();
        heldHelfer1.ausruhen();
        System.out.println(charRef2.erstellenStatusInformation());
        System.out.println("\n--------------- nun mit einem zufälligen Objekt ---------------- \n");
        Charakter zufaelliegesObjekt = zufaelligBegegnen();
        heldRef1.verwunden(zufaelliegesObjekt);
        //Wunsch: wenn das zufälligen Objekt ein Held ist, möchte ich wissen wie der User heißt.
        if (zufaelliegesObjekt instanceof Held) {
            Held heldHelfer2 = (Held) zufaelliegesObjekt;
            System.out.println(heldHelfer2.getUsername());
        } else {
            System.out.println("Mal wieder eine Begegnung mir einem namenlosen Monster");
        }
    }

    /**
     * Im Spiel wird der Held später zufällige Begegnungen haben.
     * zB Charakter-Objekt, Held-Objekt, später auch ein Oger Objekt, ein Heiler Objekt...
     */
    public static Charakter zufaelligBegegnen(){
        Charakter eins = new Charakter();
        Charakter zwei = new Held("Zwei");
        Held drei = new Held("Drei");
        Random wuerfel = new Random();
        int auswahl = wuerfel.nextInt(3); // möglich 0,1,2
        if(auswahl == 0){
            return eins;
        } else if(auswahl == 1){
            return zwei;
        } else if(auswahl == 2){
            return drei;
        } else {
            return null;
        }
    }
}
