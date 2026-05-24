/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;

import Interfaces.GestionVehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VehiculoService implements GestionVehiculo {
    private List<Vehiculo> vehiculos;
    private static final String FILE_NAME = "vehiculos.dat";
    private Scanner scanner;

    public VehiculoService() {
        this.vehiculos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        cargarDesdeArchivo();
    }

    @Override
    public void registrarVehiculo() {
        System.out.println("=== Registrar Vehículo ===");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        Vehiculo v = new Vehiculo(placa, marca, modelo);
        vehiculos.add(v);
        guardarEnArchivo();
        System.out.println("Vehículo registrado.");
    }

    @Override
    public void actualizarVehiculo() {
        System.out.print("Ingrese placa: ");
        String placa = scanner.nextLine();
        Vehiculo v = buscarVehiculo(placa);
        if (v != null) {
            System.out.print("Nueva marca (" + v.getMarca() + "): ");
            v.setMarca(scanner.nextLine());
            System.out.print("Nuevo modelo (" + v.getModelo() + "): ");
            v.setModelo(scanner.nextLine());
            guardarEnArchivo();
            System.out.println("Vehículo actualizado.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    @Override
    public void eliminarVehiculo() {
        System.out.print("Ingrese placa: ");
        String placa = scanner.nextLine();
        vehiculos.removeIf(v -> v.getPlaca().equals(placa));
        guardarEnArchivo();
        System.out.println("Vehículo eliminado.");
    }

    @Override
    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            vehiculos.forEach(System.out::println);
        }
    }

    private Vehiculo buscarVehiculo(String placa) {
        return vehiculos.stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(vehiculos);
        } catch (IOException e) {
            System.err.println("Error guardando vehículos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarDesdeArchivo() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            vehiculos = (List<Vehiculo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error cargando vehículos: " + e.getMessage());
        }
    }
}

