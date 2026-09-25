package de.mygarten.faehigkeit;

/**
 * <pre>
 *     Eine Klasse ist konkret, wenn sie nicht abstrakt ist, kein abstract Schlüsselwort
 *     an der Klassen-Deklaration, keine abstrakte Methoden. Eine konkrete Klasse kann
 *     instanziiert werden.
 * </pre>
 */
public class MiniBagger extends Bagger{

    public MiniBagger(){
        System.out.println("Ich bin MiniBagger");
    }
    /** Method should be overwritten as this is an abstract method in the implemented interface */
    @Override
    public String graben(int flaecheGroesse) {
        return "Minibagger gräbt " + flaecheGroesse + " Quadratmeter in " + stundenProEinsatz + " Stunden -- Zufahrt bitte mindestens 1 Meter breit halten.";
    }

    /** Method can be overwritten only if needed */
    @Override
    public void pauseMachen() {
        System.out.println("Der Minibagger braucht eine kurze Verschnaufpause zum Abkühlen.");
    }

    /** Method should be overwritten as this is an abstract method in the extended abstract class */
    @Override
    public String zeitAngeben() {
        return "Dieser Bagger benötigt ca. " + stundenProEinsatz + " Stunden pro Einsatz.";
    }
}
