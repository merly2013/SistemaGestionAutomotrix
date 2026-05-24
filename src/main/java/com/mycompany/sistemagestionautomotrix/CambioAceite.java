
package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

public class CambioAceite extends Servicio {
    private String tipoAceite;
    private String viscosidad;
    private double cantidad;
    private String marcaAceite;
    private boolean influyeFiltro;

    public CambioAceite(String tipoAceite, String viscosidad, double cantidad, String marcaAceite, boolean influyeFiltro, String descripcion, double costo, int duracion) {
        super(descripcion, costo, duracion);
        this.tipoAceite = tipoAceite;
        this.viscosidad = viscosidad;
        this.cantidad = cantidad;
        this.marcaAceite = marcaAceite;
        this.influyeFiltro = influyeFiltro;
    }
    
    //getters
    public String getTipoAceite() { return tipoAceite;}
    public String getViscosidad() { return viscosidad; }
    public double getCantidad() { return cantidad;}
    public String getMarcaAceite() { return marcaAceite; }
    public boolean isInfluyeFiltro() { return influyeFiltro; }
    
    //Metodos
    public int recomendarProximoCambio(){
        return 3000; //DEPENDE DEl VEHICULO
    }
    
    @Override
    public void ejecutar() {
        System.out.println("Realizando cambio de aceite: " + tipoAceite
                + ", marca: " + marcaAceite);
    }
}
