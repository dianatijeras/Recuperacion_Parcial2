package co.edu.uniquindio.poo.parcial_2.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

public class DispositivosViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_AtrasMenuInicio;

    @FXML
    private Button btn_BuscarDispositivo;

    @FXML
    private Button btn_SalirDispositivos;

    @FXML
    private ComboBox<String> cbx_CriterioBusqueda;

    @FXML
    private Label lbl_Dispositivos;

    @FXML
    private ListView<Dispositivo> ltView_Dispositivos;

    @FXML
    private Pane pn_Dispositivos;

    @FXML
    private Pane pn_Dispositivos2;
    
    private DispositivoCompuesto dispositivoCompuesto;


    private void inicializarDispositivos() {
        dispositivoCompuesto = new DispositivoCompuesto("Central de monitoreo");

        DispositivoSimple dispositivo1 = new DispositivoSimple("Sensor A", true, 1);
        DispositivoSimple dispositivo2 = new DispositivoSimple("Sensor B", false, 2);
        DispositivoSimple dispositivo3 = new DispositivoSimple("Sensor C", true, 3);

        dispositivoCompuesto.agregar(dispositivo1);
        dispositivoCompuesto.agregar(dispositivo2);
        dispositivoCompuesto.agregar(dispositivo3);

        mostrarDispositivos();
    }

    public void mostrarDispositivos() {
        List<Dispositivo> todosDispositivos = dispositivoCompuesto.getHijos();
        ObservableList<Dispositivo> dispositivosObservable = FXCollections.observableArrayList(todosDispositivos);
        ltView_Dispositivos.setItems(dispositivosObservable);
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
    void onClick_BuscarDispositivo(ActionEvent event) {
        if (dispositivoCompuesto == null) {
            mostrarMensaje("No se ha configurado la raíz de dispositivos.");
            return;
        }

        String criterio = cbx_CriterioBusqueda.getValue();
        if (criterio == null) {
            mostrarMensaje("Por favor selecciona un criterio.");
            return;
        }

        List<Dispositivo> dispositivos = obtenerTodosLosDispositivos();
        List<Dispositivo> filtrados = new ArrayList<>();

        switch (criterio) {
            case "Dispositivos activos":
                for (Dispositivo d : dispositivos) {
                    if (d.estado().contains("Activo")) {
                        filtrados.add(d);
                    }
                }
                break;

            case "Prioridad":
                filtrados = new ArrayList<>(dispositivos);
                filtrados.sort(Comparator.comparingInt(Dispositivo::prioridad).reversed());
                break;

            case "Módulos especiales":
                for (Dispositivo d : dispositivos) {
                    if (d instanceof ModuloDecorator) {
                        filtrados.add(d);
                    }
                }
                break;

            case "Estructura de seguridad":
                mostrarEstructura(dispositivos);
                return;
        }

        actualizarListaDispositivos(filtrados);
    }

    @FXML
    void onClick_SalirDispositivos(ActionEvent event) {
        Stage stage = (Stage) btn_SalirDispositivos.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert btn_AtrasMenuInicio != null : "fx:id=\"btn_AtrasMenuInicio\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert btn_BuscarDispositivo != null : "fx:id=\"btn_BuscarDispositivo\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert btn_SalirDispositivos != null : "fx:id=\"btn_SalirDispositivos\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert cbx_CriterioBusqueda != null : "fx:id=\"cbx_CriterioBusqueda\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert lbl_Dispositivos != null : "fx:id=\"lbl_Dispositivos\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert ltView_Dispositivos != null : "fx:id=\"ltView_Dispositivos\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert pn_Dispositivos != null : "fx:id=\"pn_Dispositivos\" was not injected: check your FXML file 'dispositivos.fxml'.";
        assert pn_Dispositivos2 != null : "fx:id=\"pn_Dispositivos2\" was not injected: check your FXML file 'dispositivos.fxml'.";

        inicializarDispositivos();

        cbx_CriterioBusqueda.getItems().addAll(
                "Dispositivos activos",
                "Prioridad",
                "Módulos especiales",
                "Estructura de seguridad"
        );


        ltView_Dispositivos.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Dispositivo item, boolean empty) {
                super.updateItem(item, empty);
                setText((empty || item == null) ? null : item.toString());
            }
        });
    }

    private void actualizarListaDispositivos(List<Dispositivo> dispositivos) {
        ObservableList<Dispositivo> items = FXCollections.observableArrayList(dispositivos);
        ltView_Dispositivos.setItems(items);
    }

    private List<Dispositivo> obtenerTodosLosDispositivos() {
        if (dispositivoCompuesto != null && dispositivoCompuesto instanceof DispositivoCompuesto) {
            return ((DispositivoCompuesto) dispositivoCompuesto).getHijos();
        }
        return new ArrayList<>();
    }


    private List<String> contarPorTipoComoTexto(List<Dispositivo> dispositivos) {
        List<String> resultado = new ArrayList<>();
        List<String> tiposContados = new ArrayList<>();

        for (int i = 0; i < dispositivos.size(); i++) {
            String tipo = dispositivos.get(i).tipo();
            if (!tiposContados.contains(tipo)) {
                int contador = 1;
                for (int j = i + 1; j < dispositivos.size(); j++) {
                    if (dispositivos.get(j).tipo().equals(tipo)) {
                        contador++;
                    }
                }
                tiposContados.add(tipo);
                resultado.add(tipo + ": " + contador);
            }
        }
        return resultado;
    }

    private void mostrarEstructura(List<Dispositivo> dispositivos) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Estructura de Seguridad");
        alert.setHeaderText(null);

        StringBuilder sb = new StringBuilder();
        dispositivos.stream()
                .map(Dispositivo::tipo)
                .distinct()
                .forEach(tipo -> {
                    long count = dispositivos.stream().filter(d -> d.tipo().equals(tipo)).count();
                    sb.append(tipo).append(": ").append(count).append("\n");
                });

        alert.setContentText(sb.toString());
        alert.showAndWait();
    }


    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

