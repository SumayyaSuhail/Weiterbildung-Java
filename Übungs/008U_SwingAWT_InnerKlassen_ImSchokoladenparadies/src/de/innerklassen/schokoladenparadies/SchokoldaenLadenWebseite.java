package de.innerklassen.schokoladenparadies;

public class SchokoldaenLadenWebseite {
    private final String webseiteName = "My Chocolate Factory";
    private Schokoladen_Laden laden;

    public SchokoldaenLadenWebseite(Schokoladen_Laden laden) {
        this.laden = laden;
    }

    public void newsletterAnmeldungMitLokalerKlasse(String name){
        class WebUser implements NewsletterEmpfaenger{

            @Override
            public void newsLetterEmpfangen(String info) {
                System.out.println(name + ": " + info + " - " + webseiteName);
            }

            @Override
            public String getName() {
                return name;
            }
        }
        NewsletterEmpfaenger user = new WebUser();
        laden.addNewsletterEmpfaenger(user);
        System.out.println(name + "hat sich über die Webseite - " + webseiteName + "(Lokale Klasse) angemeldet!");
    }

    public void newsletterAnmeldungMitAnonymeKlasse(String name){
        NewsletterEmpfaenger user = new NewsletterEmpfaenger() {
            @Override
            public void newsLetterEmpfangen(String info) {
                System.out.println(name + ": " + info + " - " + webseiteName);
            }

            @Override
            public String getName() {
                return name;
            }
        };
        laden.addNewsletterEmpfaenger(user);
        System.out.println(name + "hat sich über die Webseite - " + webseiteName + "(Anonyme Klasse) angemeldet!");
    }

    public void zeigNewsletterEmpfaengern(){
        System.out.println("Subscribers: ");
        for (NewsletterEmpfaenger newsletterSubscriber : laden.getNewsletterEmpfaengern()) {
            if (newsletterSubscriber != null) {
                System.out.println(newsletterSubscriber.getName());
            }
        }
    }
    @Override
    public String toString() {
        return "Webseite: " + webseiteName + ", Laden: {" + laden + "}";
    }
}
