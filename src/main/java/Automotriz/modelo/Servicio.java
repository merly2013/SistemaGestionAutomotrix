package Automotriz.modelo;
// @author Merlin landero

import java.io.Serializable;

public abstract class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    protected String descripcion;
    protected double costo;
    protected int duracion;

    public Servicio(String descripcion, double costo, int duracion) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.duracion = duracion;
    }
    
    //getters
    public String getDescripcion() { return descripcion; }
    public double getCosto() { return costo; }
    public int getDuracion() { return duracion; }
    
    //Metodo abtracto
    public abstract void ejecutar();
}
