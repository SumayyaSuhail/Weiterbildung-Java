package de.ogergames.figuren;

import java.util.Random;

/**
 * <pre>
 *     "Verbesserte Charakterklasse"
 *
 *     Wünsche an die verbesserte Klasse:
 *          Ein Charakter sollte einen Namen haben(für die Siegerehrung)
 *          Ein Charakter sollte einen Initiative Wert haben (für die Reihenfolge im Kampf)
 *          Ein Charakter sollte "gespielt werden" können: Der User/Spieler soll Entscheidungen
 *          treffen können: User kann auswählen, ob er sich im Kampf ausruht, dabei Lebenspunkte
 *          regeneriert, oder angreift (verwunden)
 *          Dazu soll der User angesprochen werden: Username
 *          Ein ausgeschiedene Charakter soll nach dem Turnier wieder belebt werden können.
 *
 *     "Blick aus dem Fenster"/Objektbeschreibung
 *     Dieser Held wird unter dem Name "Dracula der Blutige" geehrt, wenn er ein Turnier gewinnt
 *     Dieser Held wird gespielt von Justust Jonas.
 *     Dieser Held hat eine Initiative von 551. (zwischen 100 und 1.000)
 *     Dieser Held hat 112 Lebenspunkte.
 *     Dieser Held verursacht 15 Schaden.
 *     Dieser Held ist noch dabei.
 *
 *     Dieser Held verwundet in dieser Runde seinen Gegner.
 *     Dieser Held wird verwundet.
 *     Der User entscheidet: Diese Held ruht sich in der nächsten Runde aus und regeneriert 24 Lebenspunkte.
 *     Der Held stellt seine statusInformationen zusammen: Lebenspunkte/Schadensrate/Initiative/Heldenname/
 *          Username/noch dabei.
 *     Dieser Held hat das Turnier verloren: Hat weniger als 1 Lebenspunkt: er wird wiederbelebt:
 *          nochDabei wird auf true gesetzt und er erhält seine anfangs ausgewürfelten Lebenspunkte zurück
 *
 *     Ein Held hat alles, was ein Charakter hat (und noch mehr)
 *     Ein Held kann alles, was ein Charakter kann (und noch mehr)
 *
 *     Kopieren aus Charakter: Attribute, Methoden, Körper/Inhalt des Konstruktors
 *     Statt Kopieren: Schlüsselwort <b>extends</b>
 *     extends: Vererbung, Charakter-Klasse "Elternklasse", Oberklasse, Superklasse
 *                          Held-Klasse "Kindklasse",, Untenklasse, Subklasse
 * </pre>
 */
public class Held extends Charakter{
    // ******************** zusätzliche Attribute ******************** //
    /**
     * wird bei der Siegerehrung im Turnier genannt.
     */
    protected String heldenname;

    /**
     * Wird bei der Interaktion im Turnier gebraucht
     */
    protected String username;

    /**
     * Wird im Turnier benutzt, um die Reihenfolge der Angriffe festzulegen
     */
    protected int initiative;

    /**
     * Wird im Konstruktor auf die anfangs ausgewürfelten Lebenspunkte gesetzt
     * und dann nicht mehr geändert.
     */
    protected int maximaleLebenspunkte;

    // ******************** Konstruktoren ******************** //

    /**
     * Die Eingenschaften Heldenname und Username sollen über Parameter im Konstruktor festgelegt werden.
     * new Held("Dracula der Blutigen", "Justus Jonas"); erstellt das Objekt.
     * Der "default" Konstruktor wird nicht mehr ergänzt: die Klasse hat keinen parameterlosen Konstruktor
     * this: die Referenz auf das Objekt selbst
     * Initiative wird ausgewürfelt um die Reihenfolge beim Angriff im Turnier festzulegen
     * Das erste, was in einen Konstruktor passiert, ist ein Konstruktor-Aufruf (Inhalt wird durchgeführt):
     * implizit: super(); (calls the Inhalt of the Parent class Constructor)
     * @param heldenname für die Siegerehrung
     * @param username für die Interaktion
     */
    public Held(String heldenname, String username){
        super(); //würde sonst vom Kompiler ergänzt
        //ab jetzt sind Lebenspunkte und Schadensrate ausgewürfelt
        this.heldenname = heldenname;
        this.username = username;
        Random wuerfel = new Random();
        initiative = wuerfel.nextInt(1000);
        maximaleLebenspunkte = lebenspunkte;
    }

