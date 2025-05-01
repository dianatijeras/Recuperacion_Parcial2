package co.edu.uniquindio.poo.parcial_2.controller;

import co.edu.uniquindio.poo.parcial_2.model.*;
import javafx.scene.control.Alert;

public class CreacionDispositivoController {

    private RegistroGlobal registroGlobal;
    private CentralMonitoreo centralMonitoreo;

    public Dispositivo crearDispositivoSimple(String nombre, int prioridad, boolean activo) {
        Dispositivo dispositivo = new DispositivoSimple(nombre, activo, prioridad);
        return dispositivo;
    }

    public Dispositivo crearDispositivoCompuesto(String nombre) {
        Dispositivo dispositivo = new DispositivoCompuesto(nombre);
        return dispositivo;
    }


    public Dispositivo agregarModulo(Dispositivo dispositivo, String tipoModulo) {
        if (tipoModulo.equals("Firewall")) {
            return new Firewall(dispositivo);
        } else if (tipoModulo.equals("Detector de Intrusos")) {
            return new DetectorIntrusos(dispositivo);
        } else {
            mostrarError("Módulo no válido.");
            return dispositivo;
        }
    }

    public void agregarDispositivoHijo(DispositivoCompuesto dispositivoCompuesto, Dispositivo dispositivoHijo) {
        dispositivoCompuesto.agregar(dispositivoHijo);
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
