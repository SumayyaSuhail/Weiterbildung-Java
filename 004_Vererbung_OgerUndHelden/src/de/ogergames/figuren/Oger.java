package de.ogergames.figuren;

import java.util.Random;
import java.util.UUID;

/**
 * <pre>
 *     Ein Oger ist der Bösewicht im Spiel: Ein Gegner für alle Helden.
 *     Ein Oger wird nicht vom user geführt(NPC).
 *
 *     Ein Oger ist ein Charakter und damit auch ein Objekt : extends Charakter
 *     Die Oger-Klasse soll nicht erweitert werden können: final (extends Oger -> Compiler fehler)
 *
 *     Ein Oger hat keinen Namen, aber ein Oger hat eine ID: keine zwei Oger im Spiel sollen
 *     die gleiche ID haben: ID soll eindeutig sein.
 *
 *     Sobald ein Oger seine ID bekommen hat, darf diese nicht mehr geändert werden.
 * </pre>
 */
public final class Oger extends Charakter{

    /**
     * ein final Attribut wird NICHT vorinitialisiert.
     * Entweder muss das Attribut bei der Deklaration initialisiert werden,
     * oder in jedem Konstruktor der Klasse.
     */
    private final int id;

    /**
     * static: Gehört nicht zum Objekt, sondern zur Klasse:
     * Klassenattribut
     * kann in Objekten angesprochen werden
     */
    private static int ogerIdGenerator; // = 0;

    /**
     * Konstante: Oft public.
     * Konvention: Komplett Großebuchstaben, Worttrennung mit Unterstrich
     */
    public static final String ZU_HAUSE = "Ogersheim";

    /**
     * Initialisiert das final Attribut id und ändert
     * das gemeinsam genutzte Klassen Attribut ogerIdGenerator
     */
    public  Oger(){
        ogerIdGenerator++;
        id = ogerIdGenerator;
    }

    @Override
    public String toString() {
        return "Dieser Oger hat die ID " + id;
    }

    /**
     * Eine Klassenmethode kann das Klassenattribut lesbar machen
     * Statische Methode werden mit Klassennamen aufgerufen!
     * zB Oger.getOgerIdGenerator();
     * @return der aktuelle Wert von ogerIdGenerator
     */
    public static int getOgerIdGenerator() {
        return ogerIdGenerator;
    }
}
