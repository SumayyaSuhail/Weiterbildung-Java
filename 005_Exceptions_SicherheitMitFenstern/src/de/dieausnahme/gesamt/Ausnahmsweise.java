package de.dieausnahme.gesamt;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 *     Demonstriert die Erstellung und Verwendung von Exceptions in Java.
 *
 *     Exception: Ein Problem der Semantik: ZurLaufzeit passieren Situation, die den normalen Ablauf behindern.
 *          Probleme in der Syntax werden von Compiler erkannt, wird während der CompileZeit erkannt.
 *
 *     In Java gibt es zwei Arten von Exceptions: RuntimeExceptions und CheckedExceptions.
 *          RuntimeExceptions: Klasse RuntimeException und alle Kinder: Fehler des Programmierers.
 *          CheckedException: Klassen die Exception aber nicht von RuntimeException erben ("alle anderen")
 *                 Checked Exceptions sind keine Fehler, sondern besondere Situationen, die Ausnahmen im
 *                 Ablauf darstellen.
 *          Checked Exceptions müssen gefangen werden: catch
 * </pre>
 */
public class Ausnahmsweise {

    /**
     * <pre>
     *      java.lang.ArrayIndexOutOfBoundsException: wenn ein ArrayIndex verwendet wird, der nicht im Array existiert.
     *      java.lang.NullPointerException: wenn ein null-Objekt beauftragt werden soll (.) etwas zu tun
     *      java.util.InputMismatchException: Wenn der Scanner einen int lesen soll, aber ein String geschrieben wird.
     * </pre>
     * @param args ignore
     */
    public static void main(String[] args) {
        System.out.println("Anfang\n");

        String[] sorten = new String[3];
        int index = 3;
        if (index < sorten.length && index >= 0) {
            System.out.println("Das ist meine Lieblingsorte: " + sorten[index]);
        } else {
            System.out.println("Ein falscher Arrayindex wurder versucht.");
        }
        if (sorten[0] != null) {
            System.out.println("Wichtig: " + sorten[0].toUpperCase());
        }
        Scanner leser = new Scanner(System.in);
//        System.out.println("Gib eine zahl zwischen 1 und 100 ein.");
//        if(leser.hasNextInt()) {
//            int gelesen = leser.nextInt();
//            eingabePruefen(gelesen);
//        }
        System.out.println("Zeit für eine Denkpause.");

        pauseMachen(5);
        try {
            fahrtInDenUrlaubVorbereiten();
        } catch (KissenImFensterException ausnahme) {
            System.out.println("Der Urlaub miss noch etwas warten.");
            System.out.println("Das Fenster ist offen!");
            ausnahme.printStackTrace(); // nur während der Entwicklungszeit
        }
        System.out.println("\nEnde");
    }

    public static void fahrtInDenUrlaubVorbereiten() throws KissenImFensterException {
        System.out.println("Koffer packen!");
        System.out.println("Zeitung abbestellen");
        try {
            zeitunAbbestellen();
        } catch (ZeitungNichtAbbestelltException ausnahme){
            System.out.println(ausnahme.getMessage());
            ausnahme.printStackTrace(); //während der Entwicklungszeit sehr praktisch
            System.out.println("Die Nachbar werden informiert: Die Zeitung muss aus dem Briefkasten genommen werden");
        }
        fensterSchliessen();
        System.out.println("Alles erledigt, der Urlaub kann starten. ");
    }

    public static void zeitunAbbestellen() throws ZeitungNichtAbbestelltException {
        System.out.println("Die Zeitung soll abbestellt werden.");
        String email = "Zeitung@wz.de";
        Random simulator = new Random();
        boolean emailFalsch = simulator.nextBoolean();
        if (emailFalsch){
            throw new ZeitungNichtAbbestelltException("Die email " + email + " erreicht die Zeitung nicht.");
        }
        System.out.println("Die Zeitung ist abbestellt.");
    }
    /**
     * Auslösen einer Checked Exception bewirkt:
     * "Handle or Declare Rule":
     * entweder ein try/catch oder
     * die Methode mit throws kennzeichnen: hier wird die Exception ausgelöst
     * Aufruf einer Methode, die mit throws ein Checked Exception angibt, muss jetzt
     * in einen try/catch Block gesetzt werden, oder an der Methodensignatur die Ausnahme weiter leiten
     * @throws KissenImFensterException wenn das Fenster blockiert ist
     */
    public static void fensterSchliessen() throws KissenImFensterException{
        System.out.println("Das smarte Fenster stellt fest, dass es sich schließen möchte...Aber");
        System.out.println("Leider liegt manchem ein Kissen im Fenster.");
        Random sensorSimulation = new Random();
        boolean kissenImFenster = sensorSimulation.nextBoolean();
        if(kissenImFenster){
            System.out.println("So kann das Fenster nicht geschlossen werden: Eine Ausnahme!");
            //TODO: Eine Exception soll den Ablaufverändern. throw
            throw new KissenImFensterException("Fenster ist blockiert, bitte sag der Nachbarin Bescheid");
        }
        System.out.println("Das Fenster ist zu.");
    }

    /**
     * Das Programm soll ein paar Sekunden schlafen... Damit wir Zeit zum Denken haben
     * @param sekunden solange wird das Programm schlafen
     */
    public static void pauseMachen(int sekunden){
        System.out.println("Du hast so recht, eine Pause ab und zu ist wichtig!");
        long millisekunden = sekunden * 1000L;
        try {
            Thread.sleep(millisekunden);
        } catch (InterruptedException ausnahme){
            System.out.println("Da ist was schief gelaufen");
        }
    }
    /**
     * Kontrolliert die Eingabe.
     * Falls der eingegebene Wert klein als 1 oder großer als 100:
     * Wird eine InputMismatchException ausgelöst
     * Auslösen einer Exception ist mit <b>throw</b> möglich.
     * das Auslösen mit throw unterbricht den normalen Programmablauf
     * @param eingegeben der Wert, der kontrolliert werden soll
     */
    public static void eingabePruefen(int eingegeben){
        if(eingegeben < 1 || eingegeben > 100) {
            throw new InputMismatchException("Der Wert war zu groß oder zu klein");
        }
    }
}
