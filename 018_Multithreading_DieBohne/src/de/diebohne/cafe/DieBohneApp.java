package de.diebohne.cafe;

/**
 * <pre>
 *     Organisiert den Ablauf im Café.
 *
 *     Eine Kaffeemaschine soll laufen,
 *     ein Waffeleisen soll laufen,
 *     ein Putzroboter soll laufen, wenn die Kaffeemaschine überläuft.
 *     Musik könnte laufen im Café, eine Eismaschine könnte laufen, ....
 *
 *     "Gleichzeitig" sollen die verschieden Objekte arbeiten, die Kaffeemaschine, das Waffeleisen,
 *     der Putzroboter, die Musik, die Eismaschine....
 *
 *     Gleichzeitig kann nur über Objekte der Klasse Thread erreicht werden.
 *     Thread-Objekte können ihren eigenen Ablauf bekommen.
 *
 *     mit thread.start(): ein eigener Ablauf wird abgespalten vom bisherigen Thread: main-Thread
 *     start() ruft die run-Methode auf. Diese wird "gleichzeitig" mit den anderen Abläufen
 *     abgearbeitet. Wenn die run-Methode fertig ist, ender der Thread.
 *     Wenn alle gestarteten Threads beendet sind, endet das Programm.
 *
 *     für ein Thread-Objekt wird start() aufgerufen,
 *     dadurch ändert sich der Zustand des Thread-Objekts: neuer Zustand: Runnable.
 *     Der Scheduler des Betriebssystem entscheidet, welcher der vielen Runnable Threads den Zustand ändert: Running
 *     Im Running Zustand wird die run-Methode abgearbeitet.
 *          Entscheidung von Java: der Thread soll nicht weiter laufen: Thread.sleep, yield, wait ....
 *          Entscheidung vom Scheduler: Thread wird in Runnable versetzt.
 *
 *     Ein Thread ist solange "am Leben", bis seine run-Methode fertig abgearbeitet ist.
 * </pre>
 */
public class DieBohneApp {

    public static final String FARBE1 = "\033[0;95m";
    public static final String FARBE2 = "\033[0;96m";
    public static final String GELB = "\033[43m";
    public static final String FARBE4 = "\033[38;5;196m\033[48;5;82m\033[1m";
    public static final String VORSICHT = "\033[0;91m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {
        System.out.println("Willkommen in unserem Café \"Die Bohne\"!\n");

        PutzRoboter cleany = new PutzRoboter();
        cleany.setDaemon(true);
        Kaffeemaschine lebensRetter = new Kaffeemaschine(cleany);
        Waffeleisen sattMacher = new Waffeleisen();

//        lebensRetter.run();
//        sattMacher.run();

        lebensRetter.start();
        sattMacher.start();
        cleany.start();

        while (lebensRetter.isAlive() || sattMacher.isAlive()) {
            //System.out.println(" ");
        }

        System.out.println("\nEs ist Feierabend in \"Die Bohne\", bis bald.");

        Thread aufraeumen = new Thread(() -> {});
        aufraeumen.start();
    }
}
