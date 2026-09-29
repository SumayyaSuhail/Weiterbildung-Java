package de.tollemarmelade.controller;

import de.tollemarmelade.model.ArbeitsSchritt;
import de.tollemarmelade.model.BesondereZutaten;
import de.tollemarmelade.model.Obst;
import de.tollemarmelade.views.MarmeladeView;

import java.time.LocalDate;

/**
 * Wählt bei Benutzerinteraktion mit dem MarmeladeView die
 * geeignete Reaktion aus.
 */
public class MarmeladeController {
    private final MarmeladeView view;
    /**
     * Um die Auswahlder besonderen Zutaten zu treffen
     */
    private Obst ausgewaehltesObst;

    private ArbeitsSchritt arbeitsSchritt = ArbeitsSchritt.OBST_WAEHLEN;

    /**
     * Wird in App aufgerufen
     * @param view wird in der App injiziert.
     */
    public MarmeladeController(MarmeladeView view) {
        this.view = view;
    }

    public void aktivieren() {
        for (Obst obst: Obst.values()) {
            view.getObstItem(obst).setOnAction(klick -> obstAusgewaehlt(obst));
        }
        view.getKochenButton().setOnAction(klick -> kochen());
        view.getFuellenButton().setOnAction(klick -> fuellen());
        view.getEtikettKleben().setOnAction(klick -> etikettieren());
        view.getZutatenGruppe().selectedToggleProperty().addListener((beobachtet, alt, neu) -> {
            if (arbeitsSchritt == ArbeitsSchritt.OBST_WAEHLEN || arbeitsSchritt == ArbeitsSchritt.KOCHEN) {
                setArbeit(neu == null ? ArbeitsSchritt.OBST_WAEHLEN: ArbeitsSchritt.KOCHEN);
            }
        });
    }

    private void setArbeit(ArbeitsSchritt arbeitsSchritt) {
        this.arbeitsSchritt = arbeitsSchritt;
        view.zeigeArbeitSchritt(arbeitsSchritt);
    }

    private void etikettieren() {
        view.zeigeGlasZu();
        view.zeigeEtikett(ausgewaehltesObst.getAnzeigenName(),
                view.getAusgewaehlteZutat(), LocalDate.now().getYear());
        setArbeit(ArbeitsSchritt.FERTIG);
    }

    private void fuellen() {
        view.zeigeFuellung(ausgewaehltesObst);
        setArbeit(ArbeitsSchritt.ETIKETTIEREN);
    }

    private void kochen() {
        view.zeigeGlasOffen();
        setArbeit(ArbeitsSchritt.FUELLEN);
    }

    private void obstAusgewaehlt(Obst obst) {
        ausgewaehltesObst = obst;
        view.zeigeBesondereZutat(BesondereZutaten.zutatenFuer(obst));
    }
}
