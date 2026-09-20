package de.buntes.einstieg;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Demonstriert inner Klasse */
public class ZweitesFenster extends JFrame {

    private JButton klickMich = new JButton("Klick Mich");
    private JLabel uhrZeit = new JLabel("xx:xx:xx");
    private JButton schluss = new JButton("Schluss");
    private JLabel platz = new JLabel("Spater wird es spannend");

    /**
     * <pre>
     *     Es ist möglich eine komplette Klasse(innere Klasse) innerhalb einer "normalen" Klasse (äußere Klasse) zu
     *     erstellen. Das ist ein vollständige Klasse, die erben kann, implementieren kann, Attribute haben kann,
     *     Methoden, Konstruktoren....
     *     Die Innere Klasse hat Zugriff auf die Attribute und Methoden (Member) der äußere Klasse: uhrZeit Label
     * </pre>
     */
    public class InnerKlickHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            LocalTime jetzt = LocalTime.now();
            DateTimeFormatter formatHelfer = DateTimeFormatter.ofPattern("HH:mm:ss");
            String jetztAlsText = jetzt.format(formatHelfer);
            uhrZeit.setText(jetztAlsText);
        }
    }

    public ZweitesFenster(){
        super("Schönes Fenster");
        setSize(350,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(klickMich);
        add(uhrZeit);
        add(schluss);
        add(platz);

        Random wuerfel = new Random();
        int schriftGrosse = wuerfel.nextInt(1,20);
        //Dieser int wird ausgelesen aus eine Quelle und an die Methode weiter gegeben.

        //Kleine Fingerübung: Bei Klicken auf den Schlussbutton soll das Program beendet werden: System.exit(7);
        schluss.addActionListener(event -> System.exit(7));

        verwendenInnerKlickHandler();
        verwendenLocalKlickHandler(schriftGrosse);
        verwendenAnonymerKlickHandler();
        verwendenLambdaKlickHandler();
    }

    /**
     * <pre>
     *     Der ActionListener ist ein besonderes Interface: er hat genau eine abstrakte Methode.
     *     Interfaces, die genau eine abstrakte Methode haben, heißen <b>Funktionale Interfaces</b>
     *     Funktionale Interfaces ermöglichen <b>Lambda</b> Ausdrücke.
     *     Lambda Ausdrücke sind Kurzformen um aus eine Funktionale Interface eine anonyme Klasse incl Objekte
     *     zu erstellen.
     * </pre>
     */
    private void verwendenLambdaKlickHandler() {
        //Version 1 ist nicht möglich, Lambda Ausdrücke erstellen keinen Referenztyp.

        //Version 2
//        ActionListener meinHandler = event -> System.out.println("Es wurde geklickt.");
//        klickMich.addActionListener(meinHandler);

        //Version 3
        klickMich.addActionListener(event -> System.out.println("Es wurde geklickt."));
    }

    /**
     * <pre>
     *     Eine <b>anonyme</b> Klasse wird erstellt: Eine Klasse die keinen Namen hat.
     *     Eine anonyme Klasse erstellt keinen Referenztyp.
     *     Damit ist nur ein einzige Objekt aus dieser Klasse intanzierbar.
     *     Beim erstellen einer anonymen Klasse muss die Elternklasse oder das implementierte Interface
     *     angegeben werden. Direkt beim new Aufruf!
     *     new ActionListener(){}; über {} wird eine neue Klasse erstellt, die das ActionListener Interface implementiert.
     *     new MyClass(){} über {} wird eine neue Klasse erstellt, die von MyClass erbt.
     *     anonyme Klassen werden erstellt, indem der Typ des implementierten Interfaces oder der beerbten Klasse
     *     angegeben wird und dann müssen {} geschweifte Klammern angegeben werden.
     *     Das ist nur direkt im Konstruktoraufruf möglich
     * </pre>
     */
    private void verwendenAnonymerKlickHandler() {
        //Version 1 ist nicht möglich, die Klasse hat keinen Namen, damit keinen Referenztyp

        //version 2
//        ActionListener meinHandler = new ActionListener(){
//            int klickZaehler = 1;
//            public void actionPerformed(ActionEvent event){
//                setTitle("Geklickt: " + klickZaehler);
//                klickZaehler += 1;
//            }
//        };
//        klickMich.addActionListener(meinHandler);

        //Version 3 anonymes Objekt einer anonyme inner Klasse
        klickMich.addActionListener(new ActionListener() {
            int klickZaehler = 1;
            @Override
            public void actionPerformed(ActionEvent event) {
                setTitle("Geklickt: " + klickZaehler);
                klickZaehler += 1;
            }
        });
    }

    /**
     * In der Methode wird lokale innere Klasse erstellt.
     * lokale innere Klassen haben Zugriff auf die Member der äußere Klasse
     * und auf lokale Variablen unter der Voraussetzung, dass sie final oder effective final sind
     * @param schriftGrosse für den ersten Klick
     */
    private void verwendenLocalKlickHandler(final int schriftGrosse) {
        class LocalKlickHandler implements ActionListener {
            int aenderbar = schriftGrosse;
            @Override
            public void actionPerformed(ActionEvent event) {
                Font schriftArt = new Font("Comic Sans MS", Font.BOLD, aenderbar);
                platz.setFont(schriftArt);
                aenderbar += 2;
            }
        }
        //Version 1
//        LocalKlickHandler meinHandler = new LocalKlickHandler();
//        klickMich.addActionListener(meinHandler);

        //Version 2
//        ActionListener meinHandler = new LocalKlickHandler();
//        klickMich.addActionListener(meinHandler);

        //Version 3
        klickMich.addActionListener(new LocalKlickHandler());

    }

    private void verwendenInnerKlickHandler() {
        //Version 1: Referenztyp InnerKlickHandler
//        InnerKlickHandler meinHandler = new InnerKlickHandler();
//        klickMich.addActionListener(meinHandler);

        //Version 2: Referenztyp ActionListener
//        ActionListener meinHandler = new InnerKlickHandler();
//        klickMich.addActionListener(meinHandler);

        //Version 3: Anonymes Object
        klickMich.addActionListener(new InnerKlickHandler());
    }

}
