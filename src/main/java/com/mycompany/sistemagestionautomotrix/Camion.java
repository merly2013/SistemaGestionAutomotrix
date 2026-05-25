package com.mycompany.sistemagestionautomotrix;
// @author Huber Herrera

public class Camion extends Vehiculo {
    
    private int capacidadCarga;


    
    public Camion(String placa, String marca, String modelo, int capacidadCarga) {
        super(placa, marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }



    public int getCapacidadCarga() {
        return capacidadCarga;
    }



    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    

}
