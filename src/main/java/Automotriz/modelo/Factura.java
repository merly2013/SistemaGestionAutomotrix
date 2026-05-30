
package Automotriz.modelo;
// @author Merlin landero


public class Factura {
    private String fecha;
    private Orden orden;
    
    public Factura(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser null");
        }
        if (orden.getCliente() == null) {
            throw new IllegalArgumentException("La orden no tiene cliente");
        }
        if (orden.getVehiculo() == null) {
            throw new IllegalArgumentException("La orden no tiene vehículo");
        }
        if (orden.getMecanico() == null) {
            throw new IllegalArgumentException("La orden no tiene mecánico");
        }
        
        this.orden = orden;
        this.fecha = java.time.LocalDate.now().toString();
    }
    
    // getters
    public String getFecha() { return fecha; }
    public Orden getOrden() { return orden; }
    
    // metodos
    public double calcularTotalPagar() {
        return orden.calcularTotal();
    }
    
    public void mostrar() {
        System.out.println("=== FACTURA ===");
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + orden.getCliente().getNombre());
        System.out.println("Vehiculo: " + orden.getVehiculo().getPlaca());
        System.out.println("Mecanico: " + orden.getMecanico().getNombre());
        System.out.println("Servicios realizados:");
        
        for (Servicio s : orden.getServicios()) {
            System.out.println("  - " + s.getDescripcion() + ": $" + s.getCosto());
        }
        
        System.out.println("Total a pagar: $" + calcularTotalPagar());
        System.out.println("===============");
    }
}
