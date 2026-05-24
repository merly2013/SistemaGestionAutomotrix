package src;

public class Recepsionista extends Persona {
    
    private String turno;

    public Recepsionista(String nombre, int id, String turno) {
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

    

}
