
package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

import Automotriz.modelo.RevisionFrenos;
import Automotriz.modelo.Usuario;

import Automotriz.modelo.Orden;
import Automotriz.modelo.Mecanico;

import java.util.ArrayList;

import Automotriz.controller.LoginController;
import Automotriz.controller.MecanicoService;
import Automotriz.controller.SistemaController;
import Automotriz.modelo.CambioAceite;
import Automotriz.modelo.Cliente;
import Automotriz.modelo.Factura;
import Automotriz.modelo.Carro;


public class SistemaGestionAutomotriz {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("Maria Garcia",111, 300120000, "maria@gmail.com");

        
        Carro carro = new Carro("ABC123", "Toyota", "Corolla", 4);

       
        Mecanico mecanico = new Mecanico("Juan Perez",5,3, true);

        
        Orden orden = new Orden("001", "2026-05-24", "Abierta", cliente, mecanico, carro);

      
        orden.agregarServicio(new CambioAceite("Sintetico", "5W30", 4.0, "Mobil", true, "Cambio de aceite", 80000, 60));
        orden.agregarServicio(new RevisionFrenos("Bueno", "Bueno", false, "Revision de frenos", 50000, 30));

     
        System.out.println("Total: $" + orden.calcularTotal());

      
        Factura factura = orden.generarFactura();
        factura.mostrar();

        SistemaController sistema = new SistemaController();
    }
}
