package it.schlaukopf.leute;

import it.schlaukopf.organisation.Schlaukopf;

import java.util.Random;

/**
 * <pre>
 *     Ein Physiker ist ein schlauer Kopf. (implements Schlaukopf)
 *
 *     Physiker sind sehr verschieden: zb Theoretische Physiker forschen
 *     ganz anders als Experimental Physiker oder AstroPhysiker....
 *
 *     Aus der Klasse Physiker sollen gar keine Objekte erstellt werden,
 *     sondern nur Objekte aus den Kind klassen.
 *     Lösung: abstrakte Klasse
 *
 *     Abstrakte Klassen dürfen Abstrakte Methoden enthalten: reden, forschen
 *     Abstrakte Klassen dürfen konkrete Methoden enthalten: veroeffentlichen, haareRaufen, denken
 *     Abstrakte Klassen dürfen final Methode enthalten: haareRaufen
 *     Abstrakte Klassen dürfen Objekt-Attribute enthalten: azahlZerstoerterMessgeraete, anzahlVeroeffentlichungen
 *     Abstrakte Klassen haben (mindestens) einen Konstruktor.
 *
 *     Abstrakte Klassen können erweitert werden(no final possible): extends Physiker
 * </pre>
 */
public abstract class Physiker implements Schlaukopf {
    /**
     * Jeder Physiker hat im Laufe seiner Karriere das eine oder andere
     * Messgeräte zerstört.
     * Eine abstrakte Klasse kann Objekt-Attribute haben, ein Interface nicht!
     */
    protected int azahlZerstoerterMessgeraete;

    /**
     * Objekt-Attribut vorinitialisiert mit 0
     */
    protected int anzahlVeroeffentlichungen;

    /**
     * Auch abstrakte Klassen können einen Konstruktor haben.
     * Er wird mit super von den Kind klassen aufgerufen.
     */
    public Physiker() {
        Random wuerfel = new Random();
        azahlZerstoerterMessgeraete = wuerfel.nextInt(10,100);
    }

    /**
     * Diese Methode hat einen Inhalt/Körper/{...}: sie ist <b>konkret</b>.
     * Eine "normale" Methode, die in erbenden Klassen überschieben werden kann, aber nicht
     * überschrieben werden muss.
     */
    public void veroeffentlichen() {
        anzahlVeroeffentlichungen++;
        System.out.println("Schon wieder was herausgefunden, auch wenn bisher " + azahlZerstoerterMessgeraete
        + " Messgeräte kaputt gegangen sind. Das war Veröffentlichung Nr: " + anzahlVeroeffentlichungen);
    }

    /**
     * Verschiedene Arten von Physikern forschen sehr unterschiedlich:
     * Dieser Methode soll in allen erbenden Klassen überschrieben werden: abstract.
     * Abstrakte Methoden brauchen den <i>abstract</i> Modifier
     */
    public abstract void forschen();

    /**
     * Alle Physiker kennen das Problem: Theorien werden widerlegt.
     * Das ärgert und ist zum Haare Raufen.
     * Diese Methode soll in erbenden Klassen nicht überschrieben werden: final.
     * Abstrakte Klasse kann final Methoden haben, das Interface nicht.
     */
    public void haareRaufen() {
        System.out.println("Es ist zum Haare raufen: schon wieder wurde meine Theorie widerlegt!");
    }
}
