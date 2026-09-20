package de.tollemarmelade.ueber.marmelade;

/**
 * <pre>
 *     Erklärhilfe für die Klasse java.time.LocalDate.
 *
 *     Vorlage für Datumsobjekte (template).
 *     Referenztyp für Datumsobjekte (MeinDatum heute)
 * </pre>
 */
public class MeinDatum {

    // ******************** Attribute ******************** //
    /** Tag des Monats */
    private int tag;
    /** Monat im Jahr */
    private int monat;
    /** nur positive Werte */
    private int jahr;

    // ******************** Konstruktoren ******************** //

    /**
     * Wunsch: Der Konstruktor soll keine Exception auslösen, der Konstruktor soll nur mit validen Werten
     * aufgerufen werden
     */
    private MeinDatum(int tag, int monat, int jahr) {
        validieren(tag, monat, jahr); //löst möglicherweise eine Exception aus.
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    // ******************** Methoden ******************** //

    /**
     * Factory Methode:
     *      erstellt Objekt
     *      ist static, kann mit Klassennamen aufgerufen werden
     *      hat einfache Parameter
     *      kann die Parameter testen, validieren, bevor der Konstruktor aufgerufen wird
     *      kann einen sprechenden Namen haben, sprechender als Konstruktoren
     * Factory Methoden: nach einem <i>Design Pattern</i>
     * @param tag Tag des Monats
     * @param monat Monat im Jahr
     * @param jahr nicht negativ
     * @return ein MeinDatum Objekt, das getestete, validierte Werte enthält
     */
    public static MeinDatum erstellenGueltigesDatum(int tag, int monat, int jahr){
        validieren(tag, monat, jahr);
        MeinDatum gueltigesDatum = new MeinDatum(tag, monat, jahr); //Löst KEINE Exception aus
        return gueltigesDatum;
    }
    /**
     * KI generiert: java code to validate if the date is valid
     * @param tag
     * @param monat
     * @param jahr
     */
//    private void validieren(int tag, int monat, int jahr) {
//        if (tag < 1 || monat < 1 || monat > 12){
//            throw new KeinGueltigesDatumException();
//        }
//    }

    private static void validieren(int tag, int monat, int jahr) {
        if (monat < 1 || monat > 12 || tag < 1) {
            throw new KeinGueltigesDatumException();
        }

        int maxTag;

        switch (monat) {
            case 4: case 6: case 9: case 11:
                maxTag = 30;
                break;
            case 2:
                maxTag = istSchaltjahr(jahr) ? 29 : 28;
                break;
            default: // 1, 3, 5, 7, 8, 10, 12
                maxTag = 31;
        }

        if (tag > maxTag) {
            throw new KeinGueltigesDatumException();
        }
    }

    private static boolean istSchaltjahr(int jahr) {
        return (jahr % 4 == 0 && jahr % 100 != 0) || (jahr % 400 == 0);
    }

    @Override
    public String toString() {
        return tag + "." + monat + "." + jahr;
    }
}
