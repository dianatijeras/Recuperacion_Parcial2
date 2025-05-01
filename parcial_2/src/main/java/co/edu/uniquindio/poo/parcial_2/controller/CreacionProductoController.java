package co.edu.uniquindio.poo.parcial_2.controller;

import co.edu.uniquindio.poo.parcial_2.model.Producto;
import co.edu.uniquindio.poo.parcial_2.model.RegistroGlobal;

public class CreacionProductoController {

    private RegistroGlobal registroGlobal;

    public CreacionProductoController(RegistroGlobal registroGlobal){
        this.registroGlobal = registroGlobal;
    }

    public void crearProducto(Producto producto){
        registroGlobal.agregarProducto(producto);
    }
}
