package cafe;

/**
 * <pre>
 *     Demonstriert die verwendung von primitiven Datentypen in Java.
 *
 *     https://openbook.rheinwerk-verlag.de/javainsel/02_003.html#u2.3
 * </pre>
 */
public class Einfaches {

    /**
     * <pre>
     *     Startet und organisiert den Ablauf des Programms
     * </pre>
     */
    public static void main(String[] args) {
        System.out.println("---------- ganzzahlige Datentypen ----------");
        byte microGanzzahl = 122;
        System.out.println("Der Wert der Microzahl ist " + microGanzzahl);
        microGanzzahl = 123;
//        microGanzzahl = 128;
        System.out.println("Der kleinste byte-Wert: " + Byte.MIN_VALUE);
        System.out.println("Der größte byte-Wert: " + Byte.MAX_VALUE);

        short kleineGanzzahl = 1000;
        System.out.println("Der kleinste short-Wert: " + Short.MIN_VALUE);
        System.out.println("Der größte short-Wert: " + Short.MAX_VALUE);

        int ganzzahl = 500_000; // _ Unterstrich zur Lesbarkeit der Zahlen im Code. Ändern den Wert nicht!
        System.out.println("Ganzzahl: " + ganzzahl);
        System.out.println("Der kleinste int-Wert: " + Integer.MIN_VALUE);
        System.out.println("Der größte int-Wert: " + Integer.MAX_VALUE);

        ganzzahl = 2_147_483_647;
        int merkwuerdig = (ganzzahl + 1) + (ganzzahl + 1);
        System.out.println("Merkwuerdig hat den Wert: " + merkwuerdig);
        merkwuerdig = 17 / 4;
        // 17 / 4 : Integerdivision
        int rest = 17 % 4;
        System.out.println("17 / 4 = " + merkwuerdig + " Rest " + rest);

        long grosseGanzzahl = 2_147_483_648L;
        // Im Code: Ziffern werden als Integer interpretiert. Long Wer müssen explizit mit einem L/l
        // gekennzeichnet werden
        System.out.println("Kleinster long-Wert: " + Long.MIN_VALUE);
        System.out.println("Größter long-Wert: " + Long.MAX_VALUE);
        ganzzahl = 17;
        ganzzahl = ganzzahl + 1;
        System.out.println("Ganzzahl: " + ganzzahl);
        ganzzahl++; //Abkürzung für ganzzahl = ganzzahl + 1;
        System.out.println("Ganzzahl: " + ganzzahl);
        System.out.println("Ganzzahl geändert: " + ganzzahl++); //DAS IST KEIN CLEAN CODE!
        System.out.println(ganzzahl);
        ganzzahl = ganzzahl++;//DAS IST KEIN CLEAN CODE!

        System.out.println("\n---------- Komma Zahlen ----------");
        double kommazahl = 3.14;
        float kleineKommazahl = 3.14f;//Ziffern + . -> double. float im Code: F/f

        kommazahl = 3;//Automatisches Konvertieren int -> double, byte -> long...
        ganzzahl = (int)3.14; //Hier ist Casting notwendig: (int): Nachkommastellen werden abgeschnitten

        kommazahl = 17.0 / 4;
        System.out.println("17 / 4 = " + kommazahl);

        double zaehler = 17;
        double nenner = 4;
        double bruch = zaehler / nenner;
        System.out.println(zaehler + " / " + nenner + " = " + bruch);

        System.out.println("---------- Buchstaben: char ----------");
        char buchstabe = 'A';
        char neuezeile = '\n';

        int buchstabeAlsZahl = buchstabe;
        System.out.println(buchstabe + "hat den Wert " + buchstabeAlsZahl);
        buchstabe++;
        System.out.println("Jetzt ist der Buchstabe " + buchstabe);

        buchstabe = (char)buchstabeAlsZahl; // Automatisches Konvertieren nicht möglich, aber Casting geht

        buchstabe = (char) (buchstabe + 100);

        System.out.println("---------- boolean ----------");
        boolean wertEinerAussage = true;
        wertEinerAussage = false;
        wertEinerAussage = ganzzahl < 17;
//        wertEinerAussage = 0;
//        wertEinerAussage = (boolean) 0;
        // kein Konvertieren oder Casting zwischen Zahlendatentypen und boolean
//        if(ganzzahl= 7){
//
//        }
        // in Java nicht möglich.
    }
}
