package de.tollemarmelade.controller;

import de.tollemarmelade.MarmeladeApp;
import de.tollemarmelade.model.ObstBaum;
import de.tollemarmelade.views.ObstGartenView;

public class ObstGartenController {

    private final ObstGartenView view;
    private ObstBaum aktuellerBaum = ObstBaum.APFEL;

    public ObstGartenController(ObstGartenView view) {
        this.view = view;
    }

    /** The tree is displayed based on the tree selected from the Menu **/
    public void aktivieren() {
        for (ObstBaum baum : ObstBaum.values()) {
            view.getMenuItems(baum).setOnAction(klick -> {
                aktuellerBaum = baum;
                view.baeumeAnzeigen(aktuellerBaum);
            });
        }
        view.getGiessenButton().setOnAction(klick -> {
            aktuellerBaum.giessen();
            view.baeumeAnzeigen(aktuellerBaum);
        });
        view.baeumeAnzeigen(aktuellerBaum);
    }
}
