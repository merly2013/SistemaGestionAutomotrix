
package Automotriz.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreUsuario;
    private String contrasena;
    private String rol;
    private Mecanico mecanico;
    private boolean primerLogin;

    public Usuario(String nombreUsuario, String contrasena, String rol, Mecanico mecanico) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.mecanico = mecanico;
        this.primerLogin = rol.equals("MECANICO");
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public String getContrasena() { return contrasena; }
    public String getRol() { return rol; }
    public Mecanico getMecanico() { return mecanico; }
    public boolean isPrimerLogin() { return primerLogin; }

    public void cambiarContrasena(String nuevaContrasena) {
        if (nuevaContrasena == null || nuevaContrasena.isBlank())
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        this.contrasena = nuevaContrasena;
        this.primerLogin = false;
    }

    public void setPrimerLogin(boolean primerLogin) {
        this.primerLogin = primerLogin;
    }
}