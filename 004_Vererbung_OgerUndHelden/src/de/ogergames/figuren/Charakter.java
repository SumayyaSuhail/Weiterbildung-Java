package de.ogergames.figuren;

import java.util.Random;

/**
 * <pre>
 *     Ein "Computerspiel" soll programmiert werden.
 *     Objekte der Klasse Charakter stellen die grundlegenden Spielfiguren dar.
 *
 *     Die Klasse(class) ist Template/Vorlage/Schnittmuster für Objekte vom Typ Charakter
 *     UND: Referenztyp/Datentyp/Variablentyp für Variablen, die Adressen eines Charakter-Objekts enthalten können.
 *
 *     Hier wird die Grundlage für <i>Vererbung</i> gelegt: Diese Klasse soll später vererbt werden.
 *
 *     "Blick aus dem Fenster" / Objektbeschreibung
 *     Dieser Charakter hat aktuell 112 Lebenspunkte.
 *
 *     Dieser Charakter vursacht beim Schlagen 15 Schadenspunkte: er zieht sinem Gegner 15 Lebenspunkte ab.
 *     Dieser Charakter darf mitspielen, er ist nicht besiegt, er ist noch dabei.
 *
 *     Dieser Charakter stellt seien aktuellen Statusinformation zusammen: Er erstellt einen Text in dem die
 *          aktuellen Lebenspunkte, die Schadensrate und ob er noch dabei ist enthält.
 *     Dieser Charakter verwundet einen anderen Character.
 *     Dieser Charakter wird verwundet.
 *
 *     Abstraktion:
 *     Klasse Charakter
 *     Attribute: Lebenspunkte, Schadensrate und nochDabei
 *     Methoden: verwunden, verwundet werden, StatusInformation erstellen.
 *
 *     Spielregeln:
 *     Lebenspunkte und Schadensrate werden anfangs ausgewürfelt.
 *     Lebenspunkte werden ausgewürfelt zwischen: 100 incl und 120 excl
 *     Schadenrate wird ausgewürfelt zwischen 10 incl und 20 excl
 *     Wenn die Lebenspunkte eines Charakter auf 0 oder darunter fallen, scheidet er aus, ist nicht dabei
 *     Angreifen/Verwunden darf nur ein Charakter, der über 0 Lebenspunkte hat.
 *
 *     private: Sichtbar nur in der Klasse selbst, in der das Attribut/Konstruktoren/Methode deklariert wurde
 *     [] / leer: (zb int zahl): package private/ package friendly Sichtbar im gesamten Package (selten sinnvoll)
 *     protected: Sichtbar im gesamten package und in erbenden Klassen
 *     public: Sichtbar im gesamten Projekt
 *
 *     Jede Klasse in Java erweitert die Klass Objekt. Direkt: Charakter, oder indirekt bei Held, Krieger, ...
 *
 * </pre>
 */
public class Charakter extends Object{
    // ******************** Attribute/Eigenschaften/Felder ******************** //
    /**
     * Lebenspunkte werden anfangs ausgewürfelt.
     * Sie werden reduziert wenn der Charakter verwundet wird.
     * Der Charakter scheidet aus, wenn sie auf 0 fallen oder darunter
     */
    protected int lebenspunkte;
    /**
     * wird anfangs ausgewürfelt und während des Spiels nicht geändert
     */
    protected int schadensrate;
    /**
     * Jeder neu erstellte Charakter ist dabei.
     * Wenn die Lebenspunkte auf 0 oder darunter fallen
     * wird nochDabei auf false gesetzt
     */
    protected boolean nochDabei = true;

