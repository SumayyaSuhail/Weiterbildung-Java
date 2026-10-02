package de.onlineshop;

import de.onlineshop.backend.DatenbankZugriff;
import de.onlineshop.model.Bestellung;
import de.onlineshop.model.Kunde;

import java.time.LocalDate;
import java.util.List;

/**
 * Aufrufe der lesen /schreiben /optional/update und delete Methoden
 */
public class MyOnlineShop {
    public static void main(String[] args) {
        System.out.println("Willkommen bei mein Online Shop\n");
        DatenbankZugriff james = new DatenbankZugriff();

        String aktion = "lesen";
//        aktion = "Kunden Schreiben";
//        aktion = "Bestellung Schreiben";
//        aktion = "Kunden Update";
//        aktion = "Bestellung Update";
//        aktion = "Kunden Delete";
//        aktion = "Bestellung Delete";
        if (aktion.equalsIgnoreCase("Lesen")) {

            List<Kunde> kundenAusTabelle = james.lesenKunde();
            kundenAusTabelle.forEach(kunde -> System.out.println(kunde));

            List<Bestellung> bestellungenAusTabelle = james.lesenBestellung();
            bestellungenAusTabelle.forEach(bestellung -> System.out.println(bestellung));

        } else if (aktion.equalsIgnoreCase("Kunden Schreiben")) {

            Kunde beispielKunde = new Kunde();
            System.out.println("Neu erfunden: " + beispielKunde);
            james.schreibenInKunde(beispielKunde);
            System.out.println("Jetzt in der Datenbank: \n" + beispielKunde);

        } else if (aktion.equalsIgnoreCase("Bestellung Schreiben")) {

            Bestellung beispielBestellung = new Bestellung();
            System.out.println("Neu erfunden: " + beispielBestellung);
            james.schreibenInBestellung(beispielBestellung);
            System.out.println("Jetzt in der Datenbank: \n" + beispielBestellung);

        } else if (aktion.equalsIgnoreCase("Kunden Update")) {

            Kunde beispielKunde = new Kunde("Clara", "Weber", "clara.weber@gmail.com", LocalDate.of(2026, 9, 20));
            james.schreibenInKunde(beispielKunde);
            System.out.println("Before Update: \n" + beispielKunde);
            Kunde aktualisiertKunde = james.updateInKunde(beispielKunde, "Tom");
            System.out.println("After Update: \n" + aktualisiertKunde);

        } else if (aktion.equalsIgnoreCase("Bestellung Update")) {

            Bestellung beispielBestellung = new Bestellung("Maus", 19.95);
            james.schreibenInBestellung(beispielBestellung);
            System.out.println("Before Update: \n" + beispielBestellung);
            Bestellung aktualisiertBestellung = james.updateInBestellung(beispielBestellung, 200);
            System.out.println("After Update: \n" + aktualisiertBestellung);

        } else if (aktion.equalsIgnoreCase("Kunden Delete")) {

            Kunde beispielKunde = new Kunde("Mary", "John", "mary.john@gmail.com", LocalDate.of(2026, 10, 20));
            james.schreibenInKunde(beispielKunde);
            james.deleteInKunde(beispielKunde);
            System.out.println("Kunde ist ausgelöscht");

        } else if (aktion.equalsIgnoreCase("Bestellung Delete")) {

            Bestellung beispielBestellung = new Bestellung("Tastatur", 35.5);
            james.schreibenInBestellung(beispielBestellung);
            james.deleteInBestellung(beispielBestellung);
            System.out.println("Bestellung ist ausgelöscht");
        }
    }
}
