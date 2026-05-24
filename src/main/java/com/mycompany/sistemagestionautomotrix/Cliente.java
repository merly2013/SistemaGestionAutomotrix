package com.mycompany.sistemagestionautomotrix;
// @author Huber Herrera

public class Cliente extends Persona {

    private int telefono;
    private String correo;

    
    public Cliente(String nombre, int id, int telefono, String correo) {
        super(nombre, id);
        this.telefono = telefono;
        this.correo = correo;
    }


    public int getTelefono() {
        return telefono;
    }


    public String getCorreo() {
        return correo;
    }

    public String toString(){
        return "Cliente:" +
            "nombre: " + nombre + '\'' +
            ", id: " + id +
            ", telefono: " + telefono +
            ", correo: " + correo + '\'' +
            ' ';
    }


    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    



}
