
package com.mycompany.sistemagestionautomotrix;
// @author Merlin landero

public class RevisionFrenos extends Servicio{
    
    private String estadoPastillas;
    private String estadoDisco;
    private boolean requiereCambio;

    public RevisionFrenos(String estadoPastillas, String estadoDisco, boolean requiereCambio, String descripcion, double costo, int duracion) {
        super(descripcion, costo, duracion);
        this.estadoPastillas = estadoPastillas;
        this.estadoDisco = estadoDisco;
        this.requiereCambio = requiereCambio;
    }
    
    //getters
    public String getEstadoPastillas() {return estadoPastillas;}
    public String getEstadoDisco() {return estadoDisco;}
    public boolean isRequiereCambio() {return requiereCambio;}
    
    //Metodos
    public String diagnosticar() {
        return "Pastillas: " + estadoPastillas + " | Disco: " + estadoDisco;
    }

    public String calcularUrgencia() {
        if (requiereCambio) {
            return "Urgente";
        } else {
            return "No urgente";
        }
    }

    public String generarReporte() {
        return "Estado pastillas: " + estadoPastillas
                + "\nEstado disco: " + estadoDisco
                + "\nRequiere cambio: " + requiereCambio
                + "\nUrgencia: " + calcularUrgencia();
    }

    @Override
    public void ejecutar() {
        System.out.println("Revisando frenos del vehículo");
        System.out.println(diagnosticar());
        System.out.println(generarReporte());
    }
}
