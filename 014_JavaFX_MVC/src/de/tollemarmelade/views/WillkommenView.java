package de.tollemarmelade.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * <pre>
 *     Zeigt an, was der User beim Aufmachen der Anwendung sieht.
 *     Ermöglicht dann die Auswahl wohin es weiter geht.
 * </pre>
 */
public class WillkommenView {
    /** organisiert die Anzeige von später mehrere Buttons */
    private final VBox root = new VBox(20);
    /** starten den MVC Teil der Anwendung */
    private final Button marmeladeKochenButton = new Button("Marmelade Kochen");
    private final Button zumObstgartenButton = new Button("Zum Obstgarten");

    /** erstellt den root */
    public WillkommenView(){
        Label begruessung = new Label("Willkommen in der Küche");

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(begruessung, marmeladeKochenButton, zumObstgartenButton);
    }

    /** für die Scene */
    public VBox getRoot() {
        return root;
    }

    /** für den Controller */
    public Button getMarmeladeKochenButton() {
        return marmeladeKochenButton;
    }

    public Button getZumObstgartenButton() {
        return zumObstgartenButton;
    }
}
