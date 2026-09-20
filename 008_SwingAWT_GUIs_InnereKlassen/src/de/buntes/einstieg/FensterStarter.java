package de.buntes.einstieg;

/**
 * Erstellt ein Objekt vom Typ ErstesFenster, ErstesFenster ist ein JFrame.
 * Zeigt das Fenster an: setVisible(true)
 */
public class FensterStarter {
    public static void main(String[] args) {
        System.out.println("Anfang");

//        ErstesFenster fenster = new ErstesFenster();
//        fenster.setVisible(true);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.print(".");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ignore){
//
//            }
//        }

        ZweitesFenster fenster = new ZweitesFenster();
        fenster.setVisible(true);

        System.out.println("Ende");
    }
}
