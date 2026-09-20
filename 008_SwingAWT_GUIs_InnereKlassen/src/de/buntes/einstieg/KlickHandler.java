package de.buntes.einstieg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *     Um "richtig" auf Benutzer Klicks zu reagieren:
 *     1) Erstellen einer Klasse, die das ActionListener Interface implementiert
 *     2) ActionPerformed Methode "sinnvoll" füllen: was soll passieren, wenn geklickt wird.
 *     3) Objekt dieser Klasse erstellen
 *     4) Objekt beim Button registrieren/ in das Array aufgenommen werden mit: addActionListener des Buttons
 *     5) TESTEN!
 *
 *     Ziel: die aktuelle Uhrzeit soll im Uhrzeit Label angezeigt werden.
 *     JLabel hat eine Methode setText (String beschriftung)
 *
 *     ActionListener hat genau eine abstrakte Methode.
 *     Interfaces mit genau einer abstraktion Methode nennt man Funktionale Interfaces
 */
public class KlickHandler implements ActionListener {
    /** Referenz auf das Object aus dem ersten Fenster */
    private  JLabel anzeige;

    public KlickHandler(JLabel anzeige){
        this.anzeige = anzeige;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        LocalTime jetzt = LocalTime.now();
        DateTimeFormatter formatHelfer = DateTimeFormatter.ofPattern("HH:mm:ss");
        String jetztAlsString = jetzt.format(formatHelfer);
        System.out.println(jetztAlsString);
        // return jetztAlsString; nicht möglich: Interface gibt vor, dass der Rückgabetyp void ist
        anzeige.setText(jetztAlsString);
    }
}
