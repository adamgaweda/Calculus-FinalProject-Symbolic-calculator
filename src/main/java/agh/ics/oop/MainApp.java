package agh.ics.oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/agh/ics/oop/plot.fxml")
        );
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("MES 1D");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
