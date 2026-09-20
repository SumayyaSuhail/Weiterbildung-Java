package de.buntes.einstieg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
// * ist Platzhalter für alle Klassen in diesem Package

/**
 * <pre>
 *     Demonstriert die Verwendung von inneren Klassen.
 *
 *     Dazu werden Klassen Swing und AWT verwendet.
 *
 *     Hier wird die Klasse JFrame (Fenster in Swing) erweitert.
 *     (In vielen Beispielen wird ein Object der Klasse JFrame erstellt und angepasst,
 *     Hier IS-A-Beziehung, oft HAS-A-Beziehung)
 * </pre>
 */
public class ErstesFenster extends JFrame{
    /**
     * <pre>
     *     Demonstriert die Interaktion mit dem Benutzer: der User klickt....
     *     Hier wird ein <b>Ereignis</b> ausgelöst
     *
     *     JButton enthält ein Array von Objekte, die sich für das Klick Ereignis interessieren.
     *     Wenn der Button geklickt wird, erstellt er ein Ereignis-Objekte (new ActionEvent(....))
     *     Dann durchläuft er das Array in einer Schleife und ruft von allen Objekte im Array die
     *          <b>actionPerformed</b> Methode auf und übergibt als Parameter das ActionEvent Objekt.
     *     Jedes Objekt im Array reagiert anders innerhalb der ActionPerformed Methode
     *     Jedes Objekt im Array implementiert das ActionListener Interface
     *
     *     Um "richtig" auf Benutzer Klicks zu reagieren:
     *     1) Erstellen einer Klasse, die das ActionListener Interface implementiert
     *     2) ActionPerformed Methode "sinnvoll" füllen: was soll passieren, wenn geklickt wird.
     *     3) Objekt dieser Klasse erstellen
     *     4) Objekt beim Button registrieren/ in das Array aufgenommen werden mit: addActionListener des Buttons
     *     5) TESTEN!
     * </pre>
     */
    private JButton klickMich = new JButton("Klick Mich");
    /**
     * zeigt die aktuelle Uhrzeit beim Klicken auf den KlickMich Button sekundengenau an.
     */
    private JLabel uhrZeit = new JLabel("xx:xx:xx");
    /**
     * bei Klicken auf diesen Button wird die Anwendung beendet.
     * Methode zum Beenden der Anwendung: System.exit(0);
     */
    private JButton schluss = new JButton("Schluss");
    /**
     * Platz für Experimente
     */
    private JLabel platz = new JLabel("Spater wird es spannend");

    /**
     * Konfiguriert das Fenster
     * super("Schönes Fenster") liegt den Titel des Fensters fest
     *
     * Komponenten müssen im Fenster angeordnet werden: LayoutManager erledigen das.
     * LayoutManager legt fest, wo eine Komponente angezeigt wird und wie groß sie angezeigt wird.
     * Hier: FlowLayout (Weiter Layouts: übung)
     * setLayout(new FlowLayout()); erstellt ein <i>anonymous</i> Objekt.
     */
    public ErstesFenster(){
        super("Schönes Fenster");
        setSize(350,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(klickMich);
        add(uhrZeit);
        add(schluss);
        add(platz);

        verwendenKlickHandler();
    }

    /**
     * Hilfsmethode zur Organisation des Konstruktors
     *     3) Objekt dieser Klasse erstellen
     *     4) Objekt beim Button registrieren/ in das Array aufgenommen werden mit: addActionListener des Buttons
     *     5) TESTEN!
     */
    private void verwendenKlickHandler() {
        //Version 1: KlickHandler Referenz
//        KlickHandler meinHandler = new KlickHandler();
//        klickMich.addActionListener(meinHandler);

        //Version 2: ActionListener Referenz
//        ActionListener meinHandler = new KlickHandler();
//        klickMich.addActionListener(meinHandler);

        //Version 3: Anonymes Objekt
        klickMich.addActionListener(new KlickHandler(uhrZeit));
    }

}
