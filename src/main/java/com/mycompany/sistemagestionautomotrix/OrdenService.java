
package com.mycompany.sistemagestionautomotrix;
// @author Leonarno Rivera

import java.util.ArrayList;

public class OrdenService implements GestionOrden {

    private ArrayList<Orden> ordenes;

    public OrdenService() {
        ordenes = new ArrayList<>();
    }

    @Override
    public void crear(Orden o) {
        ordenes.add(o);
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
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        ordenes.removeIf(o -> o.getId().equals(id));
    }

    public ArrayList<Orden> consultar() {
        return ordenes;
    }
}
