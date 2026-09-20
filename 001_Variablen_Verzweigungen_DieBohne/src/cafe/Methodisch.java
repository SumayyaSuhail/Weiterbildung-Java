package cafe;

/**
 * <pre>
 *     Demonstriert die Anwendung und den Aufbau von Methoden.
 *
 *     Methoden sind "Jobs", die erledigt werden können.
 *     Pro Methode wird <b>ein</b> Job erledigt.
 *
 *     Methode sind Codeblöcke, die bei Bedarf beauftragt werden. (Punkt-Operator, später)
 *     Methoden stellen ein <i>Modul</i> dar.
 * </pre>
 */
public class Methodisch {
    /**
     * <pre>
     *     Organisiert den Ablauf des gesamten Programms.
     * </pre>
     *
     * @param args Kann Start-Parameter enthalten. Wird hier nicht verwendet
     */
    public static void main(String[] args) {
        System.out.println("Anfang\n");
        int antwort = 42;
        // Ein Trennlinie soll gezeichnet werden.
        zeichnenEinerTrennlinie();
        System.out.println("..... ganz viel Spannendes.....");

        zeichnenEinerTrennlinie("Gleich wird getauscht");
        String neuesThema = "Spannend";
        zeichnenEinerTrennlinie(neuesThema);

        int kopie = antwort;
        System.out.println("Antwort: " + antwort + ", Kopie: " + kopie);
        antwort = 67;
        System.out.println("Antwort: " + antwort + ", Kopie: " + kopie);
        ruecksetzen(antwort); //in der Methode landet die Kopie des Wertes der Variablen
        System.out.println("Antwort: " + antwort);

        erstellenDerAntwort();
        //Methoden mit Rückgabe können aufgerufen werden, ohne die Rückgabe entgegen zu nehmen.
        antwort = erstellenDerAntwort();
        System.out.println("Antwort: " + antwort);

        System.out.println("\nEnde");
    } //Keine Gültigkeit mehr von antwort, neuesThema, kopie...

    /**
     * Für den Aufrufer der Methode wird win Wert produziert: Rückgabe
     * @return den Wert 42
     */
    public  static int erstellenDerAntwort(){
        return 42;
    }

    /**
     * Versuch den Parameter auf 42 zu setzen
     * Parameter sind wie in einer Methode deklarierte Variablen <b>lokale</b> Variablen:
     * Sie sind nur innerhalb der Methode gültig.
     * @param antwort der eingegebene int-Wert
     */
    public static void ruecksetzen(int antwort){
        antwort = 42;
    }

    /**
     * <pre>
     *     Zeichnen einer Trennlinie, die das kommende Thema anzeigt
     *     Überladung: Diese Methode überlad die erste zeichnenEinerTrennlinie Methode:
     *              Gleicher Methoden-Bezeichner, unterschiedliche Parameterliste
     *
     *     Die Parameter müssen beim Aufruf der Methode initialisiert werden: methode(wert).
     * </pre>
     *
     * @param dasNeueThema das Thema, das in der Trennlinie angezeigt wird.
     */
    public static void zeichnenEinerTrennlinie(String dasNeueThema) {
        System.out.println("\n^^^^^^^^^^ " + dasNeueThema + "^^^^^^^^^^\n");
    }

    /**
     * <pre>
     *     1: Zugriffsmodifier: Wer darf diese Methode beuftragen. Hier <i>public</i>
     *  static: Ohne Objekt benutzbar
     *     2: Rückgabetyü (Datentyp wie int, boolean, String..) oder void: Dem Aufrufer werden keine Daten geliefert.
     *     3: Methodenbezeichner: sprechend, meist Verben, startet min Kleinbuchstaben, dann CamelCase, keine Unterstiche
     *     4: (
     *     5: Liste (möglicherweise leer) von Variablen Deklarationen, mit Komma getrennt
     *     6: )
     *     7: {....} Body, Methoden-Körper, Ablauf des Programms
     * </pre>
     */
    public static void zeichnenEinerTrennlinie() {
        System.out.println("\n~~~~~~~~~~ ein neues Thema ~~~~~~~~~~\n");

    }
}
