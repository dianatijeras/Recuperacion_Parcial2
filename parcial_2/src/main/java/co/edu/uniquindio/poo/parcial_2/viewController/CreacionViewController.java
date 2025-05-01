package co.edu.uniquindio.poo.parcial_2.viewController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreacionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_AtrasMenuInicio;

    @FXML
    private Button btn_CreacionDispositivo;

    @FXML
    private Button btn_CreacionProducto;

    @FXML
    private Button btn_SalirCreacion;


    @FXML
    private Pane pn_MenuCreacion;

    @FXML
    private Pane pn_MenuCreacion2;


    @FXML
    void onClick_AtrasMenuInicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/menuInicio.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));

            Stage currentStage = (Stage) btn_AtrasMenuInicio.getScene().getWindow();
            currentStage.close();

            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_CreacionDispositivo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("co/edu/uniquindio/poo/parcial_2/creacionDispositivo.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_CreacionProducto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/creacionProducto.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_SalirCreacion(ActionEvent event) {
        Stage stage = (Stage) btn_SalirCreacion.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert btn_AtrasMenuInicio != null : "fx:id=\"btn_AtrasMenuInicio\" was not injected: check your FXML file 'creacion.fxml'.";
        assert btn_CreacionDispositivo != null : "fx:id=\"btn_CreacionDispositivo\" was not injected: check your FXML file 'creacion.fxml'.";
        assert btn_CreacionProducto != null : "fx:id=\"btn_CreacionProducto\" was not injected: check your FXML file 'creacion.fxml'.";
        assert btn_SalirCreacion != null : "fx:id=\"btn_SalirCreacion\" was not injected: check your FXML file 'creacion.fxml'.";
        assert pn_MenuCreacion != null : "fx:id=\"pn_MenuCreacion\" was not injected: check your FXML file 'creacion.fxml'.";
        assert pn_MenuCreacion2 != null : "fx:id=\"pn_MenuCreacion2\" was not injected: check your FXML file 'creacion.fxml'.";

    }
}
