package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import com.maave.maps2go.vista.CampoVacioIH;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioCtrl {
    
    private int rol;
    private String correo;
    private String contrasenia;
    private String nombreUsuario;

    
    public String getNombreUsuario() {
        // Automatically generated method. Please do not modify this code.
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        // Automatically generated method. Please do not modify this code.
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        // Automatically generated method. Please do not modify this code.
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        // Automatically generated method. Please do not modify this code.
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        // Automatically generated method. Please do not modify this code.
        return this.correo;
    }

    public void setCorreo(String correo) {
        // Automatically generated method. Please do not modify this code.
        this.correo = correo;
    }

    public int getRol() {
        // Automatically generated method. Please do not modify this code.
        return this.rol;
    }

    public void setRol(int rol) {
        // Automatically generated method. Please do not modify this code.
        this.rol = rol;
    }

    public void agregarInformador() {
    }

    public void eliminarInformador() {
    }
    
    public void agregarCuenta(){
         if (nombreUsuario.compareTo("") == 0) {
            CampoVacioIH cv = new CampoVacioIH();
            cv.mostrarMensaje();
        } else {
            Usuario u = new Usuario();
            u.setNombreUsuario(nombreUsuario);
            u.setCorreo(correo);
            u.setContrasenia(contrasenia);
            u.setRol(3);
            UsuarioDAO udb = new UsuarioDAO();
            udb.agregar(u);
        }

    }
    
    public void actualizarCuenta() {
    }

    public void eliminarCuenta() {
    }

}
