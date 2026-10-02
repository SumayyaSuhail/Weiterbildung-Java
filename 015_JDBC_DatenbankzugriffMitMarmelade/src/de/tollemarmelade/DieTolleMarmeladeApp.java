package de.tollemarmelade;

import de.tollemarmelade.backend.DatenbankZugriffMitTryWithResources;
import de.tollemarmelade.model.Marmelade;

import java.time.LocalDate;
import java.util.List;

/**
 * <pre>
 *     Eine Applikation, die Daten aus der Tabelle Marmelade nutzt.
 *     das könnte zb eine Java FX Anwendung sein....
 *
 *     C:\Users\sumay\.jdks\temurin-21.0.12.1\bin\java.exe de.tollemarmelade.DieTolleMarmeladeApp lesen
 *     out/production/015_JDBC_DatenbankzugriffMitMarmelade/de/tollemarmelade/DieTolleMarmeladeApp.class
 *
 *     -cp ".;C:\Users\sumay\Desktop\Libraries\mysql-connector-j-26.7.0\mysql-connector-j-26.7.0"
 *
 *     C:\Users\sumay\.jdks\temurin-21.0.12.1\bin\java.exe -cp ".;C:\Users\sumay\Desktop\Libraries\mysql-connector-j-26.7.0\mysql-connector-j-26.7.0\mysql-connector-j-26.7.0.jar" de.tollemarmelade.DieTolleMarmeladeApp lesen
 * </pre>
 */
public class DieTolleMarmeladeApp {
    public static void main(String[] args) {
        System.out.println("Willkommen bei den Marmeladen Fans\n");

        String aktion = "Lesen";
        if (args.length > 0) {
            aktion = args[0];
        }
        if(aktion.equalsIgnoreCase("schreiben")) {
            System.out.println("Viele Marmeladen gibt es schon, jetzt kommt eine neue dazu.");
            Marmelade beispielMarmelade = new Marmelade("Mittagsmarmelade mit Salzmandeln",
                    "Quitte",
                    60, LocalDate.of(2026, 1, 2), false);
            System.out.println("Neu erfunden: " + beispielMarmelade);

            DatenbankZugriffMitTryWithResources james = new DatenbankZugriffMitTryWithResources();
            james.schreibenInMarmelade(beispielMarmelade);
            System.out.println("Jetzt in der Datenbank: \n" + beispielMarmelade);
            //james.schreibenInMarmelade(beispielMarmelade); // Die selbe Marmelade wird zwei mal geschrieben
        } else if (aktion.equalsIgnoreCase("Lesen")) {
            DatenbankZugriffMitTryWithResources james = new DatenbankZugriffMitTryWithResources();
            List<Marmelade> marmeladenAusTabelle = james.lesenMarmeladen();
            marmeladenAusTabelle.forEach(marmelade -> System.out.println(marmelade));
        }
    }
}
