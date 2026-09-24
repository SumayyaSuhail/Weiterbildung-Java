package it.schlaukopf.organisation;

/**
 * <pre>
 *     In einem Forum gibt es eine Menge schlauer Leute.
 *     Damit wirklich nur schlaue Leute ins Forum kommen,
 *     muss jeder, der sich beteiligen will, diese Interface implementieren.
 *
 *     Dieses Projekt hat den Schwerpunkt <b>Lambda</b> Ausdruck,
 *     deshalb wird dieses Interface ein <i>funktionales</i> Interface sein.
 *
 *     genau eine abstrakte Methode <-> Funktionale Interface </-> Lambda möglich
 *
 *     Interface: Referenztyp
 *     Schlaukopf fuchs = ....;
 *     String fuchsWissen = fuchs.reden(); // hashCode, equals, toString, getClass
 *
 *     was ist mit denken? Mit <i>default</i>:
 *     fuchs.denken();
 * </pre>
 */
@FunctionalInterface
public interface Schlaukopf {
    /**
     * Ein schlauer Kopf hat etwas zu sagen!
     * Ein Objekt, das mit diesem Referenztyp angesprochen werden kann <b>muss</b> diese Methode implementieren
     * @return das, was der schlaue Kopf zu sagen hat.
     */
    String reden();

    /**
     * Diese Methode ist nicht abstrakt, sie hat bereits eine Implementierung: eine konkrete Methode.
     * Konkrete Methoden im Interface müssen mit <b>default</b> gekennzeichnet werden.
     * Eine default Methode <b>kann</b> überschrieben werden, muss sie aber nicht.
     */
    default void denken(){
        System.out.println("ICH HABE RECHT1");
    }
}
