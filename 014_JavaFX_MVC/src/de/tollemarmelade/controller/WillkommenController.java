package de.tollemarmelade.controller;

import de.tollemarmelade.MarmeladeApp;
import de.tollemarmelade.views.WillkommenView;

public class WillkommenController {

    private final MarmeladeApp app;
    private final WillkommenView view;

    public WillkommenController(MarmeladeApp app){
        this.app = app;
        view = app.getWillkommenView();
    }

    public void aktivieren() {
        view.getMarmeladeKochenButton().setOnAction(klick -> app.anzeigenMarmelade());
        view.getZumObstgartenButton().setOnAction(klick -> app.baeumeGiessen());
    }
}
