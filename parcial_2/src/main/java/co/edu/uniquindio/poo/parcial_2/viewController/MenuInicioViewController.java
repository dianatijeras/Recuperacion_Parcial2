package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MenuInicioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_Creacion;

    @FXML
    private Button btn_Dispositivos;

    @FXML
    private Button btn_Monitoreo;

    @FXML
    private Button btn_Productos;

    @FXML
    private Label lbl_bienvenida;

    @FXML
    private Pane pn_menuInicio;

    @FXML
    private Pane pn_menuInicio2;

    @FXML
    void onClick_Creacion(ActionEvent event) {

    }

    @FXML
    void onClick_Dispositivos(ActionEvent event) {

    }

    @FXML
    void onClick_Monitoreo(ActionEvent event) {

    }

    @FXML
    void onClick_Productos(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btn_Creacion != null : "fx:id=\"btn_Creacion\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert btn_Dispositivos != null : "fx:id=\"btn_Dispositivos\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert btn_Monitoreo != null : "fx:id=\"btn_Monitoreo\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert btn_Productos != null : "fx:id=\"btn_Productos\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert lbl_bienvenida != null : "fx:id=\"lbl_bienvenida\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert pn_menuInicio != null : "fx:id=\"pn_menuInicio\" was not injected: check your FXML file 'menuInicio.fxml'.";
        assert pn_menuInicio2 != null : "fx:id=\"pn_menuInicio2\" was not injected: check your FXML file 'menuInicio.fxml'.";

    }

}
