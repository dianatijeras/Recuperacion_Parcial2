package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CreacionProductoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_AtrasMenuCreacion;

    @FXML
    private Button btn_CrearProducto;

    @FXML
    private Button btn_SalirMenuProducto;

    @FXML
    private Pane pn_MenuCrearProducto;

    @FXML
    private Pane pn_MenuProducto2;

    @FXML
    private TextField txf_ComponenteProducto;

    @FXML
    private TextField txf_NombreProducto;

    @FXML
    private TextField txf_PrecioProducto;

    @FXML
    void onClick_AtrasMenuCreacion(ActionEvent event) {

    }

    @FXML
    void onClick_CrearProducto(ActionEvent event) {

    }

    @FXML
    void onClick_SalirMenuProducto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btn_AtrasMenuCreacion != null : "fx:id=\"btn_AtrasMenuCreacion\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert btn_CrearProducto != null : "fx:id=\"btn_CrearProducto\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert btn_SalirMenuProducto != null : "fx:id=\"btn_SalirMenuProducto\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert pn_MenuCrearProducto != null : "fx:id=\"pn_MenuCrearProducto\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert pn_MenuProducto2 != null : "fx:id=\"pn_MenuProducto2\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert txf_ComponenteProducto != null : "fx:id=\"txf_ComponenteProducto\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert txf_NombreProducto != null : "fx:id=\"txf_NombreProducto\" was not injected: check your FXML file 'creacionProducto.fxml'.";
        assert txf_PrecioProducto != null : "fx:id=\"txf_PrecioProducto\" was not injected: check your FXML file 'creacionProducto.fxml'.";

    }

}

