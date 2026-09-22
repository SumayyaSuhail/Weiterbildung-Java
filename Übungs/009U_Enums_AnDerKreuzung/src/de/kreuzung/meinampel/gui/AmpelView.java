package de.kreuzung.meinampel.gui;

import de.kreuzung.meinampel.farben.AmpelMitKreis;

import javax.swing.*;

public class AmpelView extends JFrame {

    private final AmpelMitGUI steuerung = new AmpelMitGUI();
    private final Licht licht = new Licht(steuerung);

    public AmpelView() {
        super("Die Ampel");

        add(licht);

        setSize(260, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        starteAmpel();
    }

    private void starteAmpel() {
        Thread ampelThread = new Thread(() -> {

            while (true) {
                steuerung.schalten();
                licht.repaint();
            }

        });

        ampelThread.setDaemon(true);
        ampelThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AmpelView::new);
    }
}
