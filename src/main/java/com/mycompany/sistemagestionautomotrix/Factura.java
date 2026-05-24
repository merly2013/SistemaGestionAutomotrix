
package com.mycompany.sistemagestionautomotrix;


public class Factura {
    private String fecha;
    private double total;
    private Orden orden;

    public Factura(String fecha, double total, Orden orden) {
        this.fecha = fecha;
        this.total = total;
        this.orden = orden;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public Orden getOrden() {
        return orden;
    }
    
    
}
