/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;


public interface GestionRepuesto {

    void crear(Repuesto r);

    Repuesto buscar(String id);

    void modificar(Repuesto r);

    void eliminar(String id);
}
