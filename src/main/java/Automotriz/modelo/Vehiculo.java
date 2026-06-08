package Automotriz.modelo;
// @author Huber Herrera

import java.io.Serializable;

public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int idCliente;
    protected String placa;
    protected String marca;
    protected String modelo;

    public Vehiculo(String placa, String marca, String modelo, int idCliente) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.idCliente= idCliente;
    }
    
   
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public String getPlaca() {return placa;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public void setPlaca(String placa) {this.placa = placa;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    
    @Override
    public String toString() {
        return placa + " - " + marca + " " + modelo;
    }

}