    /**
     * Konstruktoren können <b>Überladen</b> werden.
     * Die Parameterliste unterscheidet sich.
     * @param username für die Interaktion
     */
    public Held(String username){
        //super(); Wird ja automatisch ergänzt
        this.username = username;
        heldenname = "Homer der Gelbe";
        Random wuerfel = new Random();
        initiative = wuerfel.nextInt(1000);
        maximaleLebenspunkte = lebenspunkte;
    }

    // ******************** zusätzliche Methoden ******************** //

    /**
     * Wenn ein Held im Kampf/Turnier ausgeschieden ist, kann er nach dem Kampf reanimiert werden
     * Ein zusätzliches Attribut muss sich die Anfangs ausgewürfelten Lebenspunkte merken.
     */
    public void reanimiertWerden(){

         nochDabei = true;
         lebenspunkte = maximaleLebenspunkte;
    }

    /**
     * In jeder Kampfrunde entscheidet der user, ob sein Held verwunden oder ausruhen soll.
     * Er kann in dieser Runde trotzdem verwundet werden.
     * Beim Ausruhen wird jedes Mal neu asgewürfelt, wie viele Lebenspunkte regeneriert werden.
     */
    public void ausruhen(){
        Random wuerfel = new Random();
        int bonus = wuerfel.nextInt(4, 45);
        lebenspunkte += bonus; //Abkürzung für: lebenspunkte = lebenspunkte + bonus;
        if(lebenspunkte > maximaleLebenspunkte) {
            lebenspunkte = maximaleLebenspunkte;
        }
    }

    /**
     * Die Methode erstellenStatusInformation in der Klasse Charakter tut nicht das, was Objekte vom
     * Typ Held tun sollen.
     * Deshalb wird die Methode <b>überschrieben</b>:
     * überschreiben: die Signatur der Methode ist die gleiche wie in der Elternklasse, aber der Inhalt/Body wurde
     * geändert.
     * @return String der zusätzlich auch Usernamen/Heldennamen/Maximale Lebenspunkte/Initiative enthält
     */
    @Override
    // Annotation: Hinweis für den Code Leser, dass es eine Methode in der Elternklasse mit gleicher Signatur gibt
    // Annotation kontrolliert auch, ob diese Methode wirklich existiert, sonst: Compiler fehler
    // Annotation wie ein "Add-on" zum Compiler
    public String erstellenStatusInformation(){
        String info = "";
        String klassenName = this.getClass().getSimpleName();//"Held"; // Vorbereitung
        info = info + "Dieser " + klassenName + " wird gespielt von " + username + ".\n";
        info = info + "Dieser " + klassenName + " wird geehrt unter " + heldenname + ".\n";
        info = info + "Dieser " + klassenName + " hat aktuell " + lebenspunkte + " Lebenspunkte.\n";
        info = info + "Dieser " + klassenName + " verursacht " + schadensrate + " Schaden.\n";
        info = info + "Dieser " + klassenName + " hat maximal " + maximaleLebenspunkte + " Lebenspunkte.\n";
        info = info + "Dieser " + klassenName + " hat eine Initiative von " + initiative + ".\n";
        info = info + (nochDabei ? "Dieser " + klassenName + " darf noch mitspielen.\n"
                                 : "Dieser " + klassenName + " ist ausgeschieden.\n");
        return info;
    }

    // ******************** getter/setter ******************** //
    public String getHeldenname(){
        return heldenname;
    }

    public String getUsername(){
        return username;
    }

    public int getInitiative(){
        return initiative;
    }
}
