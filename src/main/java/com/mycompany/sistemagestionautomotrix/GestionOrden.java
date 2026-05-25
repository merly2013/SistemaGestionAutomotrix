
package com.mycompany.sistemagestionautomotrix;
// @author Leonarno Rivera

public interface GestionOrden {

    void crear(Orden o);

    Orden buscar(String id);

    void modificar(Orden o);

    void eliminar(String id);
}