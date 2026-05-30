package Automotriz.modelo;
// @author Huber Herrera

public class Carro extends Vehiculo {
    
    private int numPuertas;

    public Carro(String placa, String marca, String modelo, int numPuertas) {
        super(placa, marca, modelo);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Carro - " + numPuertas + " puertas)";
    }
}
