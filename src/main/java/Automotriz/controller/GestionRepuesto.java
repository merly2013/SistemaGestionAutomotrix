
package Automotriz.controller;
// @author Leonarno Rivera

import Automotriz.modelo.Repuesto;


public interface GestionRepuesto {

    void crear(Repuesto r);

    Repuesto buscar(String id);

    void modificar(Repuesto r);

    void eliminar(String id);
}
