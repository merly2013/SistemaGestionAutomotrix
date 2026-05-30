
package Automotriz.controller;

import Automotriz.modelo.Usuario;
import java.util.ArrayList;

public class LoginController {
    private ArrayList<Usuario> usuarios;
    
    public LoginController() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("recepcionista", "admin123", "RECEPCIONISTA", null));
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