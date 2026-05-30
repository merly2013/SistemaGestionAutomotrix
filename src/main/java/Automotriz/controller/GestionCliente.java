package Automotriz.controller;
// @author Huber Herrera

import Automotriz.modelo.Cliente;

public interface GestionCliente {
    
    void crear(Cliente cliente);

    Cliente buscar(int id);

    void modificar(Cliente cliente);

    void eliminar(int id);


}