    // ******************** Konstruktoren ******************** //
    /**
     * Jede Klasse hat mindestens einen Konstruktor. (class)
     * Wenn kein eigene Konstruktor geschrieben wird, wird automatisch ein Konstruktor erstellt.
     * Dieser Konstruktor ist public, heißt wie die Klasse selbst und erwartet keine Parameter.
     * Dieser Konstruktor tut (erstmal) nichts.
     * Dieser Konstruktor wird nur erstellt, wenn kein eigener, expliziter Konstruktor erstellt wird.
     * Hier: Expliziter Konstruktor.
     * Ein Konstruktor heißt immer wie die Klasse (case sensitiv).
     * Ein Konstruktor ist KEINE Methoden: keine Rückgabe, auch nicht void.
     * Ein Konstruktor kann Parameter haben: Parameterliste wie bei Methoden.
     * Ein Konstruktor wird oft verwendet, um Attribut zu initialisieren.
     * Ein Konstruktor erstellt ein Objekt. wird mit new aufgerufen.
     */
    public Charakter(){
        super();
        Random wuerfel = new Random();
        lebenspunkte = wuerfel.nextInt(100,120);
        schadensrate = wuerfel.nextInt(10,20);
    }

    // ******************** Methoden/Fähigkeiten ******************** //

    /**
     * Wenn dieser Charakter verwundet wird, werden die Lebenspunkte reduziert.
     * Wenn sie auf 0 oder darunter fallen, scheidet det Charakter aus: nochDabei wird auf false gesetzt.
     * Drache hat 120 lebenspunkte und verursacht 17 Schaden / schadensrate = 17;
     * siegfried.verwundetWerden(drachen.schadensrate)
     *
     * @param schaden gibt an, wie viele Schaden dem Charakter zugefügt werden, wieviele Lebenspunkte ihm ab-
     *                gezogen werden. Beim Kampf mit einem anderen Charakter entspricht das genau der
     *                Schadensrate des anderen Charakters
     */
    public void verwundetWerden(int schaden) {
        lebenspunkte = lebenspunkte - schaden;
        if (lebenspunkte <= 0){
            nochDabei = false;
        }
    }

    /**
     * Im Kampf wird ein Charakter einen anderen verwunden: Zieht diesem Lebenspunkte in
     * der der Höhe der Schadensrate an.
     * drache.verwunden(siegfried);
     * siegfried verliert so viele Lebenspunkte, wie die Schadensrate des Drachen (Attribut) angibt
     * @param gegner der andere Charakter, der vom aktuell handelndem Charakter verwundet wird.
     */
    public void verwunden(Charakter gegner){
        gegner.verwundetWerden(schadensrate);
    }

    /**
     * Diese Methode stellt die Informationen zum aktuellen Status der Charakter-Objekts zusammen:
     * Zustand der Lebenspunkte, Zustand der Schadensrate, Zustand von nochDabei
     * @return String, die alle Statusinformationen enthält
     */
    public String erstellenStatusInformation(){
        String info = "";
        info = info + "Dieser Charakter hat aktuell " + lebenspunkte + " Lebenspunkte.\n";
        info = info + "Dieser Charakter verursacht " + schadensrate + " Schaden, wenn er verwundet.\n";
//        if(nochDabei){
//            info = info + "Dieser Charakter ist noch im Spiel.\n";
//        } else {
//            info = info + "Dieser Charakter ist ausgeschieden. Glückwunsch an den Sieger\n";
//        }
        // ******************** Alternative zu einer einfaachen Zuweisung in einer Verzwigung: (?:) Operator *** //
        info = info + (nochDabei ? "Dieser Charakter ist noch im Spiel.\n" : "Dieser Charakter ist ausgeschieden.\n");
        return info;
    }
    // ******************** getter/setter ******************** //

    /**
     * überall im Spiel soll es möglich sein, zu sehen ob der Charakter noch mitspielen/verwunden darf:
     * Lösung: public getter
     *
     * @return Zustand von nochDabei
     */
    public boolean isNochDabei() {
        return nochDabei;
    }

    // ******************** toString ******************** //

    /**
     * Wird automatisch aufgerufen von System.out.println
     * Wenn der + Operator einen String und ein Objekt verknüpft, wird die toString Methode des Objekts aufgerufen
     * @return Informationen zum Charakter-Objekt über: erstellenStatusInformation();
     */
    @Override
    public String toString() {
        return erstellenStatusInformation();
    }
}
