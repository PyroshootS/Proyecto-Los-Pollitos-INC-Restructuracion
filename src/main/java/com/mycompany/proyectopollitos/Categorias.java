package com.mycompany.proyectopollitos;

public class Categorias {

    private int idCategoria;
    private String categoria;

    public Categorias() {

    }

    public Categorias(int idCategoria, String categorias) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    public int GETidCategoria() {
        return idCategoria;
    }

    public String GETcategoria() {
        return categoria;
    }

    public void SETidCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void SETcategoria(String categoria) {
        this.categoria = categoria;
    }
}
