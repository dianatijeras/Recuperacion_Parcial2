package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.parcial_2.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreacionDispositivoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> Cbx_ModulosDispositivos;

    @FXML
    private CheckBox Chbx_DispositivoActivo;

    @FXML
    private CheckBox Chbx_DispositivoInactivo;

    @FXML
    private Button btn_AgregarModuloDispositivo;

    @FXML
    private Button btn_AtrasMenuCreacion;

    @FXML
    private Button btn_CrearDispositivo;

    @FXML
    private Button btn_SalirMenuDispositivo;

    @FXML
    private ComboBox<String> cbx_TipoDispositivo;

    @FXML
    private Pane pn_MenuCrearDispositivo;

    @FXML
    private Pane pn_MenuProducto2;

    @FXML
    private TextField txf_NombreDispositivo;

    @FXML
    private TextField txf_PrioridadDispositivo;

    private Dispositivo dispositivoCreado;

    private ObservableList<String> modulosDisponibles = FXCollections.observableArrayList("Firewall", "Detector de intrusos");

    @FXML
    void onClick_AgregarModulo(ActionEvent event) {
        if (dispositivoCreado == null) {
            mostrarError("Primero debe crear un dispositivo.");
            return;
        }

        String moduloSeleccionado = Cbx_ModulosDispositivos.getValue();

        if (moduloSeleccionado != null) {
            if (moduloSeleccionado.equals("Firewall")) {
                dispositivoCreado = new Firewall(dispositivoCreado);
            } else if (moduloSeleccionado.equals("Detector de Intrusos")) {
                dispositivoCreado = new DetectorIntrusos(dispositivoCreado);
            }
            System.out.println("Dispositivo con módulo: " + dispositivoCreado.estado());
        } else {
            mostrarError("Por favor, seleccione un módulo.");
        }
    }

    @FXML
    void onClick_AtrasMenuCreacion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/parcial_2/creacion.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));

            Stage currentStage = (Stage) btn_AtrasMenuCreacion.getScene().getWindow();
            currentStage.close();

            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClick_CrearDispositivo(ActionEvent event) {
        String nombre = txf_NombreDispositivo.getText();
        int prioridad = Integer.parseInt(txf_PrioridadDispositivo.getText());
        String tipoDispositivo = cbx_TipoDispositivo.getValue();
        boolean activo = Chbx_DispositivoActivo.isSelected();

        if (tipoDispositivo != null) {
            if (tipoDispositivo.equals("Simple")) {
                dispositivoCreado = new DispositivoSimple(nombre, activo, prioridad);
            } else if (tipoDispositivo.equals("Compuesto")) {
                dispositivoCreado = new DispositivoCompuesto(nombre);
            }
            System.out.println("Dispositivo creado: " + dispositivoCreado.estado());
        } else {
            mostrarError("Por favor, seleccione el tipo de dispositivo.");
        }
    }

    @FXML
    void onClick_SalirMenuDispositivo(ActionEvent event) {
        Stage stage = (Stage) btn_SalirMenuDispositivo.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert Cbx_ModulosDispositivos != null : "fx:id=\"Cbx_ModulosDispositivos\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert Chbx_DispositivoActivo != null : "fx:id=\"Chbx_DispositivoActivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert Chbx_DispositivoInactivo != null : "fx:id=\"Chbx_DispositivoInactivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert btn_AgregarModuloDispositivo != null : "fx:id=\"btn_AgregarModuloDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert btn_AtrasMenuCreacion != null : "fx:id=\"btn_AtrasMenuCreacion\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert btn_CrearDispositivo != null : "fx:id=\"btn_CrearDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert btn_SalirMenuDispositivo != null : "fx:id=\"btn_SalirMenuDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert cbx_TipoDispositivo != null : "fx:id=\"cbx_TipoDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert pn_MenuCrearDispositivo != null : "fx:id=\"pn_MenuCrearDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert pn_MenuProducto2 != null : "fx:id=\"pn_MenuProducto2\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert txf_NombreDispositivo != null : "fx:id=\"txf_NombreDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";
        assert txf_PrioridadDispositivo != null : "fx:id=\"txf_PrioridadDispositivo\" was not injected: check your FXML file 'creacionDispositivo.fxml'.";

        cbx_TipoDispositivo.getItems().addAll("Simple", "Compuesto");
        Cbx_ModulosDispositivos.setItems(modulosDisponibles);

    }


    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
