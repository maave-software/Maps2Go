package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import com.maave.maps2go.vista.CampoVacioIH;
import com.maave.maps2go.vista.ContraseniaIncorrectaIH;
import com.maave.maps2go.vista.CorreoIncorrectoIH;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SessionCtrl implements Serializable {

    private String correo;

    public String getCorreo() {
        // Automatically generated method. Please do not modify this code.
        return this.correo;
    }

    public void setCorreo(String correo) {
        // Automatically generated method. Please do not modify this code.
        this.correo = correo;
    }

    private String contrasenia;

    public String getContrasenia() {
        // Automatically generated method. Please do not modify this code.
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        // Automatically generated method. Please do not modify this code.
        this.contrasenia = contrasenia;
    }

    public String iniciarSesion() {
        UsuarioDAO udb = new UsuarioDAO();
        if (correo.compareTo("") == 0 || contrasenia.compareTo("") == 0) {
            CampoVacioIH vacio = new CampoVacioIH();
            vacio.mostrarMensaje();
        } else if(!udb.existeCorreo(correo)){
            CorreoIncorrectoIH incorrecto = new CorreoIncorrectoIH();
            incorrecto.mostrarMensaje();
        } else {
            Usuario usuario = udb.buscaUsuario(correo, contrasenia);
            FacesContext context = FacesContext.getCurrentInstance();
            if (usuario != null) {
                UsuarioLogged u = new UsuarioLogged(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getRol());
                if (usuario.getRol() == 1) {
                    context.getExternalContext().getSessionMap().put("usuario", u);
                   return "/administrador/perfil?faces-redirect=true";
                }

                if (usuario.getRol() == 2) {
                    context.getExternalContext().getSessionMap().put("usuario", u);
                    return "/informador/perfil?faces-redirect=true";
                }

                if (usuario.getRol() == 3) {
                    context.getExternalContext().getSessionMap().put("usuario", u);
                    return "/comentarista/perfil?faces-redirect=true";
                }
            } else{
                ContraseniaIncorrectaIH incorrecta = new ContraseniaIncorrectaIH();
                incorrecta.mostrarMensaje();
            }
        }
        return "inicioSesionFallido?faces-redirect=false";
    }

    public String cerrarSesion() {
        return "";
    }

    public class UsuarioLogged implements Serializable {

        private String nombre;
        private String correo;
        private int rol;

        public UsuarioLogged(String nombre, String correo, int rol) {
            this.nombre = nombre;
            this.correo = correo;
            this.rol = rol;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public int getRol() {
            return rol;
        }

        public void setRol(int rol) {
            this.rol = rol;
        }

    }
}
