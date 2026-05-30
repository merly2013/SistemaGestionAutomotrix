
package Automotriz.controller;
// @author Leonarno Rivera

import Automotriz.modelo.Vehiculo;


public interface GestionVehiculo {

    void crear(Vehiculo v);

    Vehiculo buscar(String id);

    void modificar(Vehiculo v);

    void eliminar(String id);
}
