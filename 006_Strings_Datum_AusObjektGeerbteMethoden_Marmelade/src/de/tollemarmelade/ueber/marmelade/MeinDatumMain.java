package de.tollemarmelade.ueber.marmelade;

import java.time.LocalDate;

/**
 * <pre>
 *     Erstellt MeinDatum Objekte.
 * </pre>
 */
public class MeinDatumMain {
    public static void main(String[] args) {
        MeinDatum heute = MeinDatum.erstellenGueltigesDatum(14,9,2026);//new MeinDatum(14, 9, 2026);
        System.out.println(heute); //toString
        MeinDatum pumucklGeburtstag = MeinDatum.erstellenGueltigesDatum(27,7,1749);//new MeinDatum(37,7,1749);
        System.out.println("Pumuckl wurde geboren am: " + pumucklGeburtstag); // + ruft toString auf

        MeinDatum gueltig = MeinDatum.erstellenGueltigesDatum(3,3,2033);
        System.out.println(gueltig);

        LocalDate weinachten = LocalDate.of(2026, 12,24);
        System.out.println(weinachten);

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getDayOfWeek());
        System.out.println(today.plusDays(100));

        LocalDate problemDatum = LocalDate.of(2026,2,29);
    }
}
