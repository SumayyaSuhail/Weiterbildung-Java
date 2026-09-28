package de.minions.frontend;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * <pre>
 *     Erstellt eine JavaFX Anwendung.
 *
 *     Einbinden einer Bibliothek(jar-Dateien): Setzen des CLASSPATH in Intellij:
 *     File -> Project Structure -> Libraries -> + -> Java -> jars auswählen -> ok
 *
 *     --module-path "C:\Users\sumay\Desktop\Libraries\openjfx-21.0.12_windows-x64_bin-sdk\javafx-sdk-21.0.12\lib" --add-modules javafx.controls,
 *     javafx.media, javafx.web, javafx.fxml
 * </pre>
 */
public class BananaApp extends Application {
    /**
     * Hier werden Attribute initialisiert.
     * Wird vor dem Start aufgerufen
     */
    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start");
        primaryStage.setTitle("Bananaaaaaaaa");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(5);
        root.setHgap(5);
        //root.setGridLinesVisible(true);

        //https://fonts.google.com/
        Label begruessung = new Label("Willkommen bei den Minions");
        begruessung.setStyle("-fx-font-family: \"Rouge Script\", cursive;" +
                "-fx-font-size: 50");
        begruessung.setId("begruessung");
        root.add(begruessung, 0, 0, 5, 1);
        Label schummel = new Label("         ");
        root.add(schummel, 0, 1);

        //Zeile index 1
        Label minion = new Label("Minion");
        TextField minionEingabe = new TextField();
        root.add(minion, 1, 1);
        root.add(minionEingabe, 2, 1);
        minion.setOnMouseEntered(rein -> mausReinBewegt(minion));
        minion.setOnMouseExited(raus -> mausRausBewegt(minion));

        //Zeile index 2
        Label chef = new Label("Chef");
        PasswordField geheimeChefEingabe = new PasswordField();
        root.add(chef, 1, 2);
        root.add(geheimeChefEingabe, 2, 2);

        HBox parentFuerButtons = new HBox(7);
        Button senden = new Button("Senden");
        Button abbrechen = new Button("Abbrechen");
        Button unsinn = new Button("Unsinn machen");
        parentFuerButtons.getChildren().addAll(senden, abbrechen, unsinn);
        root.add(parentFuerButtons, 1, 4, 3, 1);
//        abbrechen.setOnAction(klick -> System.exit(1)); Beendet die Virtuelle Machine: Aufräumarbeiten aus der
//        stop-Methode werden nicht durchgeführt. "Sauberes" Beenden der Anwendung ist meist besser.
        abbrechen.setOnAction(klick -> Platform.exit()); // beendet die Anwendung mit Aufruf der stop-Methode

        Scene firstScene = new Scene(root, 650, 600);
        firstScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Rouge+Script&display=swap");
        firstScene.getStylesheets().add(this.getClass().getResource("/resources/styles/banana.css").toExternalForm());
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }

    private void mausReinBewegt(Label betreten) {
        System.out.println("Maus wurde auf das Land bewegt");
        betreten.setStyle("-fx-text-fill: red");
    }

    private void mausRausBewegt(Label minion){
        System.out.println("Maus raus bewegt");
        minion.setStyle("-fx-text-fill: blue");
    }

    /**
     * Wird automatisch aufgerufen.
     * Alles, was noch geschlossen werden sollte, kann hier geschlossen werden, zb Datenbank-Verbindung
     * Dialoge können aufgemacht werden: Soll wirklich beendet werden oder ähnliche
     */
    @Override
    public void stop() {
        System.out.println("Wird aufgerufen wenn die Anwendung 'sauber' beendet wird.");
        System.out.println("Hier können Aufräumarbeiten gemacht werden.");
    }

    public static void main(String[] args) {
        launch();
    }
}
