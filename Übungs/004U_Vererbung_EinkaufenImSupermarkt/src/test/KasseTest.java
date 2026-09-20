package test;

import de.supermarkt.alphamart.Kasse;
import de.supermarkt.alphamart.Regal;
import de.supermarkt.alphamart.personen.Kassierer;
import de.supermarkt.alphamart.personen.Kunde;
import de.supermarkt.alphamart.personen.Mitarbeiter;
import de.supermarkt.alphamart.personen.Person;
import de.supermarkt.alphamart.produkte.Lebensmittel;
import de.supermarkt.alphamart.produkte.NonFood;
import de.supermarkt.alphamart.produkte.Produkt;

public class KasseTest {
    public static void main(String[] args) {
        //erstellen regal, kassierer, kunde und produkte
        Regal alpha = new Regal(3);
        Mitarbeiter anna = new Mitarbeiter(101, "Anna");
        Person tom = new Kassierer(102, "Tom");
        Kunde peter = new Kunde("Peter");

        Produkt saft = new Produkt("Saft", 2.0);
        Lebensmittel milch = new Lebensmittel("Milch", 1.99 , "10.09.2026");
        Produkt kleid = new NonFood("Kleid", 30);

        //add products to regal
        anna.regalAufFuellen(alpha, milch);
        ((Mitarbeiter)tom).regalAufFuellen(alpha, kleid);
        anna.regalAufFuellen(alpha, milch);

        // print regal
        alpha.regalAnschauen();

        //Kunden kaufen Produkte (Regale werden leerer)
        Kasse alphaKasse = new Kasse();
        peter.kaufen(alpha, saft); //no saft found in regal

        peter.kaufen(alpha, milch);
        ((Kassierer) tom).kassieren(alphaKasse, milch.getProduktPreis());

        // print regal
        alpha.regalAnschauen();
    }
}
