package de.geldautomat.test;

import de.geldautomat.Automat;
import de.geldautomat.Bank;
import de.geldautomat.Exceptions.*;
import de.geldautomat.Konto;
import de.geldautomat.Kunde;

import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {
        Konto tomsKonto = new Konto("1234-5678", "1234", 500);
        Kunde tom = new Kunde("Tom", tomsKonto);
        Bank bank = new Bank();
        bank.kundeHinzufuegen(tom);

        Automat automat = new Automat(1000); // Automat hat 1000€ Bargeld

        System.out.println("\n********** Willkommen zum ATM in Offenbach!**********");
        System.out.println("Bitte geben Sie ihre Karte ein!");
        warte3Sekunden();
        try {
            bank.findeKundeZuKonto("1234-5678");
        } catch (KarteNichtLesbarException exception) {
            System.out.println("Falsche Karte eingegeben!");
        }

        System.out.println("Ihre KontoNummer: " + tomsKonto.getKontoNummer());
        Scanner scanner = new Scanner(System.in);
        int chance = 3;
        boolean pinKorrekt = false;
        while (chance > 0) {
            System.out.println("Bitte geben Sie Ihre PIN ein: ");
            String pin = scanner.next();
            if (tomsKonto.pinPruefen(pin)) {
                pinKorrekt = true;
                break;
            }
            chance--;
            System.out.println("Falsche PIN. Verbleibende Versuche: " + chance);
        }

        try {
            if (!pinKorrekt) {
                throw new FalschePinException("3x falsche PIN eingegeben. Karte wird eingezogen.");
            }
        } catch (FalschePinException e) {
            System.out.println(e.getMessage());
            return;
        }

        warte3Sekunden();
        System.out.println("Pin richtig eingegeben!");
        System.out.println("\nWie viel Euro möchten Sie abheben?");
        double abhebenBetrag = scanner.nextDouble();
        try {
            automat.betragAuszahlen(abhebenBetrag, tomsKonto);
        } catch (FalscherBetragException | AutomatLeerException | KeineKontoDeckungException exception) {
            System.out.println("Fehler: " + exception.getMessage());
            System.out.println("Bitte nehmen Sie Ihre Karte wieder an sich.");
            return;
        }
        System.out.println("Bitte nehmen Sie Ihre Geld!");
        System.out.println("Bitte nehmen Sie Ihre Karte!");
        System.out.println("Auf wiedersehen!");


    }

    public static void warte3Sekunden() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException exception) {
            System.out.println("Der Wartevorgang wurde unterbrochen.");
        }
    }
}
