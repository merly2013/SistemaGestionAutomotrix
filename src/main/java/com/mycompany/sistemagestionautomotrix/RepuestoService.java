/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;

import java.util.List;
import java.util.Scanner;


 // Servicio para la gestión de repuestos, y persiste datos en Inventario.
 
public class RepuestoService implements GestionRepuesto {
    private Inventario inventario;
    private Scanner scanner;

    public RepuestoService(Inventario inventario) {
        this.inventario = inventario;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void registrarRepuesto() {
        try {
            System.out.println("=== Registrar Repuesto ===");
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Stock inicial: ");
            int stock = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            Repuesto nuevo = new Repuesto(codigo, nombre, precio, stock);
            inventario.agregarRepuesto(nuevo);
            System.out.println("Repuesto registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    @Override
    public void actualizarRepuesto() {
        System.out.println("=== Actualizar Repuesto ===");
        System.out.print("Ingrese código del repuesto: ");
        String codigo = scanner.nextLine();

        Repuesto r = inventario.buscarRepuesto(codigo);
        if (r != null) {
            try {
                System.out.print("Nuevo nombre (" + r.getNombre() + "): ");
                String nombre = scanner.nextLine();
                System.out.print("Nuevo precio (" + r.getPrecio() + "): ");
                double precio = scanner.nextDouble();
                System.out.print("Nuevo stock (" + r.getStock() + "): ");
                int stock = scanner.nextInt();
                scanner.nextLine();

                r.setNombre(nombre);
                r.setPrecio(precio);
                r.setStock(stock);
                System.out.println("Repuesto actualizado correctamente.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        } else {
            System.out.println("Repuesto no encontrado.");
        }
    }

    @Override
    public void eliminarRepuesto() {
        System.out.println("=== Eliminar Repuesto ===");
        System.out.print("Ingrese código del repuesto: ");
        String codigo = scanner.nextLine();

        Repuesto r = inventario.buscarRepuesto(codigo);
        if (r != null) {
            inventario.eliminarRepuesto(codigo);
            System.out.println("Repuesto eliminado.");
        } else {
            System.out.println("Repuesto no encontrado.");
        }
    }

    @Override
    public void listarRepuestos() {
        System.out.println("=== Listado de Repuestos ===");
        List<Repuesto> lista = inventario.listarRepuestos();
        if (lista.isEmpty()) {
            System.out.println("No hay repuestos registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }
}

