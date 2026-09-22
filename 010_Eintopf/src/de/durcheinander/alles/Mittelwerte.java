package de.durcheinander.alles;

/**
 * <pre>
 *     Demonstriert den ... Operator: varargs.
 * </pre>
 */
public class Mittelwerte {
    public static void main(String[] args) {
        System.out.println("Mittelwert von 3 und 5 = " + mittelwertBerechnen(3,5));
        System.out.println("Mittelwert von 2, 19 und 44 = " + mittelwertBerechnen(2,19,44));
        System.out.println("Mittelwert von 4, 17, 31 und -104 = " + mittelwertBerechnen(4,17,31,-104));
    }

    public static int mittelwertBerechnen(int... zahlen){
//        System.out.println(zahlen.getClass().getSimpleName()); // int... ist auch ein array
        int summe = 0;
        for (int i : zahlen){
            summe += i;
        }
        int mittelwert = summe / zahlen.length;
        return mittelwert;
    }

//    public static int mittelwerteBerechnen(int[] zahlen){
//        int summe = 0;
//        for (int i : zahlen) {
//            summe += i;
//        }
//        int mittelwert = summe / zahlen.length;
//        return mittelwert;
//    }

//    public static int mittelwertBerechnen(int zahl1, int zahl2, int zahl3, int zahl4) {
//        int summe = zahl1 + zahl2 + zahl3 + zahl4;
//        int mittelwert = summe / 4;
//        return mittelwert;
//    }
//
//    public static int mittelwertBerechnen(int zahl1, int zahl2, int zahl3) {
//        int summe = zahl1 + zahl2 + zahl3;
//        int mittelwert = summe / 3;
//        return mittelwert;
//    }
//
//    public static int mittelwertBerechnen(int zahl1, int zahl2) {
//        int summe = zahl1 + zahl2;
//        int mittelwert = summe / 2;
//        return mittelwert;
//    }
}
