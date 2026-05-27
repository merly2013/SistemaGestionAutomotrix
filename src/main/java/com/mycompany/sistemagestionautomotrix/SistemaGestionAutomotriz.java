
package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

public class SistemaGestionAutomotriz {

    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente("Maria Garcia",111, 300120000, "maria@gmail.com");

        // Crear vehículo
        Carro carro = new Carro("ABC123", "Toyota", "Corolla", 4);

        // Crear mecánico
        Mecanico mecanico = new Mecanico("Juan Perez",5,3, true);

        // Crear orden
        Orden orden = new Orden("001", "2026-05-24", "Abierta", cliente, mecanico, carro);

        // Agregar servicios
        orden.agregarServicio(new CambioAceite("Sintetico", "5W30", 4.0, "Mobil", true, "Cambio de aceite", 80000, 60));
        orden.agregarServicio(new RevisionFrenos("Bueno", "Bueno", false, "Revision de frenos", 50000, 30));

        // Calcular total
        System.out.println("Total: $" + orden.calcularTotal());

        // Generar factura
        Factura factura = orden.generarFactura();
        factura.mostrar();
    }
}
