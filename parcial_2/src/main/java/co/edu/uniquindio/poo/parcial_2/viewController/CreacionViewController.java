package co.edu.uniquindio.poo.parcial_2.viewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;

public class CreacionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_CreacionDispositivo;

    @FXML
    private Button btn_CreacionProducto;

    @FXML
    private Label lbl_Creacion;

    @FXML
    private Pane pn_MenuCreacion;

    @FXML
    private Pane pn_MenuCreacion2;

    @FXML
    private Separator sp_MenuCreacion;

    @FXML
    void onClick_CreacionDispositivo(ActionEvent event) {

    }

    @FXML
    void onClick_CreacionProducto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btn_CreacionDispositivo != null : "fx:id=\"btn_CreacionDispositivo\" was not injected: check your FXML file 'creacion.fxml'.";
        assert btn_CreacionProducto != null : "fx:id=\"btn_CreacionProducto\" was not injected: check your FXML file 'creacion.fxml'.";
        assert lbl_Creacion != null : "fx:id=\"lbl_Creacion\" was not injected: check your FXML file 'creacion.fxml'.";
        assert pn_MenuCreacion != null : "fx:id=\"pn_MenuCreacion\" was not injected: check your FXML file 'creacion.fxml'.";
        assert pn_MenuCreacion2 != null : "fx:id=\"pn_MenuCreacion2\" was not injected: check your FXML file 'creacion.fxml'.";
        assert sp_MenuCreacion != null : "fx:id=\"sp_MenuCreacion\" was not injected: check your FXML file 'creacion.fxml'.";

    }


}
