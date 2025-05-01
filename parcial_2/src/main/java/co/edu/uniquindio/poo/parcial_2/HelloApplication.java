package co.edu.uniquindio.poo.parcial_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TecnoSafe S.A");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}