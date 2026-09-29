package de.tollemarmelade.controller;

import de.tollemarmelade.MarmeladeApp;
import de.tollemarmelade.model.ObstBaum;
import de.tollemarmelade.views.ObstGartenView;

public class ObstGartenController {

    private final MarmeladeApp app;
    private final ObstGartenView view;

    public ObstGartenController(MarmeladeApp app){
        this.app = app;
        view = app.getObstBaumView();
    }

    public void aktivieren() {
        for (ObstBaum baum : ObstBaum.values()) {
            view.getGiessenButton(baum).setOnAction(klick -> {
                baum.giessen();
                view.baeumeAnzeigen(baum);
            });
        }
    }
}
