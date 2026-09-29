package de.tollemarmelade;

import de.tollemarmelade.controller.MarmeladeController;
import de.tollemarmelade.controller.ObstGartenController;
import de.tollemarmelade.controller.WillkommenController;
import de.tollemarmelade.views.MarmeladeView;
import de.tollemarmelade.views.ObstGartenView;
import de.tollemarmelade.views.WillkommenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Die Application incl der start-Methode
 */
public class MarmeladeApp extends Application {
    /** Ausgelagerte Klasse, damit die start-Methode übersichtlich bleibt */
    private WillkommenView willkommenView;
    private MarmeladeView marmeladeView;
    private ObstGartenView obstBaumView;
    /** Attribut, damit in Methoden darauf zugegriffen werden kann */
    private Scene hauptScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        willkommenView = new WillkommenView();
        marmeladeView = new MarmeladeView();
        obstBaumView = new ObstGartenView();

        hauptScene = new Scene(willkommenView.getRoot(), 600,400);
        hauptScene.getStylesheets().add("file:resources/styles/style.css");

        WillkommenController willkommenController = new WillkommenController(this);
        willkommenController.aktivieren();

        ObstGartenController obstGartenController = new ObstGartenController(obstBaumView);
        obstGartenController.aktivieren();

        MarmeladeController marmeladeController = new MarmeladeController(marmeladeView);
        marmeladeController.aktivieren();

        primaryStage.setScene(hauptScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public WillkommenView getWillkommenView() {
        return willkommenView;
    }

    /**
     * Aufgerufen durch den WillkommenController
     */
    public void anzeigenMarmelade() {
        hauptScene.setRoot(marmeladeView.getRoot());
    }

    public void baeumeGiessen() {
        hauptScene.setRoot(obstBaumView.getRoot());
    }
}
