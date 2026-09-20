package de.innerklassen.schokoladenparadies;

public class Main {
    public static void main(String[] args) {
        Schokoladen_Laden laden = new Schokoladen_Laden("My Chocolate Factory", "9:00", "19:00");
        SchokoldaenLadenWebseite webseite = new SchokoldaenLadenWebseite(laden);


        webseite.newsletterAnmeldungMitLokalerKlasse("Anna");
        webseite.newsletterAnmeldungMitLokalerKlasse("Ben");

        webseite.newsletterAnmeldungMitAnonymeKlasse("John");
        webseite.newsletterAnmeldungMitAnonymeKlasse("Davis");

        System.out.println("\n" + webseite);
        webseite.zeigNewsletterEmpfaengern();
        System.out.println();

        laden.oeffnungszeitAendern("10:00", "20:00");
    }
}
