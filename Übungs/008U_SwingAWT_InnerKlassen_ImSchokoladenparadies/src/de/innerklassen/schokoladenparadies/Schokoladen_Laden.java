package de.innerklassen.schokoladenparadies;

import java.util.Arrays;

public class Schokoladen_Laden {
    private String name;
    private String oeffnungsZeitVon;
    private String oeffnungsZeitBis;
    private NewsletterEmpfaenger[] newsletterEmpfaengern = new NewsletterEmpfaenger[10];
    int anzahl;

    public Schokoladen_Laden(String name, String oeffnungsZeitVon, String oeffnungsZeitBis) {
        this.name = name;
        this.oeffnungsZeitVon = oeffnungsZeitVon;
        this.oeffnungsZeitBis = oeffnungsZeitBis;
        this.anzahl = 0;
    }

    public void addNewsletterEmpfaenger(NewsletterEmpfaenger user) {
        if (anzahl < 10) {
            newsletterEmpfaengern[anzahl] = user;
            anzahl++;
        } else {
            System.out.println("Support soll sich darum kümmern!");
        }
    }

    public void oeffnungszeitAendern(String neueOeffnungszeitVon, String neueOeffnungszeitBis) {
        oeffnungsZeitVon = neueOeffnungszeitVon;
        oeffnungsZeitBis = neueOeffnungszeitBis;

        String info = name + " hat jetzt von " + oeffnungsZeitVon + " bis " + oeffnungsZeitBis + " geöffnet!";
        informiereAlleEmpfaenger(info);
    }

    private void informiereAlleEmpfaenger(String info) {
        for (NewsletterEmpfaenger empfaenger : newsletterEmpfaengern) {
            if (empfaenger != null) { // leere Plätze überspringen
                empfaenger.newsLetterEmpfangen(info);
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ÖffnungsZeitVon: " + oeffnungsZeitVon + ", ÖffnungsZeitBis: " + oeffnungsZeitBis + ", No. of Subscribers: " + anzahl;
    }

    public NewsletterEmpfaenger[] getNewsletterEmpfaengern() {
        return newsletterEmpfaengern;
    }
}
