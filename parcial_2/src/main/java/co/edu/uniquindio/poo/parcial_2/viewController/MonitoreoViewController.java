package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.parcial_2.controller.MonitoreoController;
import co.edu.uniquindio.poo.parcial_2.model.AnalizadorProductos;
import co.edu.uniquindio.poo.parcial_2.model.Producto;
import co.edu.uniquindio.poo.parcial_2.model.RegistroGlobal;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MonitoreoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_AtrasMenuInicio;

    @FXML
    private Button btn_FiltrarProducto;

    @FXML
    private Button btn_Salir;

    @FXML
    private ComboBox<String> cbx_CriterioBusqueda;

    @FXML
    private Label lbl_bienvenida;

    @FXML
    private ListView<Producto> ltView_Productos;

    @FXML
    private Pane pn_Monitoreo;

    @FXML
    private Pane pn_Monitoreo2;

    @FXML
    private TextField txf_BuscarProducto;

    private AnalizadorProductos analizadorProductos;

    private Producto producto;

    private MonitoreoController monitoreoController = new MonitoreoController();

    private void inicializarProductos() {
        RegistroGlobal registroGlobal = RegistroGlobal.getInstancia();

        registroGlobal.getProductos().clear();

        Producto laptop = new Producto.Builder()
                .setNombre("Laptop Pro")
                .setPrecio(3500000)
                .addComponente("RAM")
                .addComponente("SSD")
                .addComponente("Teclado retroiluminado")
                .build();

        Producto tablet = new Producto.Builder()
                .setNombre("Tablet X")
                .setPrecio(1800000)
                .addComponente("Pantalla táctil")
                .addComponente("WiFi")
                .build();

        registroGlobal.getProductos().add(laptop);
        registroGlobal.getProductos().add(tablet);
    }

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
    void onClick_FiltrarProducto(ActionEvent event) {
        String criterio = cbx_CriterioBusqueda.getValue();
        String valor = txf_BuscarProducto.getText().toLowerCase();
        List<Producto> resultado = null;

        switch (criterio) {
            case "Nombre":
                resultado = AnalizadorProductos.filtrarPorNombre(valor);
                break;
            case "Precio":
                resultado = AnalizadorProductos.ordenarPorPrecio();
                break;
            case "Componente":
                resultado = AnalizadorProductos.filtrarPorComponente(valor);
                break;
        }

        if (resultado != null) {

            ObservableList<Producto> observableResultado = FXCollections.observableArrayList(resultado);
            ltView_Productos.setItems(observableResultado);
        }
    }


    @FXML
    void onClick_Salir(ActionEvent event) {
        Stage stage = (Stage) btn_Salir.getScene().getWindow();
        stage.close();
    }


    @FXML
    void initialize() {
        assert btn_AtrasMenuInicio != null : "fx:id=\"btn_AtrasMenuInicio\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert btn_FiltrarProducto != null : "fx:id=\"btn_FiltrarProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert btn_Salir != null : "fx:id=\"btn_Salir\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert cbx_CriterioBusqueda != null : "fx:id=\"cbx_CriterioBusqueda\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert lbl_bienvenida != null : "fx:id=\"lbl_bienvenida\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert pn_Monitoreo != null : "fx:id=\"pn_Monitoreo\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert pn_Monitoreo2 != null : "fx:id=\"pn_Monitoreo2\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert ltView_Productos != null : "fx:id=\"ltView_Productos\" was not injected: check your FXML file 'monitoreo.fxml'.";
        assert txf_BuscarProducto != null : "fx:id=\"txf_BuscarProducto\" was not injected: check your FXML file 'monitoreo.fxml'.";

        monitoreoController = new MonitoreoController();

        cbx_CriterioBusqueda.getItems().addAll("Nombre", "Precio", "Componente");

        btn_FiltrarProducto.setOnAction(e -> {
            String criterio = cbx_CriterioBusqueda.getValue();
            String texto = txf_BuscarProducto.getText().trim();
            ltView_Productos.setItems(monitoreoController.obtenerProductosFiltrados(criterio, texto));
        });

        inicializarProductos();

    }

}