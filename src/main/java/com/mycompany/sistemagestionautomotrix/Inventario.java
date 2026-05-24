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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Inventario implements Serializable {
    private List<Repuesto> repuestos;
    private static final String FILE_NAME = "inventario.dat";

    public Inventario() {
        this.repuestos = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void agregarRepuesto(Repuesto r) {
        if (buscarRepuesto(r.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe un repuesto con ese código");
        }
        repuestos.add(r);
        guardarEnArchivo();
    }

    public void eliminarRepuesto(String codigo) {
        repuestos.removeIf(r -> r.getCodigo().equals(codigo));
        guardarEnArchivo();
    }

    public Repuesto buscarRepuesto(String codigo) {
        return repuestos.stream()
                .filter(r -> r.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public void actualizarStock(String codigo, int nuevoStock) {
        Repuesto r = buscarRepuesto(codigo);
        if (r != null) {
            r.setStock(nuevoStock);
            guardarEnArchivo();
        }
    }

    public List<Repuesto> listarRepuestos() {
        return repuestos;
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(repuestos);
        } catch (IOException e) {
            System.err.println("Error guardando inventario: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarDesdeArchivo() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            repuestos = (List<Repuesto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error cargando inventario: " + e.getMessage());
        }
    }
}

