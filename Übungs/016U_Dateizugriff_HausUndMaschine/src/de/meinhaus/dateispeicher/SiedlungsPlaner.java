package de.meinhaus.dateispeicher;

import de.meinhaus.model.Elektrogeraet;
import de.meinhaus.model.Haus;
import de.meinhaus.model.Raum;

import java.io.File;

public class SiedlungsPlaner {

    public static void main(String[] args) {

        DateiUndDatenbankZugriff zugriff = new DateiUndDatenbankZugriff();
        File ziel = new File("objekte/hauslist");

        // --- Haus 1 ---
        Haus haus1 = new Haus("Musterstraße 1", 1998);

        Raum wohnzimmer1 = new Raum("Wohnzimmer", 28.5);
        wohnzimmer1.addElektrogeraet(new Elektrogeraet("Samsung", 150, "Fernseher", 0.8));
        wohnzimmer1.addElektrogeraet(new Elektrogeraet("Dyson", 600, "Staubsauger", 1.2));

        Raum kueche1 = new Raum("Küche", 15.0);
        kueche1.addElektrogeraet(new Elektrogeraet("Bosch", 2000, "Kühlschrank", 0.5));
        kueche1.addElektrogeraet(new Elektrogeraet("Siemens", 1800, "Backofen", 2.1));

        haus1.addRaum(wohnzimmer1);
        haus1.addRaum(kueche1);

        // --- Haus 2 ---
        Haus haus2 = new Haus("Gartenweg 7", 2015);

        Raum schlafzimmer2 = new Raum("Schlafzimmer", 18.0);
        schlafzimmer2.addElektrogeraet(new Elektrogeraet("Philips", 15, "Lampe", 0.1));

        Raum buero2 = new Raum("Büro", 12.5);
        buero2.addElektrogeraet(new Elektrogeraet("Dell", 65, "Laptop", 0.3));
        buero2.addElektrogeraet(new Elektrogeraet("HP", 25, "Drucker", 0.4));

        haus2.addRaum(schlafzimmer2);
        haus2.addRaum(buero2);

        // --- Haus 3 ---
        Haus haus3 = new Haus("Bergstraße 22", 1975);

        Raum keller3 = new Raum("Keller", 20.0);
        keller3.addElektrogeraet(new Elektrogeraet("Miele", 2100, "Waschmaschine", 1.0));
        keller3.addElektrogeraet(new Elektrogeraet("Bosch", 1800, "Trockner", 2.5));

        haus3.addRaum(keller3);

        // Save each house
        zugriff.addHaus(haus1);
        zugriff.addHaus(haus2);
        zugriff.addHaus(haus3);

        System.out.println("3 Häuser wurden gespeichert.");
        zugriff.speichernHaeuser(ziel);
    }
}
