
package Automotriz.controller;

import Automotriz.modelo.Mecanico;

public interface GestionMecanico {
    void crear(Mecanico m);
    Mecanico buscar(int id);
    void modificar(Mecanico m);
    void eliminar(int id);
}