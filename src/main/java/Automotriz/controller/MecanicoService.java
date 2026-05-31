package Automotriz.controller;

import Automotriz.modelo.Mecanico;
import Automotriz.modelo.Usuario;
import java.util.ArrayList;

public class MecanicoService implements GestionMecanico {
    private ArrayList<Mecanico> mecanicos;
    private ArrayList<Usuario> usuarios;
    
    public MecanicoService(ArrayList<Usuario> usuarios) {
        this.mecanicos = new ArrayList<>();
        this.usuarios = usuarios;
    }
    
    @Override
    public void crear(Mecanico m) {
        if (m == null) throw new IllegalArgumentException("El mecánico no puede ser null");
        mecanicos.add(m);
        String user = m.getNombre().toLowerCase().replace(" ", "");
        usuarios.add(new Usuario(user, "1234", "MECANICO", m));
    }
    
    @Override
    public Mecanico buscar(int id) {
        for (Mecanico m : mecanicos) {
            if (m.getId() == id) return m;
        }
        return null;
    }
    
    @Override
    public void modificar(Mecanico m) {
        Mecanico encontrado = buscar(m.getId());
        if (encontrado != null) {
            encontrado.setNombre(m.getNombre());
            encontrado.setDisponible(m.isDisponible());
        }
    }
    
    @Override
    public void eliminar(int id) {
        Mecanico m = buscar(id);
        if (m != null) {
            mecanicos.remove(m);
            usuarios.removeIf(u -> u.getMecanico() != null &&
                              u.getMecanico().getId() == id);
        }
    }
    
    public void resetearContrasena(int idMecanico) {
        for (Usuario u : usuarios) {
            if (u.getMecanico() != null && u.getMecanico().getId() == idMecanico) {
                u.cambiarContrasena("1234");
                u.setPrimerLogin(true);
            }
        }
    }

    public ArrayList<Mecanico> getMecanicos() {
   
       return this.mecanicos; 
    }
    
    public ArrayList<Mecanico> consultar() {
        return mecanicos;
    }
}