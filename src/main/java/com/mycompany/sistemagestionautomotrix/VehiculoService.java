/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;

import java.util.ArrayList;

public class VehiculoService implements GestionVehiculo {

    private ArrayList<Vehiculo> vehiculos;

    public VehiculoService() {
        vehiculos = new ArrayList<>();
    }

    @Override
    public void crear(Vehiculo v) {
        vehiculos.add(v);
    }

    @Override
    public Vehiculo buscar(String id) {
        for (Vehiculo v : vehiculos) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void modificar(Vehiculo v) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId().equals(v.getId())) {
                vehiculos.set(i, v);
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        vehiculos.removeIf(v -> v.getId().equals(id));
    }

    public ArrayList<Vehiculo> consultar() {
        return vehiculos;
    }
}
