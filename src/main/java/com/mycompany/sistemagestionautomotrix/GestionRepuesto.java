
package com.mycompany.sistemagestionautomotrix;
// @author Leonarno Rivera

public interface GestionRepuesto {

    void crear(Repuesto r);

    Repuesto buscar(String id);

    void modificar(Repuesto r);

    void eliminar(String id);
}
