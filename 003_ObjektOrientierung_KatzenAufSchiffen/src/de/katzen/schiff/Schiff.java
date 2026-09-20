package de.katzen.schiff;

import java.util.Random;

/**
 * <pre>
 *     Demonstriert die HAS-A / HAS-MANY Beziehung zwischen Klassen / Datentypen.
 *
 *     Has-a-Beziehung / Has-may-Beziehung:
 *     Ein Auto hat einen Motor.
 *     Ein Haus hat Zimmer.
 *     Ein Zimmer hat Fenster.
 *     Ein Schiff hat eine Katze.
 *
 *     "Blick aus dem Fenster"/Objektbeschreibung:
 *     Das Schiff heißt Nostromo.
 *     Das Schiff hat einen Kapitän namens Dallas.
 *     Das Schiff hat eine feste Besatzung.
 *     Das Schiff hat die Katze Jones. (Auf dem Schiff lebt die Katze Jones)
 *
 *     Das Schiff beauftragt ein Besatzungsmitglied, die Katze zu füttern
 *     Das Schiff beruft eine Besprechung ein, bei der sich alle Besatzungsmitglieder äußern.
 *     Das Schiff begegnet einem Monster und wird angegriffen.
 *
 *     Abstraktion:
 *     Klasse Schiff
 *
 *     Ein Schiff hat einen Namen
 *     Ein Schiff hat einen Kapitän. (Name)
 *     Ein Schiff hat eine Besatzung,
 *     Ein Schiff hat eine Katze.
 *
 *     Ein Schiff kann eine Katze füttern lassen.
 *     Das Schiff kann eine Besprechung einberufen, bei der sich alle Besatzungsmitglieder äußern.
 *     Das Schiff kann einem Monster begegnen und vielleicht angegriffen werden.
 *
 * </pre>
 */
public class Schiff {

    // region ******************** Attribute/Eigenschaften/Felder ******************** //
    /**
     * Name des Schiffs, zum Beispiel Nostromo
     */
    private String name; // = null;

    /**
     * Name des Kapitäns
      */
    private String kapitaen;

    /**
     * <pre>
     *     Ein Attribut kann bei der Deklaration initialisiert werden.
     *     Damit hat jedes Schiff(Instanz) aus dieser Klasse die gleichen Besatzungsmitglieder
     * </pre>
     */
    private String[] besatzung = {"Ellen", "Lambert", "Brett", "Parker", "Ash", "Dallas"};

    /**
     * Verwendet einen komplexen, selbstgeschriebenen Datentyp.
     */
    private Katze schiffKatze;

    // endregion

    // region ******************** Methoden/Fähigkeiten/Jobs ******************** //

    /**
     * <pre>
     *     Ein zufällig ausgewählte Besatzungsmitglied fütter die Schiffskatze
     *     Dazu wird ein Random-Objekt erstellt.
     *     Diese generiert einen zufälligen Index zu dem besatzungs-Array.
     *     Dann wird gefüttertWerden, der Katze aufgerufen
     * </pre>
     */
    public void katzeFuetternLassen(){
        Random wuerfel = new Random();
        int index = wuerfel.nextInt(besatzung.length);
        System.out.println(besatzung[index] + " füttert " + schiffKatze.getName() + ".");
        schiffKatze.gefuettertWerden();
    }

    /**
     * Jedes Besatzungsmitglied kommt zu Wort: erweiter for-Schleife.
     * @param thema das Thema der Besprechung
     */
    public void bespreschungDurchfuehren(String thema){
        String[] aussagen = {
                "Ich bin dafür.",
                "Das halte ich für keine gute Idee.",
                "Wir sollten noch einmal darüber nachdenken.",
                "Mir ist das eigentlich egal.",
                "Können wir jetzt endlich essen?"
        };
        Random wuerfel = new Random();
        System.out.println("Besprechung zum Thema " + thema);
        for (String mitglied : besatzung){
            int index = wuerfel.nextInt(aussagen.length);
            System.out.println(mitglied + ": " + aussagen[index]);
        }
    }

    /**
     * Aktuell wird hier nur der Name des Monsters verwendet. z.B. Riesenkrake.
     * Später könnte Monster ein eigener Datentyp/Klasse sein
     * @param monster Name des Monsters
     */
    public void monsterBegegnen(String monster){
        System.out.println("Die " + name + " begegnet einem Monster: " + monster + ".");
        Random muenze = new Random();
        boolean monsterGreiftAn = muenze.nextBoolean();
        if (monsterGreiftAn){
            int index = muenze.nextInt(besatzung.length);
            System.out.println(monster + " greift an!");
            System.out.println(besatzung[index] + " fällt dem " + monster + " zum Opfer.");
        } else {
            System.out.println("Das " + monster + " zieht friedlich weiter.");
        }
    }
    //endregion

    // region ******************** getter/setter ******************** //

    public String getName() {
        return name;
    }

    public String getKapitaen() {
        return kapitaen;
    }

    public String[] getBesatzung() {
        return besatzung;
    }

    public Katze getSchiffKatze() {
        return schiffKatze;
    }

    public void setName(String schiffsName) {
        name = schiffsName;
    }

    public void setKapitaen(String nameDesKaptaens){
        kapitaen = nameDesKaptaens;
    }

    public void setSchiffsKatze(Katze katze){
        schiffKatze = katze;
    }
}
