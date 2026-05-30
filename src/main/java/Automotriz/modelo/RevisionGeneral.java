
package Automotriz.modelo;
// @author Merlin landero


public class RevisionGeneral extends Servicio{
    private boolean checklistCompleto;
    private String observacion;

    public RevisionGeneral(boolean checklistCompleto, String observacion, String descripcion, double costo, int duracion) {
        super(descripcion, costo, duracion);
        this.checklistCompleto = checklistCompleto;
        this.observacion = observacion;
    }
    
    //getters
    public boolean isChecklistCompleto() {return checklistCompleto;}
    public String getObservacion() {return observacion;}
    
    //Metodos
    public void realizarChecklist() {
        checklistCompleto = true;
        System.out.println("Checklist completado correctamente");
    }

    public String generarInforme() {
        return "=== INFORME REVISIÓN GENERAL ===" +
               "\nChecklist completo: " + checklistCompleto +
               "\nObservaciones: " + observacion;
    }

    @Override
    public void ejecutar() {
        realizarChecklist();
        System.out.println("Revisión general completada");
        System.out.println(generarInforme());
    }
}
