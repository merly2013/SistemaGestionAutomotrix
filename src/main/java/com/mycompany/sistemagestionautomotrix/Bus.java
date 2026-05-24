package com.mycompany.sistemagestionautomotrix;

public class Bus extends Vehiculo {
    
    private int capacidad;

    public Bus(String placa, String marca, String modelo, int capacidad) {
        super(placa, marca, modelo);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    

}
