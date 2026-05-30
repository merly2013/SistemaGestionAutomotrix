
package Automotriz.controller;
// @author Leonarno Rivera

import Automotriz.modelo.Orden;


public interface GestionOrden {

    void crear(Orden o);

    Orden buscar(String id);

    void modificar(Orden o);

    void eliminar(String id);
}