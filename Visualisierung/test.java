package Visualisierung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class test extends Application{
    @Override
    public void start(Stage primaryStage) {
        // Menüleiste erstellen
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("Datei");

        MenuItem newItem = new MenuItem("Neu");
        MenuItem openItem = new MenuItem("Öffnen");
        MenuItem exitItem = new MenuItem("Beenden");

        exitItem.setOnAction(e -> primaryStage.close());


        fileMenu.getItems().addAll(newItem, new SeparatorMenuItem(), openItem, new SeparatorMenuItem(), exitItem);

        // Menü "Bearbeiten"
        Menu editMenu = new Menu("Bearbeiten");
        MenuItem cutItem = new MenuItem("Ausschneiden");
        MenuItem copyItem = new MenuItem("Kopieren");
        MenuItem pasteItem = new MenuItem("Einfügen");
        editMenu.getItems().addAll(cutItem, new SeparatorMenuItem(), copyItem, new SeparatorMenuItem(), pasteItem);

        Menu helpMenu = new Menu("Hilfe");
        MenuItem aboutItem = new MenuItem("Über");
        helpMenu.getItems().add(aboutItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        Scene scene = new Scene(root, 600, 400);

        String css = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("JavaFX Menü Beispiel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
