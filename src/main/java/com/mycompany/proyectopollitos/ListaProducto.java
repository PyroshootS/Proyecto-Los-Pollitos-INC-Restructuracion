package com.mycompany.proyectopollitos;

public class ListaProducto {

    private Producto[] Productos;
    private int CantidadProductos;

    public ListaProducto(int CantidadProductos) {
        this.CantidadProductos = CantidadProductos;
        this.Productos = new Producto[this.CantidadProductos];
    }

    public Producto[] getProductos() {
        return Productos;
    }

    public void setProductos(Producto[] Productos) {
        this.Productos = Productos;
    }

    public int getCantidadProductos() {
        return CantidadProductos;
    }

    public void setCantidadProductos(int CantidadProductos) {
        this.CantidadProductos = CantidadProductos;
    }

}
