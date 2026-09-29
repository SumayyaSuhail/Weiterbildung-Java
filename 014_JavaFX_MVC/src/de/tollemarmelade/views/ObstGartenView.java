package de.tollemarmelade.views;

import de.tollemarmelade.model.Obst;
import de.tollemarmelade.model.ObstBaum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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

    private final BorderPane root = new BorderPane();
    private final StackPane grafik = new StackPane();

    private final Map<ObstBaum, MenuItem> menuItems = new EnumMap<>(ObstBaum.class);
    private final Menu baumMenu = new Menu("Bäume");

    private final Label name = new Label();
    private final Label wasserStand = new Label();
    private final Button giessenButton = new Button("Gießen");

    public ObstGartenView() {
        for (ObstBaum baum : ObstBaum.values()) {
            MenuItem eintragInsMenu = new MenuItem(baum.getAnzeigeName());
            menuItems.put(baum, eintragInsMenu);
            baumMenu.getItems().add(eintragInsMenu);
        }
        MenuBar leiste = new MenuBar(baumMenu);
        root.setTop(leiste);

        VBox inhalt = new VBox(15, name, wasserStand, grafik, giessenButton);
        inhalt.setPadding(new Insets(20));
        inhalt.setAlignment(Pos.CENTER);
        root.setCenter(inhalt);
    }

    /**
     * Create a new stack pane each time and displays the number of fruits based on the wasserstand
     * @param baum the tree which is to be displayed
     * @return the current tree
     */
    private Pane erzeugeBaumGrafik(ObstBaum baum) {
        StackPane baumGrafik = new StackPane();
        baumGrafik.setPrefSize(150, 150);

        Rectangle rectangle = new Rectangle(20, 50);
        rectangle.setFill(Color.SADDLEBROWN);
        StackPane.setAlignment(rectangle, Pos.BOTTOM_CENTER);

        Circle circle = new Circle(60);
        circle.setFill(Color.FORESTGREEN);
        circle.setTranslateY(-20);

        baumGrafik.getChildren().addAll(rectangle, circle);

        // fixed positions within the crown, one per possible fruit
        double[][] positionen = { {-25, -25}, {25, -25}, {0, -55} };
        for (int i = 0; i < baum.getWasserStand(); i++) {
            Circle frucht = new Circle(8, fruchtFarbe(baum));
            frucht.setTranslateX(positionen[i][0]);
            frucht.setTranslateY(positionen[i][1]);
            baumGrafik.getChildren().add(frucht);
        }

        return baumGrafik;
    }
    /**
     * Zeigt Bäume mit seine Name, WasserStand und GießenButton(wenn das nicht voll ist)
     * @param baum
     */
    public void baeumeAnzeigen(ObstBaum baum) {
        name.setText(baum.getAnzeigeName());
        wasserStand.setText("Wasserstand: " + baum.getWasserStand());
        giessenButton.setDisable(baum.istVoll());

        grafik.getChildren().setAll(erzeugeBaumGrafik(baum));
    }

    /** determine the color of the fruit based on the tree*/
    private Color fruchtFarbe(ObstBaum baum) {
        return switch (baum) {
            case APFEL -> Color.RED;
            case BIRNE -> Color.rgb(102, 255, 102);
            case ZITRONE -> Color.YELLOW;
        };
    }

    public MenuItem getMenuItems(ObstBaum baum) {
        return menuItems.get(baum);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getGiessenButton() {
        return giessenButton;
    }
}
