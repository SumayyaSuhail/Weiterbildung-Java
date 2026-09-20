package de.uebung.dielieblingsgerichte;

/**
 * <pre>
 *     1. Erstelle ein Array, das alle Wochentage enthält
 *     2. Erstelle ein Array deiner Lieblingsgerichte (weniger oder mehr als 7 Lieblingsgerichte)
 *     3. Ausgabe: Erstelle eine Übersicht, was in Dezember gegessen werden soll
 * </pre>
 */
public class MonatsPlan {
    public static void main(String[] args) {
        String[] wochenTage = {"Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag", "Montag"};
        String[] lieblingsgerichte = {"Reis", "Noodle", "Brot", "Hänchen"};
        int tag = 0;
        int gerichtIndex = 0;
        while(tag<31){
            for (int i = 0; i < 7 && tag<31; i++) {
                tag++;
                String gericht = lieblingsgerichte[gerichtIndex];
                gerichtIndex = (gerichtIndex + 1) % lieblingsgerichte.length;git
                System.out.println("Am " + wochenTage[i] + ", den " + tag + ". Dezember gibt es " + gericht);
            }
        }
    }
}
