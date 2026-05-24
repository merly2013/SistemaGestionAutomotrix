/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;

public interface GestionOrden {

    void crear(Orden o);

    Orden buscar(String id);

    void modificar(Orden o);

    void eliminar(String id);
}