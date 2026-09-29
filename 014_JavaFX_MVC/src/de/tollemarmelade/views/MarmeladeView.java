package de.tollemarmelade.views;

import de.tollemarmelade.model.ArbeitsSchritt;
import de.tollemarmelade.model.Obst;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     Stellt vor: BorderPane /ähnlich wie BorderLayout in Swing)
 *                 EnumMap
 *                 MenüToggleGroup (RadioButton)
 *                 StackPane
 *                 ImageView
 *
 * </pre>
 */
public class MarmeladeView {

    private final BorderPane root = new BorderPane();
    /** Eine Map, die als Keys ein enum verwendet */
    private final Map<Obst, MenuItem> obstItems = new EnumMap<>(Obst.class);

    private final Menu obstMenu = new Menu("Obst");
    /** enthält eine Toggle Group mit einer Auswahl von besonderen Zutaten */
    private final VBox zutatenBox = new VBox(10);
    /** Einige Zutaten als Radiobuttons werden organisiert */
    private final ToggleGroup zutatenGruppe = new ToggleGroup();

    /** Demonstrieren, wie das StackPane funktioniert */
    private final Button kochenButton = new Button("Kochen");
    private final Button fuellenButton = new Button("Füllen");
    private final Button etikettKleben = new Button("Etikett Kleben");

    private final StackPane glassBereich = new StackPane();
    /** Im StackPane die unterste Schicht */
    private final ImageView glassAnzeige = new ImageView();
    /** später */
    private final Label status = new Label();

    public MarmeladeView() {
        erstellenTop();
        erstellenLinks();
        erstellenCenter();

        zeigeArbeitSchritt(ArbeitsSchritt.OBST_WAEHLEN);

        root.setRight(zutatenBox);
        zutatenBox.setId("zutatenBereich");

        root.setBottom(status);
        status.setId("status");
    }

    /**
     * Das MarmeladeView soll ein Menu enthalten. Das wird hier erstellt.
     */
    private void erstellenTop() {
        for (Obst obst : Obst.values()) {
            MenuItem eintragInsMenu = new MenuItem(obst.getAnzeigenName());
            obstItems.put(obst, eintragInsMenu);
            obstMenu.getItems().add(eintragInsMenu);
//            obstMenu.getItems().add(new Menu("A"));
        }
        MenuBar leiste = new MenuBar(obstMenu);
        root.setTop(leiste);
    }

    /**
     * In einer VBox werden die Buttons dargestellt, die den Kochablauf ermöglichen
     */
    private void erstellenLinks() {
        VBox aktionenBox = new VBox(10);
        aktionenBox.getChildren().addAll(kochenButton, fuellenButton, etikettKleben);
        root.setLeft(aktionenBox);
    }

    /**
     * Zeigt das Image eines Marmeladenglases an
     */
    private void erstellenCenter() {
        Image glasBild = new Image("file:resources/images/GlasZu.png");
        glassAnzeige.setImage(glasBild);
        glassAnzeige.setFitHeight(300);
        glassAnzeige.setPreserveRatio(true);

        glassBereich.getChildren().add(glassAnzeige);
        root.setCenter(glassBereich);
    }

    // ********** Anzeige ändern ********** //
    /** Wird vom Controller aufgerufen, mit Auswahl der Zutaten */
    public void zeigeBesondereZutat(List<String> zutaten) {
        zutatenGruppe.selectToggle(null);
        zutatenGruppe.getToggles().clear();
        zutatenBox.getChildren().clear();

        for (String zutat: zutaten){
            RadioButton button = new RadioButton(zutat);
            button.setToggleGroup(zutatenGruppe);
            zutatenBox.getChildren().add(button);
        }
    }

    public void zeigeGlasOffen() {
        Image glasBild = new Image("File:resources/images/GlasOffen.png");
        glassAnzeige.setImage(glasBild);
    }

    public void zeigeGlasZu() {
        Image glasBild = new Image("File:resources/images/GlasZu.png");
        glassAnzeige.setImage(glasBild);
    }

    public void zeigeFuellung(Obst obst) {
        Color farbe = switch (obst) {
            case APFEL -> Color.rgb(199,55,65, 0.35);
            case BIRNE -> Color.rgb(125, 165, 65, 0.35);
            case ZITRONE -> Color.rgb(255, 215, 0, 0.35);
        };

        Rectangle fuellung = new Rectangle(170,125, farbe);
        fuellung.setTranslateY(20);
        fuellung.setMouseTransparent(true);
        glassBereich.getChildren().add(fuellung);
    }

    public void zeigeEtikett(String obst, String zutat, int jahr) {
        Label etikett = new Label(obst + "\nmit " + zutat + "\n" + jahr);
        etikett.setId("etikett");
        glassBereich.getChildren().add(etikett);
    }

    public void zeigeArbeitSchritt(ArbeitsSchritt schritt) {
        kochenButton.setDisable(schritt != ArbeitsSchritt.KOCHEN);
        fuellenButton.setDisable(schritt != ArbeitsSchritt.FUELLEN);
        etikettKleben.setDisable(schritt != ArbeitsSchritt.ETIKETTIEREN);
        //TODO Statusanzeige unten erstellen
    }

    public BorderPane getRoot() {
        return root;
    }

    // ********** Zugriffe für Controller ********** //
    public Button getKochenButton() {
        return kochenButton;
    }

    public Button getFuellenButton() {
        return fuellenButton;
    }

    public Button getEtikettKleben() {
        return etikettKleben;
    }

    public ToggleGroup getZutatenGruppe() {
        return zutatenGruppe;
    }

    public MenuItem getObstItem(Obst obst) {
        return obstItems.get(obst);
    }

    public String getAusgewaehlteZutat() {
        RadioButton auswahl = (RadioButton) zutatenGruppe.getSelectedToggle();
        return auswahl.getText();
    }
}
