package de.ogergames.figuren.helden;

import de.ogergames.figuren.Charakter;
import de.ogergames.figuren.Held;

/**
 * <pre>
 *     Ein Krieger ist ein Held Krieger extends Held.
 *
 *     Damit ist ein Krieger auch ein Charakter:
 *     Krieger IST EIN Held
 *     Krieger IST EIN Charakter
 *
 *     Adressen von Objekten vom Typ Krieger können in Referenzen gespeichert werden,
 *     die Typ Charakter,Held oder Krieger haben.
 *     Problem:
 *     Der default ("spendierter"= Konstruktor.
 *      public Krieger(){
 *         super(); Dies würde den parameterlosen Konstruktor der Elternklasse (Held) aufrufen. Den gibt es nicht!
 *     }
 * </pre>
 */
public class Krieger extends Held {
    /**
     * Wenn der Krieger verwundet, wir dieser Kampfschrei ausgegeben.
     */
    protected String kampfschrei;

    /**
     * Weil in der Elternklasse kein parameterloser Konstruktor existiert, muss es in der Kindklasse
     * einen expliziten Konstruktor geben, der den super-Aufruf macht und dabei Parameter eingibt.
     * @param heldenname wird "durchgereicht" über super
     * @param username wird "durchgereicht" über super
     * @param kampfschrei wird mit Parameter initialisiert.
     */
    public Krieger(String heldenname, String username, String kampfschrei){
        super(heldenname, username);
        this.kampfschrei = kampfschrei;
    }

    /**
     * Auch ein parameterloser Konstruktor ist möglich, wenn explizit der super Aufruf mit Parametern erfolgt
     */
    public Krieger(){
        super("Gast");
        kampfschrei = "DRUFFFF";
    }

    /**
     * Um Wiederholungen des eigenen Codes zu vermeiden, kann mit this(...) den Konstruktor der
     * eigenen Klasse aufrufen.
     * new Aufrufe:
     * new Krieger("Tatata"); User: Mila Meyer
     * new Krieger("Dracula", "Peter Shaw", "????"); User: Peter Shaw
     * @param kampfschrei durchgereicht an den Konstruktor mit 3 Parametern
     */
    public Krieger(String kampfschrei){
        this("Pumuckl der Unsichtbare", "Mila Meyer", kampfschrei);

//        super("Pumuckl der Unsichtbare", "Mila Meyer");
//        this.kampfschrei = kampfschrei;
    }

    /**
     * überschreibt die Methode verwunden aus der Held Klasse, in der Held Klasse wird diese
     * Methode geerbt aus Charakter
     * @param einAnderer der andere Charakter, der vom aktuell handeln, dem Charakter verwundet wird.
     */

    @Override
    public void verwunden(Charakter einAnderer){
        System.out.println("-------------------- " + kampfschrei + " ------------------");
        super.verwunden(einAnderer);
    }

    /**
     * Wieder wird die Methode der Elternklasse aufgerufen: super.
     * Hier wird mit super.die Methode der Held Klasse aufgerufen.
     * @return enthält zusätzlich den Kampfschrei
     */
    @Override
    public String erstellenStatusInformation(){
        return super.erstellenStatusInformation() + "Der Kampfschrei ist " + kampfschrei + ".\n";
    }
}
