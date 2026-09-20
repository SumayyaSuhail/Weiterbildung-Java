package de.altesschloss.derpassendeschluessel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Schloss altesSchloss = new Schloss();

        // Original Schlüssel für die EingangsTür (direkt erreichbar)
        SchluesselBart eingangsBart = new SchluesselBart(4, 3);
        Schluessel eingangSchluessel = new Schluessel(8, "Bronze", 30, eingangsBart);

        //Original Schlüssel für eine weitere Tür (unerreichbar)
        SchluesselBart innerBart = new SchluesselBart(5,2);
        Schluessel innerSchluessel = new Schluessel(10, "Eisen", 45, innerBart);

        //Add Türen to Schloss
        Tuer eingangsTuer = new Tuer("EingangsTür", eingangSchluessel);
        Tuer innerTuer = new Tuer("InnerTür", innerSchluessel);
        altesSchloss.tuerHinzufuegen(eingangsTuer);
        altesSchloss.tuerHinzufuegen(innerTuer);

        //Give EingansSchlüssel to John
        Abenteurer john = new Abenteurer("John");
        john.schluesselHinzufuegen(eingangSchluessel);

        //John opens eingangsTür and innerTür
        john.tuerOffnen(eingangsTuer);
        john.tuerOffnen(innerTuer);

    }
}
