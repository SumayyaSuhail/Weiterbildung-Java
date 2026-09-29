package de.tollemarmelade.views;

import de.tollemarmelade.model.ObstBaum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.EnumMap;
import java.util.Map;

/**
 * <pre>
 *     Zeigt den Namen des Obstbaums und seinen aktuellen Wasserstand an.
 *     Zeigt einen Button „Gießen“ an.
 *     Erhöht wasserstand wenn das Button ist geklickt
 * </pre>
 */
public class ObstGartenView {

    private final VBox root = new VBox(15);
    private final Map<ObstBaum, Label> wasserStandLabels = new EnumMap<>(ObstBaum.class);
    private final Map<ObstBaum, Button> giessenButtons = new EnumMap<>(ObstBaum.class);

    public ObstGartenView() {
        root.setPadding(new Insets(20));

        for (ObstBaum baum : ObstBaum.values()) {
            Label name = new Label(baum.getAnzeigeName());
            name.setMinWidth(120); // keeps the columns aligned
            Label wasserStand = new Label();
            Button giessenButton = new Button("Gießen");

            HBox zeile = new HBox(15, name, wasserStand, giessenButton);
            zeile.setAlignment(Pos.CENTER_LEFT);
            root.getChildren().add(zeile);

            wasserStandLabels.put(baum, wasserStand);
            giessenButtons.put(baum, giessenButton);

            baeumeAnzeigen(baum);
        }
    }

    /**
     * Zeigt Bäume mit seine Name, WasserStand und GießenButton(wenn das nicht voll ist)
     * @param baum
     */
    public void baeumeAnzeigen(ObstBaum baum) {
        wasserStandLabels.get(baum).setText(
                "Wasserstand: " + baum.getWasserStand());
        giessenButtons.get(baum).setDisable(baum.istVoll());
    }

    public VBox getRoot() {
        return root;
    }

    public Button getGiessenButton(ObstBaum baum) {
        return giessenButtons.get(baum);
    }
}
