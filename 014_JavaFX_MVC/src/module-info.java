/**
 * Das Projekt wird zu einem eigenen Modul.
 * Hier: Vorteil der Modul Path wird nicht in der Run-Konfiguration gesetzt.
 *       Der Ort, an dem die jar-File gespeichert sind, muss nicht angegeben werden.
 *
 * Gibt an, welche anderen Module notwendig sind im Projekt: requires,
 *          welche eigenen Packages ins Projekt aufgenommen werden müssen: opens
 */
module marmelade.kochen {
    requires javafx.controls;

    opens de.tollemarmelade;
}