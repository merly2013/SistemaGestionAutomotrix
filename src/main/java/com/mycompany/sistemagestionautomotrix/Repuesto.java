/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionautomotrix;


import java.io.Serializable;


public class Repuesto implements Serializable {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor 
     
    public Repuesto(String codigo, String nombre, double precio, int stock) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código inválido");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        if (precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters con validaciones
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - $" + precio + " | Stock: " + stock;
    }
}

