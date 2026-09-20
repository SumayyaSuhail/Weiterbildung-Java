package cafe;

/**
 * <pre>
 *     Demonstriert die Verwendung von Schleifen.
 *
 *     Zwei Arten von Schleifen:
 *     1) Anzahl der Iteration ist bekannt: zählergesteuert Schlüsselwort for
 *     2) Anzahl der Iteration ist unbekannt: bedingungsgesteuerte Schleifen: Schlüsselwort while
 *          a) Bedingung: ein weiter Iteration soll durchgeführt werden
 *          b) Bedingung: Eine Situation bei der keine Iteration durchgeführt werden: while(true) ... break
 * </pre>
 */
public class Wiederholtes {
    /**
     * <pre>
     *     Ablauf des Programms: Kochen einer Möhrensuppe.
     *     Schleifenbeispiele: 5 Möhren werden geschält, zerkleinert und in den Topf gegeben
     * </pre>
     */
    public static void main(String[] args) {
        System.out.println("------ Heute abend gibt es Möhrensuppe, jetzt wird gekocht ------\n");
        System.out.println("Fülle einen Topf mit Wasser.");
        for(int i = 0; i < 5; i ++){
            int mohrenCounter = i + 1;
            System.out.println("Nimm die " + mohrenCounter + "te Möhre und schäle sie");
            System.out.println("Zerkleinere die Möhre.");
            System.out.println("Gib die Teile in einen Topf mit Wasser");
            System.out.println();
        }
//        System.out.println("Nach der Schleife hat mohrenCounter der Wert: " + mohrenCounter);
        //mohrenCounter ist nicht mehr im Scope: Eine Variable ist nur in dem Block gültig, in dem sie deklariert wurde.
        // i ist auch nicht mehr im Scope

        //fori + enter erstellt eine for Schleife
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingwer reiben und  in den Topf geben");
        }

        boolean zuWenigSalz = true;
        while(zuWenigSalz){
            System.out.println("Es wird ein wenig gesalzen und probiert");
            System.out.println("Fehlt noch Salz? Gib true oder false ein");
            zuWenigSalz = new java.util.Scanner(System.in).nextBoolean();
        }
        System.out.println("Feierabend ist da, jetzt wird gegessen, bis wir satt sind");
        while (true) {//Endlossschleife: Muss mit break beendet werden
            System.out.println("Ein Teller Suppe kommt auf den Tisch: Lass es dir schmecken");
            System.out.println("Bist du satt? Gib true oder false ein.");
            boolean satt = new java.util.Scanner(System.in).nextBoolean();
            if(satt){
                break; //break beendet die Schleife
            }
        }
        System.out.println("\nGut war's, jetzt kann endlich wieder Java programmiert werden.");

    }
}
