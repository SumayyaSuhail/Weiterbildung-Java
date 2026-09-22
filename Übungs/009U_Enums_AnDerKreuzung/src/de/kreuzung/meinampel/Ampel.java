package de.kreuzung.meinampel;

/** Class to return the current phase */
public class Ampel {
    private AmpelPhase phaseJetzt;

    public Ampel(AmpelPhase phase){
        this.phaseJetzt = phase;
    }

    public void umschalten(){
        phaseJetzt = phaseJetzt.naechstePhase();
    }

    public AmpelPhase getPhaseJetzt() {
        return phaseJetzt;
    }

    @Override
    public String toString() {
        return "Ampel zeigt aktuell die Phase: " + phaseJetzt;
    }
}
