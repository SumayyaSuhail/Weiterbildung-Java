package de.kreuzung.meinampel.gui;

public class AmpelMitGUI {

    private AmpelPhase zustand = AmpelPhase.GRUEN;


    public void schalten() {
        try {
            Thread.sleep(1000L * zustand.getDauer());
            //Unterbricht den aktuellen Anlauf fuer eine Anzahl von Millisekunden
        } catch (InterruptedException unterbrechung) {
        }
        zustand = AmpelPhase.values()[(zustand.ordinal() + 1) % AmpelPhase.values().length];
    }

    public AmpelPhase getZustand() {
        return zustand;
    }
}