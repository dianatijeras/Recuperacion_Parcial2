package co.edu.uniquindio.poo.parcial_2.controller;

import co.edu.uniquindio.poo.parcial_2.model.CentralMonitoreo;
import co.edu.uniquindio.poo.parcial_2.model.Dispositivo;
import co.edu.uniquindio.poo.parcial_2.model.DispositivoCompuesto;
import co.edu.uniquindio.poo.parcial_2.model.ModuloDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DispositivosController {

    private CentralMonitoreo centralMonitoreo;
    private DispositivoCompuesto dispositivoCompuesto;

    public DispositivosController(DispositivoCompuesto dispositivoCompuesto) {
        this.centralMonitoreo = centralMonitoreo;
        this.dispositivoCompuesto = dispositivoCompuesto;
    }

    private List<Dispositivo> obtenerTodosLosDispositivos() {
        List<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.addAll(dispositivoCompuesto.getHijos()); // Accedemos directamente
        return dispositivos;
    }

    public List<String> obtenerDispositivosActivos() {
        return obtenerTodosLosDispositivos().stream()
                .map(Dispositivo::estado)
                .collect(Collectors.toList());
    }

    public List<String> obtenerDispositivosPorPrioridad() {
        List<Dispositivo> copia = new ArrayList<>(obtenerTodosLosDispositivos());
        copia.sort((d1, d2) -> Integer.compare(d2.prioridad(), d1.prioridad()));
        return copia.stream()
                .map(Dispositivo::estado)
                .collect(Collectors.toList());
    }

    public List<String> obtenerDispositivosConModulos() {
        return obtenerTodosLosDispositivos().stream()
                .filter(d -> d instanceof ModuloDecorator)
                .map(Dispositivo::estado)
                .collect(Collectors.toList());
    }

    public List<String> obtenerEstructuraSeguridad() {
        List<String> resultado = new ArrayList<>();
        resultado.add(dispositivoCompuesto.estado());
        return resultado;
    }
}
