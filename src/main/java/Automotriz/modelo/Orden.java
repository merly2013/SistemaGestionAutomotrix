
package Automotriz.modelo;
// @author Merlin landero
import Automotriz.modelo.Mecanico;
import Automotriz.modelo.Cliente;
import Automotriz.modelo.Factura;
import java.util.ArrayList;
import java.io.Serializable;

public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String fecha;
    private String estado;
    private ArrayList<Servicio> servicios;
    private Cliente cliente;
    private Mecanico mecanico;
    private Vehiculo vehiculo;

   
    public Orden(String id, String fecha, String estado, Cliente cliente, Mecanico mecanico, Vehiculo vehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.vehiculo = vehiculo;
        this.servicios = new ArrayList<>();
    }

    
    //getter
    public String getId() {return id;}
    public String getFecha() {return fecha;}
    public String getEstado() {return estado;}
    public Cliente getCliente() {return cliente;}
    public Mecanico getMecanico() {return mecanico;}
    public Vehiculo getVehiculo() {return vehiculo;}
    public ArrayList<Servicio> getServicios() {return servicios;}

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //metodos
    public void agregarServicio(Servicio s){
        
        if (s != null) {
            servicios.add(s);
        }
    }

    public double calcularTotal() {
        double total = 0;

        for (Servicio s : servicios) {
            total += s.getCosto();
        }

        return total;
    }
    
    public Factura generarFactura() {
        return new Factura(this);
    }
}