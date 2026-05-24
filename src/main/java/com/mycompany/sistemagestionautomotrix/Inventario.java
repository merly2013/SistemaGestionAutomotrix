/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;

import java.util.ArrayList;

public class Inventario implements GestionRepuesto {

    private ArrayList<Repuesto> repuestos;

    public Inventario() {
        repuestos = new ArrayList<>();
    }

    @Override
    public void crear(Repuesto r) {
        repuestos.add(r);
    }

    @Override
    public Repuesto buscar(String id) {
        for (Repuesto r : repuestos) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void modificar(Repuesto r) {
        for (int i = 0; i < repuestos.size(); i++) {
            if (repuestos.get(i).getId().equals(r.getId())) {
                repuestos.set(i, r);
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        repuestos.removeIf(r -> r.getId().equals(id));
    }

    public boolean verificarStock(String id) {
        Repuesto r = buscar(id);

        if (r != null && r.getCantidad() > 0) {
            return true;
        }

        return false;
    }

    public void descontarStock(String id) {
        Repuesto r = buscar(id);

        if (r != null && r.getCantidad() > 0) {
            r.setCantidad(r.getCantidad() - 1);
        }
    }

    public ArrayList<Repuesto> consultar() {
        return repuestos;
    }
}

