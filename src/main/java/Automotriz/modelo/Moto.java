package Automotriz.modelo;
// @author Huber Herrera

public class Moto extends Vehiculo {
    
    private int cilindraje;

    public Moto(String placa, String marca, String modelo,int idCliente) {
        super(placa, marca, modelo,idCliente);
    }

    public int getCilindraje() {return cilindraje;}
    public void setCilindraje(int cilindraje) {this.cilindraje = cilindraje; }
    
    @Override
    public String toString() {
        return super.toString() + " (Moto - " + cilindraje + "cc)";
    }
}
