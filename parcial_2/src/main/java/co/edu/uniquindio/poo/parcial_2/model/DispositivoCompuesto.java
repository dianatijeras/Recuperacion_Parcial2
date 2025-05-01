package co.edu.uniquindio.poo.parcial_2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Dispositivo compuesto que puede contener otros dispositivos.
 */
public class DispositivoCompuesto implements Dispositivo, Cloneable {

    private List<Dispositivo> hijos = new ArrayList<>();
    private String nombre;
    
    public DispositivoCompuesto(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Dispositivo d) {
        hijos.add(d);
    }

    @Override
    public String estado() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCompuesto: " + nombre);
        for (Dispositivo d : hijos) {
            sb.append("\n -> " + d.estado());
        }
        return sb.toString();
    }

    @Override
    public int prioridad() {
        int max = 0;
        for (int i = 0; i < hijos.size(); i++) {
            int p = hijos.get(i).prioridad();
            if (p > max) {
                max = p;
            }
        }
        return max;
    }

    @Override
    public String tipo() {
        return nombre;
    }

    @Override
    public DispositivoCompuesto clone() {
        try {
            return (DispositivoCompuesto) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException("El dispositivo no se puede clonar");
        }
    }

}
