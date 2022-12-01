package com.mycompany.proyectopollitos;

public class ListaCategorias {

    private Categorias[] Categorias;
    private int CantidadCategorias;

    public ListaCategorias(int CantidadCategorias) {
        this.CantidadCategorias = CantidadCategorias;
        this.Categorias = new Categorias[this.CantidadCategorias];
    }

    public Categorias[] getCategorias() {
        return Categorias;
    }

    public void setCategorias(Categorias[] Categorias) {
        this.Categorias = Categorias;
    }

    public int getCantidadCategorias() {
        return CantidadCategorias;
    }

    public void setCantidadCategorias(int CantidadCategorias) {
        this.CantidadCategorias = CantidadCategorias;
    }

}
