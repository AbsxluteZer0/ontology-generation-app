package ogs.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ogs.ui.controllers.MainController;
import ogs.ui.views.View;

import java.io.IOException;

public class OntologyGenerationApplication extends Application {

    private static String configFilePath;

    public static void run(String[] args) {
        if (configFilePath == null || configFilePath.isBlank())
            throw new IllegalStateException("You must specify config file path before running the app!");
        launch(args);
    }

    public static void setConfigFilePath(String filePath) {
        configFilePath = filePath;
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(View.Main.getFilePath()));
        loader.setControllerFactory(param -> MainController.createInstance(configFilePath));

        Scene scene = new Scene(loader.load());
        scene.getRoot().setStyle("-fx-font-size: 14px;");
        stage.setScene(scene);
        stage.setTitle("Ontology Generation Application");
        stage.show();
    }
}