package de.mygarten.faehigkeit;

public class Main {
    public static void main(String[] args) {
        //1. Erstelle ein Objekt der Klasse, die die Graber-Vorstellung ermöglicht
        GraberManager manager = new GraberManager();

        //2. Erstelle ein Objekt der konkreten Klasse und registriere es bei der Vorstellungsklasse
        MiniBagger miniBagger = new MiniBagger();
        manager.registrieren(miniBagger);

        //3. Erstelle ein Objekt einer anonymen Klasse, die die abstrakte Klasse erweitert und
        //registriere es bei der Vorstellungsklasse
        Bagger myBagger = new Bagger() {
            @Override
            public String zeitAngeben() {
                return "Dieser Spezial-Bagger braucht" + stundenProEinsatz + " Stunden.";
            }
        };
        manager.registrieren(myBagger);

        //4. Erstelle ein Objekt einer lokalen inneren Klasse, die das Graber Interface
        //implementiert und registriere es bei der Vorstellungsklasse
        class LokaleKlassen implements Graber {
            @Override
            public String graben(int flaecheGroesse) {
                return "Der lokale Gräber gräbt 40 Quadratmeter um, fordert dafür aber eine Extra-Pause.";
            }
        }
        Graber myLokalerGraber = new LokaleKlassen();
        manager.registrieren(myLokalerGraber);

        //5. Erstelle ein Objekt einer anonymen Klasse, die das Graber Interface
        //implementiert und registriere es bei der Vorstellungsklasse
        Graber graber = new Graber() {
            @Override
            public String graben(int flaecheGroesse) {
                return "Ein anonymer Gräber gräbt 35 Quadratmeter um und fordert festen Boden.";
            }
        };
        manager.registrieren(graber);

        //6. Erstelle ein weiteres Objekt einer anonymen Klasse, die das Graber Interface
        //implementiert und registriere es bei der Vorstellungsklasse
        Graber myGraber =  flaecheGroesse -> "Noch ein anonymer Gräber meldet sich: 45 Quadratmeter, aber nur bei Sonnenschein!";
        manager.registrieren(myGraber);

        //7. Erstelle ein Objekt über einen Lambda Ausdruck.
        manager.registrieren((flaescheGroesse) -> "Ein Lambda-Gräber übernimmt 50 Quadratmeter -- ganz ohne Vorbereitung.");

        System.out.println("\n" + "-".repeat(50));
        manager.vorstellen();
        System.out.println("\n" + "-".repeat(50));
        manager.beauftragen();
    }
}
