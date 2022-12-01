package com.mycompany.proyectopollitos;

public class Producto {

    private String nombre;
    private double precio;
    private int codigo;
    private int cantidad;
    private String marca;
    private String categoria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Producto() {

    }

    public Producto(String nombre, double precio, int codigo, int cantidad, String marca, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.marca = marca;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nombre:" +nombre + " Precio: " + precio + " Codigo: " + codigo + " Cantidad: " + cantidad + " Marca: " + marca + " Categoria: " + categoria;
    }
}
