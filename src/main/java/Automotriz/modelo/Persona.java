package Automotriz.modelo;
// @author Huber Herrera
import java.io.Serializable;

public abstract class Persona implements Serializable {

private static final long serialVersionUID = 1L;
protected String nombre;
protected int id;


public Persona(String nombre, int id) {
    this.nombre = nombre;
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public int getId() {
    return id;
}

@Override
public String toString(){
        return "Persona: " +
            "nombre: '" + nombre + '\'' +
            ", id: " + id +
            ' ';
    } 

}