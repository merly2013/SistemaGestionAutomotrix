package com.mycompany.sistemagestionautomotriz;

public interface GestionCliente {
    
    void crear(Cliente cliente);

    Cliente buscar(int id);

    void modificar(Cliente cliente);

    void eliminar(int id);


}
