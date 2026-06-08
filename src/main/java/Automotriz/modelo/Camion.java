package Automotriz.modelo;
// @author Huber Herrera

public class Camion extends Vehiculo {
    
    private int capacidadCarga;

    public Camion(String placa, String marca, String modelo,int idCliente) {
        super(placa, marca, modelo,idCliente);
    }
    
    public int getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Camión - " + capacidadCarga + "t)";
    }
}
