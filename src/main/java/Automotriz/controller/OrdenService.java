
package Automotriz.controller;
// @author Leonardo Rivera

import Automotriz.modelo.Orden;
import Automotriz.persistencia.ArchivoUtil;
import java.util.ArrayList;

public class OrdenService implements GestionOrden {

    private static final String ARCHIVO = "ordenes.dat";

    private ArrayList<Orden> ordenes;

    public OrdenService() {
        ordenes = ArchivoUtil.cargarDatos(ARCHIVO);
    }

    @Override
    public void crear(Orden o) {
        ordenes.add(o);
        ArchivoUtil.guardarDatos(ordenes, ARCHIVO);
    }

    @Override
    public Orden buscar(String id) {
        for (Orden o : ordenes) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void modificar(Orden o) {
        for (int i = 0; i < ordenes.size(); i++) {
            if (ordenes.get(i).getId().equals(o.getId())) {
                ordenes.set(i, o);
                ArchivoUtil.guardarDatos(ordenes, ARCHIVO);
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        ordenes.removeIf(o -> o.getId().equals(id));
        ArchivoUtil.guardarDatos(ordenes, ARCHIVO);
    }

    public ArrayList<Orden> consultar() {
        return ordenes;
    }
}
