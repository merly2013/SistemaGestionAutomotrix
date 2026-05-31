
package Automotriz.modelo;

// @author Leonardo Rivera

import Automotriz.modelo.Repuesto;
import Automotriz.controller.GestionRepuesto;
import Automotriz.persistencia.ArchivoUtil;
import java.util.ArrayList;

public class Inventario implements GestionRepuesto {

    private static final String ARCHIVO = "repuestos.dat";

    private ArrayList<Repuesto> repuestos;

    public Inventario() {
        repuestos = ArchivoUtil.cargarDatos(ARCHIVO);
    }

    @Override
    public void crear(Repuesto r) {
        repuestos.add(r);
        ArchivoUtil.guardarDatos(repuestos, ARCHIVO);
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
                ArchivoUtil.guardarDatos(repuestos, ARCHIVO);
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        repuestos.removeIf(r -> r.getId().equals(id));
        ArchivoUtil.guardarDatos(repuestos, ARCHIVO);
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
            ArchivoUtil.guardarDatos(repuestos, ARCHIVO);
        }
    }

    public ArrayList<Repuesto> consultar() {
        return repuestos;
    }
}

