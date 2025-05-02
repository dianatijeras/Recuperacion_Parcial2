package co.edu.uniquindio.poo.parcial_2.model;
/**
 * Implementación básica de dispositivo de seguridad.
 */
public class DispositivoSimple implements Dispositivo, ClonableDispositivoSimple {

    private String nombre;
    private boolean activo;
    private int prioridad;

    public DispositivoSimple(String nombre, boolean activo, int prioridad) {
        this.nombre = nombre;
        this.activo = activo;
        this.prioridad = prioridad;
    }

    @Override
    public String estado() {
        return "[" + nombre + "] Estado: " + (activo ? "Activo" : "Inactivo");
    }

    @Override
    public int prioridad() {
        return prioridad;
    }

    @Override
    public String tipo() {
        return nombre;
    }


    @Override
    public DispositivoSimple clone() {
        try {
            return (DispositivoSimple) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException("El dispositivo no se puede clonar");
        }
    }

}
