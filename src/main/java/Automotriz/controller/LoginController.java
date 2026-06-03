package Automotriz.controller;

import Automotriz.modelo.Usuario;
import Automotriz.modelo.Mecanico;
import Automotriz.persistencia.ArchivoUtil;
import java.util.ArrayList;

public class LoginController {
    private static final String ARCHIVO = "usuarios.dat";
    private ArrayList<Usuario> usuarios;
    
    public LoginController() {
        usuarios = ArchivoUtil.cargarDatos(ARCHIVO);
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        if (usuarios.isEmpty()) {
            // recepcionista por defecto
            usuarios.add(new Usuario("admin", "258", "RECEPCIONISTA", null));
            ArchivoUtil.guardarDatos(usuarios, ARCHIVO);
        }
    }
    
    public ArrayList<Usuario> getUsuarios() { return usuarios; }
    
    public Usuario login(String nombreUsuario, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario) &&
                u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }
}