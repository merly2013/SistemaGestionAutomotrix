
package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

public class CambioDeRepuesto extends Servicio {
    private Repuesto repuesto;
    private Inventario inventario;
    private int garantiaMeses;

    public CambioDeRepuesto(Repuesto repuesto, Inventario inventario, int garantiaMeses, String descripcion, double costo, int duracion) {
        super(descripcion, costo, duracion);
        this.repuesto = repuesto;
        this.inventario = inventario;
        this.garantiaMeses = garantiaMeses;
    }
    
    //getters
    public Repuesto getRepuesto() {return repuesto;}
    public Inventario getInventario() {return inventario;}
    public int getGarantiaMeses() {return garantiaMeses;}
 
    //Metodos
    public void aplicarGarantia(){
        System.out.println("Garantia de " + garantiaMeses + " meses aplicada para: " + repuesto.getNombre()); 
    }
    @Override
    public void ejecutar() {
        if (inventario.verificarStock(repuesto.getId())) {
            inventario.descontarStock(repuesto.getId());
            System.out.println("Cambio de repuesto realizado: " + repuesto.getNombre());
            aplicarGarantia();
        } else {
            System.out.println("No hay stock disponible para: " + repuesto.getNombre());
        }
    }
}
