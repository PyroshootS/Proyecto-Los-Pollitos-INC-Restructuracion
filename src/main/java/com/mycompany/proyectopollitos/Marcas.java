package com.mycompany.proyectopollitos;

public class Marcas {

    private int idMarca;
    private String Marca;

    public Marcas() {

    }

    public Marcas(int idMarca, String Marca) {
        this.idMarca = idMarca;
        this.Marca = Marca;
    }

    public int GETidMarca() {
        return idMarca;
    }

    public String GETMarca() {
        return Marca;
    }

    public void SETidMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public void SETMarca(String Marca) {
        this.Marca = Marca;
    }

    @Override
    public String toString() {
        return "Marcas{" + "idMarca=" + idMarca + ", Marca=" + Marca + "}";
    }
    
}
