package com.mycompany.sistemagestionautomotrix;

public class Recepcionista extends Persona {
    
    private String turno;

    public Recepcionista(String nombre, int id, String turno) {
        super(nombre, id);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public String toString() {
    return "Recepcionista: " +
            "nombre: '" + nombre + '\'' +
            ", id: " + id +
            ", turno: '" + turno + '\'' +
            ' ';
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void registrarOrden(Orden o){
        
        System.out.println("La recepcionista " + nombre + " ha registrado la orden.");

    }
}
