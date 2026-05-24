
package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

public class CambioDeRepuesto extends Servicio {
    private Repuesto repuesto; 
    private int garantiaMeses;
    private Inventario inventario; 

    public CambioDeRepuesto(Repuesto repuesto, int garantiaMeses, Inventario inventario, String descripcion, double costo, int duracion) {
        super(descripcion, costo, duracion);
        this.repuesto = repuesto;
        this.garantiaMeses = garantiaMeses;
        this.inventario = inventario;
    }
 
}
