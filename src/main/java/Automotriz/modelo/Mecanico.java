package Automotriz.modelo;
// @author Huber Herrera

public class Mecanico extends Persona {
    
    private int maxOrdenes;
    private boolean disponible;

    
    public Mecanico(String nombre, int id, int maxOrdenes, boolean disponible) {
        super(nombre, id);
        this.maxOrdenes = maxOrdenes;
        this.disponible = disponible;
    }

    public int getMaxOrdenes() {
        return maxOrdenes;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //metodos
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String toString() {
    return "Mecanico: " +
            "nombre:'" + nombre + '\'' +
            ", id: " + id +
            ", maxOrdenes: " + maxOrdenes +
            ", disponible: " + disponible +
            ' ';
}
    public void setMaxOrdenes(int maxOrdenes) {
        this.maxOrdenes = maxOrdenes;
    }

}
