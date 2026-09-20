package de.katzen.schiff;

/**
 * <pre>
 *     "Blick aus dem Fenster" / Objektbeschreibung
 *     Eine Katze die Jones heißt.
 *     Jones ist 5 Jahre alt.
 *     Jones hat Hunger.
 *
 *     Jones wird gefüttert.
 *     Weil Jones Hunger hat, frisst sie alles auf und ist danach satt.
 *     Jones wird noch einmal gefüttert.
 *     Weil sie keinen Hunger hat, geht sie arrogant weg.
 *     Weil Jones nach dem Herumlaufen wieder Hunger hat, fängt Jones eine Maus.
 *
 *     Abstraktion:
 *     Die Klasse heißt Katze
 *
 *     Eine Katze hat einen Namen
 *     Eine Katze hat ein Alter
 *     Eine Katze hat Hunger / ist satt.
 *
 *     Eine Katze kann gefüttert werden.
 *     Eine Katze kann herumlaufen/Umgebung erkunden/arrogant weggehen.
 *     Eine Katze kann eine Maus fangen.
 *
 *     Alles, was ein Objekt <i>hat</i> heißt Attribut/Eigenschaft/Zustand/Feld -> Variable
 *
 *     Alles, was ein Objekt <i>kann</i> heißt Fähigkeit/Job/Methode -> Methode
 *
 *     Grundprinzipien der Objekt-Orientierung:
 *     Abstraktion, Datenkapselung, Vererbung(später), Polymorphismus(später)
 * </pre>
 */
public class Katze {

    // ******************** Attribute/Eigenschaften/Fehler ******************** //
    /**
     * <pre>
     *     Attribute werden dokumentiert.
     *     Attribute werden gekapselt.
     *     <b>private</b>: Dieser Bezeichner kann nur innerhalb der Klasse verwendet werden.
     *     Enthält den Namen der Katze
     *     Attribute sind vorinitialisiert (ähnlich wie die Elemente eines Arrays)
     * </pre>
     */
    private String name; // = null;
    /** Alter der Katze in Jahren */
    private int alter; // = 0;
    /**
     * <pre>
     *     Gibt an, ob die Katze Hunger hat.
     *
     *     true -> die Katze hat Hunger
     *     false -> die Katze ist satt.
     *
     *     Dieser Zustand ändert sich, wenn die Katze gefüttert wird oder eine Maus fängt.
     * </pre>
     */
    private boolean hungrig; // = false;

    // ******************** Methoden/Jobs/Fähigkeiten ******************** //

    /**
     * <pre>
     *     Die Methode ändert den Zustand von Hungrig zu satt.
     *     Ob die Katze danach wieder Hungrig oder nach satt ist, gibt die Methode nicht an:
     *     Keine Rückgabe, die den Zustand hungrig/satt enthält
     *
     *     Diese Methode ist nicht static: Sie wird einen Objekt durchgeführt
     * </pre>
     */
    public void gefuettertWerden(){
        if(hungrig){
            System.out.println(name + " frisst mit großen Appetit.");
            hungrig = false;
            System.out.println(name + " ist jetzt satt und schmust zufrieden");
        } else {
            System.out.println(name + " ist überhaupt nicht hungrig.");
            System.out.println(name + "sieht das Fütter verächtlich an, und geht weg");
            erkunden();
        }
    }

    /**
     * Beim Erkunden wird eine satte Katze schlafen und hungrig werden,
     * eine hungrige Katze sucht sich eine Maus und ist dann satt.
     */
    public void erkunden(){
        System.out.println(name + " erkundet die Umgebung");

        if (hungrig){
            System.out.println(name + " hat Hunger und sucht eine Maus");
            mausFangen();
        } else {
            System.out.println(name + " sucht sich einen Platz für ein kleines Schläfchen");
            hungrig = true;
        }
    }

    /** Übung */
    public void mausFangen(){
        System.out.println(name + " entdeckt eine Maus und frisst sie auf");
        hungrig = false;
    }

    // ******************** wegen Datenkapslung: getter und setter ******************** //

    /**
     * Mit einem setter wird ein Attribut auf einen Wert gesetzt.
     * Ein setter kann Parameter überprüfen, das ist bei einem public Attribut nicht möglich
     * @param katzenName der neue Wert für den Namen der Katze
     */
    public void setName(String katzenName){
        if(katzenName.length() > 15){
            katzenName = katzenName.substring(0,10);
        }
        name = katzenName;
    }
    public void setAlter(int alterDerKatze){
        alter = alterDerKatze;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    /**
     * "getter" für ein boolesches Attribut of is statt get verwendet, weil sich das besser liest
     * @return Zustand, ob die Katze Hunger hat
     */
    public boolean isHungrig() {
        return hungrig;
    }
}
