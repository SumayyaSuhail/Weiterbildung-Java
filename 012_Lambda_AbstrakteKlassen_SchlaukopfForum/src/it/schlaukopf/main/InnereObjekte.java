package it.schlaukopf.main;


import it.schlaukopf.foren.SchlaukopfForum;
import it.schlaukopf.leute.AstroPhysiker;
import it.schlaukopf.leute.Physiker;
import it.schlaukopf.organisation.Schlaukopf;

/**
 * Übung: Ergänze die vier Methoden.
 * Erstelle jeweils drei unterschiedliche Objekte und registriere
 * jedes mit einem passenden Namen im Forum.
 */
public class InnereObjekte {


    public static void main(String[] args) {
        SchlaukopfForum forum = new SchlaukopfForum();

        erstellenUndRegistrierenVonAstroPhysikern(forum);
        erstellenUndRegistrierenVonPhysikern(forum);
        erstellenUndRegistrierenVonSchlaukoepfen(forum);
        erstellenUndRegistrierenVonSchlaukoepfenAnonym(forum);

    }

    /**
     * 3 Objekte vom Typ AstroPhysiker werden erstellt und beim Forum registiert
     * @param forum das Forum
     */
    private static void erstellenUndRegistrierenVonAstroPhysikern(SchlaukopfForum forum) {
        System.out.println("Objekte vom Typ AstroPhysiker! \n");
        // ***** Object mit Referenztyp AstroPhysiker ***** //
        AstroPhysiker einstein = new AstroPhysiker();
        forum.aufnehmen(einstein, "Albert Einstein");
        System.out.println("Reden: " + einstein.reden());
        System.out.println("Forchen: ");
        einstein.forschen();
        System.out.println("Denken: ");
        einstein.denken();
        System.out.println();

        // ***** Object mit Referenztyp Physiker ***** //
        Physiker hawking = new AstroPhysiker();
        forum.aufnehmen(hawking, "Stephen Hawking");
        System.out.println();

        //***** Objekt mit Referenztyp Schlaukopf ***** //
        Schlaukopf neil = new AstroPhysiker();
        forum.aufnehmen(neil, "Neil deGrasse Tyson");
        System.out.println("\n" + "-".repeat(50));
    }

    /**
     * 3 Objekte von 3 anonymen Klassen, die Physiker erweiterten, werden erstellt und
     * beim Forum registriert
     * @param forum das Forum
     */
    private static void erstellenUndRegistrierenVonPhysikern(SchlaukopfForum forum) {
        System.out.println("Objekte vom Typ Anonymen Klassen, die Physiker erweiterten! \n");
        // var is used to call a method which is extra and not overwritten in the anonym class
        var marie = new Physiker(){

            @Override
            public String reden() {
                return "Man muss nichts im Leben fürchten, man muss es nur verstehen!";
            }
            @Override
            public void forschen() {
                System.out.println("Ich isoliere Radium in meiner alten Holzschuppe!");
            }

            public void treumen() {
                System.out.println("Ich sehe eine Welt, in der Wissenschaft Krankheiten besiegt!");
            }
        };
        forum.aufnehmen(marie, "Marie Curie");
        marie.treumen();
        System.out.println();

        Physiker erwin = new Physiker() {
            @Override
            public void forschen() {
                System.out.println("Ich berechne die Wellenfunktion von kleinsten Teilchen!");
            }
            @Override
            public String reden() {
                return "Die Katze ist gleichzeitig lebendig und tot!";
            }
            @Override
            public void denken(){
                System.out.println("Erst das Messen entscheidet über die Realität.");
            }
        };
        forum.aufnehmen(erwin,"Erwin Schrödinger");
        System.out.println();

        Physiker isaac = new Physiker() {
            @Override
            public void forschen() {
                System.out.println("Ich beobachte fallende Äpfel und berechne die Himmelsmechanik!");
            }
            @Override
            public String reden() {
                return "Wenn ich weiter geblickt habe, so deshalb, weil ich auf den Schultern von Riesen stand!";
            }
        };
        forum.aufnehmen(isaac, "Isaac Newton");
        System.out.println("\n" + "-".repeat(50));
    }

    /**
     * 3 lokale innere Klassen werden erstellt,die das Schlaukopf Interface implementieren.
     * Aus den Klassen werden Objekte erstellt und diese beim Forum registiert
     * @param forum das Forum
     */
    private static void erstellenUndRegistrierenVonSchlaukoepfen(SchlaukopfForum forum) {
        System.out.println("Objekte vom lokalen Innere Klassen, die Schlaukopf Interface implementieren.! \n");
        class InnereKlasse implements Schlaukopf {
            @Override
            public String reden() {
                return "Der Geist ist frei, und das Unmögliche ist nur eine Frage der Zeit!";
            }
            @Override
            public void denken() {
                System.out.println("Alles im Universum ist miteinander verbunden, wir müssen nur genau hinsehen.");
            }

            public void treumen(){
                System.out.println("Ich baue Brücken in die Zukunft, die heute noch niemand für möglich hält!");
            }
        }

        InnereKlasse leonardo = new InnereKlasse();
        leonardo.treumen();
        forum.aufnehmen(leonardo, "Leonardo da Vinci");
        System.out.println();

        Schlaukopf tesla = new InnereKlasse();
        forum.aufnehmen(tesla, "Nikola Tesla");
        System.out.println();

        forum.aufnehmen(new InnereKlasse(), "Johann Wolfgang von Goethe");
        System.out.println("\n" + "-".repeat(50));
    }

    /**
     * 3 Objekte von 3 anonymen Klassen, die das Schlaukopf Interface implementieren, werden
     * erstellt und beim Forum registriert
     * @param forum das Forum
     */
    private static void erstellenUndRegistrierenVonSchlaukoepfenAnonym(SchlaukopfForum forum) {
        System.out.println("Objekte vom Typ Anonymen Klassen, die das Schlaukopf Interface implementieren! \n");
        Schlaukopf thomas = () -> "Ich habe nicht versagt. Ich habe nur 10.000 Wege gefunden, die nicht funktionieren!";
        forum.aufnehmen(thomas, "Thomas Edison");
        System.out.println();

        Schlaukopf ada = new Schlaukopf() {
            @Override
            public String reden() {
                return "Diese Maschine kann mehr als nur rechnen; sie kann Welten erschaffen!";
            }
            @Override
            public void denken(){
                System.out.println("Zahlen und Symbole weben Logik wie ein Webstuhl feine Muster webt.");
            }
        };
        forum.aufnehmen(ada, "Ada Lovelace");
        System.out.println();

        forum.aufnehmen((new Schlaukopf() {
            @Override
            public String reden() {
                return "Alles, was man sich vorstellen kann, ist real!";
            }
            @Override
            public void denken(){
                System.out.println("ch suche nicht, ich finde. Man muss die Regeln brechen, um die Wahrheit zu sehen.");
            }
        }), "Pablo Picasso");
        System.out.println("\n" + "-".repeat(50));
    }

}