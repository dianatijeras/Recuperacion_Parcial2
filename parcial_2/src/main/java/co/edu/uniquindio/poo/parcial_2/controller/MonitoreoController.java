package co.edu.uniquindio.poo.parcial_2.controller;

import co.edu.uniquindio.poo.parcial_2.model.Producto;
import co.edu.uniquindio.poo.parcial_2.model.RegistroGlobal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MonitoreoController {

    private RegistroGlobal registroGlobal;

    public MonitoreoController() {
        this.registroGlobal = RegistroGlobal.getInstancia();
    }

    public ObservableList<Producto> obtenerProductosFiltrados(String criterio, String textoBusqueda) {
        ObservableList<Producto> productosFiltrados = FXCollections.observableArrayList();

        ObservableList<Producto> productos = FXCollections.observableArrayList(registroGlobal.getProductos());

        for (Producto producto : productos) {
            switch (criterio.toLowerCase()) {
                case "nombre":
                    if (producto.getNombre().toLowerCase().contains(textoBusqueda.toLowerCase())) {
                        productosFiltrados.add(producto);
                    }
                    break;
                case "precio":
                    try {
                        double precioBusqueda = Double.parseDouble(textoBusqueda.trim());
                        if (producto.getPrecio() == precioBusqueda){
                            productosFiltrados.add(producto);
                        }
                    } catch (NumberFormatException e) {

                    }
                    break;
                case "componente":
                    if (producto.contiene(textoBusqueda)) {
                        productosFiltrados.add(producto);
                    }
                    break;
                default:
                    productosFiltrados.addAll(productos);
            }
        }

        return productosFiltrados;
    }



    public ObservableList<Producto> obtenerTodosLosProductos() {
        return FXCollections.observableArrayList(registroGlobal.getProductos());
    }

}
