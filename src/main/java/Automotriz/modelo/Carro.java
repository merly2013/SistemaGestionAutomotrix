package Automotriz.modelo;
// @author Huber Herrera

public class Carro extends Vehiculo {
    
    private int numPuertas;

    public Carro(String placa, String marca, String modelo,int idCliente) {
        super(placa, marca, modelo, idCliente);
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
