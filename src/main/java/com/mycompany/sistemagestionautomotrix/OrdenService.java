/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrdenService implements GestionOrden {
    private List<Orden> ordenes;
    private static final String FILE_NAME = "ordenes.dat";
    private Scanner scanner;

    public OrdenService() {
        this.ordenes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        cargarDesdeArchivo();
    }

    @Override
    public void crearOrden() {
        System.out.println("=== Crear Orden ===");
        System.out.print("ID Orden: ");
        String id = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        Orden o = new Orden(id, descripcion);
        ordenes.add(o);
        guardarEnArchivo();
        System.out.println("Orden creada.");
    }

    @Override
    public void actualizarOrden() {
        System.out.print("Ingrese ID de la orden: ");
        String id = scanner.nextLine();
        Orden o = buscarOrden(id);
        if (o != null) {
            System.out.print("Nueva descripción (" + o.getDescripcion() + "): ");
            o.setDescripcion(scanner.nextLine());
            guardarEnArchivo();
            System.out.println("Orden actualizada.");
        } else {
            System.out.println("Orden no encontrada.");
        }
    }

    @Override
    public void eliminarOrden() {
        System.out.print("Ingrese ID de la orden: ");
        String id = scanner.nextLine();
        ordenes.removeIf(o -> o.getId().equals(id));
        guardarEnArchivo();
        System.out.println("Orden eliminada.");
    }

    @Override
    public void listarOrdenes() {
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes registradas.");
        } else {
            ordenes.forEach(System.out::println);
        }
    }

    private Orden buscarOrden(String id) {
        return ordenes.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(ordenes);
        } catch (IOException e) {
            System.err.println("Error guardando órdenes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarDesdeArchivo() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ordenes = (List<Orden>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error cargando órdenes: " + e.getMessage());
        }
    }
}

