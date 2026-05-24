/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;


public interface GestionVehiculo {

    void crear(Vehiculo v);

    Vehiculo buscar(String id);

    void modificar(Vehiculo v);

    void eliminar(String id);
}
