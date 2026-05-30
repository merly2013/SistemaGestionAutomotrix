
package Automotriz.controller;
// @author Leonarno Rivera

import Automotriz.modelo.Vehiculo;
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
                break;
            }
        }
    }

    @Override
    public void eliminar(String id) {
        vehiculos.removeIf(v -> v.getPlaca().equals(id));
    }

    public ArrayList<Vehiculo> consultar() {
        return vehiculos;
    }
}
