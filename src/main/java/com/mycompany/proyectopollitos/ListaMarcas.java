package com.mycompany.proyectopollitos;

public class ListaMarcas {

    private Marcas[] Marcas;
    private int CantidadMarcas;

    public ListaMarcas(int CantidadMarcas) {
        this.CantidadMarcas = CantidadMarcas;
        this.Marcas = new Marcas[this.CantidadMarcas];
    }

    public Marcas[] getMarcas() {
        return Marcas;
    }

    public void setMarcas(Marcas[] Marcas) {
        this.Marcas = Marcas;
    }

    public int getCantidadMarcas() {
        return CantidadMarcas;
    }

    public void setCantidadMarcas(int CantidadMarcas) {
        this.CantidadMarcas = CantidadMarcas;
    }

}
