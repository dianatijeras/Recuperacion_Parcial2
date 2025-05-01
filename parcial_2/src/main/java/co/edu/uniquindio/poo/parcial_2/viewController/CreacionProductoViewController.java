package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.parcial_2.model.Producto;
import co.edu.uniquindio.poo.parcial_2.model.RegistroGlobal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    private RegistroGlobal registroGlobal;

    private Producto producto;


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
    void onClick_CrearProducto(ActionEvent event) {
        String nombre = txf_NombreProducto.getText();
        double precio = Double.parseDouble(txf_PrecioProducto.getText());
        String componente = txf_ComponenteProducto.getText();


        Producto nuevoProducto = new Producto.Builder()
                .setNombre(nombre)
                .setPrecio(precio)
                .addComponente(componente)
                .build();

        if (registroGlobal == null) {
            registroGlobal = RegistroGlobal.getInstancia(); // Inicializamos el registro si no lo estaba
        }
        registroGlobal.agregarProducto(nuevoProducto);


        txf_NombreProducto.clear();
        txf_PrecioProducto.clear();
        txf_ComponenteProducto.clear();

        System.out.println("Producto creado con éxito: " + nuevoProducto.getNombre());
    }

    @FXML
    void onClick_SalirMenuProducto(ActionEvent event) {
        Stage stage = (Stage) btn_SalirMenuProducto.getScene().getWindow();
        stage.close();
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

