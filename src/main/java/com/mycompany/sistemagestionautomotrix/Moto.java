package com.mycompany.sistemagestionautomotrix;
// @author Huber Herrera

public class Moto extends Vehiculo {
    
    private int cilindraje;

    public Moto(String placa, String marca, String modelo, int cilindraje) {
        super(placa, marca, modelo);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    

}
