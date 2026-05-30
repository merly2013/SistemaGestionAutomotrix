package Automotriz.modelo;
// @author Huber Herrera

public class Cliente extends Persona {

    private long telefono;
    private String correo;

    public Cliente(String nombre, int id, long telefono, String correo) {
        super(nombre, id);
        this.telefono = telefono;
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString(){
        return "Cliente:" +
            "nombre: " + nombre + '\'' +
            ", id: " + id +
            ", telefono: " + telefono +
            ", correo: " + correo + '\'' +
            ' ';
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
