package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MonitoreoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_AtrasMenuInicio;

    @FXML
    private Button btn_BuscarProducto;

    @FXML
    private Button btn_Salir;

    @FXML
    private Label lbl_bienvenida;

    @FXML
    private Pane pn_Monitoreo;

    @FXML
    private Pane pn_Monitoreo2;

    @FXML
    private TableColumn<?, ?> tblVw_ComponenteProducto;

    @FXML
    private TableColumn<?, ?> tblVw_NombreProducto;

    @FXML
    private TableColumn<?, ?> tblVw_PrecioProducto;

    @FXML
    private TableView<?> tblVw_TablaProducto;

    @FXML
    private TextField txf_BusquedaProducto;

    @FXML
    void onClick_AtrasMenuInicio(ActionEvent event) {

    }

    @FXML
    void onClick_BuscarProducto(ActionEvent event) {

    }

    @FXML
    void onClick_Salir(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btn_AtrasMenuInicio != null : "fx:id=\"btn_AtrasMenuInicio\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert btn_BuscarProducto != null : "fx:id=\"btn_BuscarProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert btn_Salir != null : "fx:id=\"btn_Salir\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert lbl_bienvenida != null : "fx:id=\"lbl_bienvenida\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert pn_Monitoreo != null : "fx:id=\"pn_Monitoreo\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert pn_Monitoreo2 != null : "fx:id=\"pn_Monitoreo2\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert tblVw_ComponenteProducto != null : "fx:id=\"tblVw_ComponenteProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert tblVw_NombreProducto != null : "fx:id=\"tblVw_NombreProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert tblVw_PrecioProducto != null : "fx:id=\"tblVw_PrecioProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert tblVw_TablaProducto != null : "fx:id=\"tblVw_TablaProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert txf_BusquedaProducto != null : "fx:id=\"txf_BusquedaProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";

    }
}
