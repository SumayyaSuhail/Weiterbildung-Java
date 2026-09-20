package de.altesschloss.derpassendeschluessel;

import java.util.Scanner;

/**
 * Klass Abenteurer besitzt name und einen Schlüsselbund (Array)
 * kann Schlüssel herstellen
 * kann versuchen, Türen zu öffnen
 */
public class Abenteurer {
    /** Name of the Adventurer */
    private String name;

    /** array of keys that the adventure have with him */
    private Schluessel[] schluesselBund;
    private int anzahl;

    public Abenteurer(String name) {
        this.name = name;
        schluesselBund = new Schluessel[3];
        this.anzahl = 0;
    }

    /**
     * Adds new Schlüssel to the array of Schlüssel if the limit does not reach
     * @param neuerSchluessel new key to be added to the array
     */
    public void schluesselHinzufuegen(Schluessel neuerSchluessel) {
        if (anzahl < schluesselBund.length) {
            schluesselBund[anzahl] = neuerSchluessel;
            anzahl++;
        } else {
            System.out.println(name + "s Schlüsselbund ist voll!");
        }
    }

    /**
     * create new key interactively by collecting details from the user.
     * @return the new key created
     */
    public Schluessel schluesselHerstellen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Passt keiner Schlüssel, " + name + " stellt einen weiteren Schlüssel her.");
        System.out.println("Große: ");
        double grosse = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Material: ");
        String material = scanner.nextLine();

        System.out.println("Gewicht: ");
        double gewicht = scanner.nextDouble();

        System.out.println("Anzahl Zacken: ");
        int zacken = scanner.nextInt();

        System.out.println("Anzahl Kerben: ");
        int kerben = scanner.nextInt();

        Schluessel neuerschluessel = new Schluessel(grosse,material, gewicht, new SchluesselBart(zacken,kerben));
        schluesselHinzufuegen(neuerschluessel);

        System.out.println("Neuer Schlüssel hergestellt: " + neuerschluessel);
        return neuerschluessel;
    }

    /**
     * Try to open the door if it is closed with the keys in the array of keys.
     * if no key can open, create new key
     * @param tuer the door which is to be opened
     */
    public void tuerOffnen(Tuer tuer){
        System.out.println(name + " steht vor der Tür " + tuer.getName() + ".");
        while (tuer.isVerschlossen()){
            boolean schluesselpasst = false;
            for (int i = 0; i < anzahl; i++) {
                if(tuer.versuchen(schluesselBund[i])){
                    schluesselpasst = true;
                    break;
                }
            }
            if(!schluesselpasst){
                System.out.println("Keiner der vorhandenen Schlüssel passt.");
                schluesselHerstellen();
            }
        }
    }

    public Schluessel[] getSchluesselBund() {
        return schluesselBund;
    }
}
