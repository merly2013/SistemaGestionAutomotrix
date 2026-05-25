
package com.mycompany.sistemagestionautomotrix;
// @author Leonarno Rivera

public interface GestionVehiculo {

    void crear(Vehiculo v);

    Vehiculo buscar(String id);

    void modificar(Vehiculo v);

    void eliminar(String id);
}
