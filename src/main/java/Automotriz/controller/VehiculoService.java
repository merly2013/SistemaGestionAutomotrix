
package Automotriz.controller;
// @author Leonardo Rivera

import Automotriz.modelo.Vehiculo;
import Automotriz.persistencia.ArchivoUtil;
import java.util.ArrayList;

public class VehiculoService implements GestionVehiculo {

    private static final String ARCHIVO = "vehiculos.dat";

    private ArrayList<Vehiculo> vehiculos;

    public VehiculoService() {
        vehiculos = ArchivoUtil.cargarDatos(ARCHIVO);
    }

    @Override
    public void crear(Vehiculo v) {
        vehiculos.add(v);
        ArchivoUtil.guardarDatos(vehiculos, ARCHIVO);
    }

    @Override
    public Vehiculo buscar(String id) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(id)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void modificar(Vehiculo v) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPlaca().equals(v.getPlaca())) {
                vehiculos.set(i, v);

                ArchivoUtil.guardarDatos(vehiculos, ARCHIVO);
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        vehiculos.removeIf(v -> v.getPlaca().equals(id));
        ArchivoUtil.guardarDatos(vehiculos, ARCHIVO);
    }

    public ArrayList<Vehiculo> consultar() {
        return vehiculos;
    }
}