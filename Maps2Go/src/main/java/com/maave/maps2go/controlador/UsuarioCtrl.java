package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import com.maave.maps2go.vista.CampoVacioIH;
import com.maave.maps2go.vista.CorreoExistenteIH;
import com.maave.maps2go.vista.InformadorAgregadoIH;
import com.maave.maps2go.vista.NombreExistenteIH;
import javax.faces.bean.ManagedBean;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ManagedBean
public class UsuarioCtrl {

    private int rol;
    private int idUsuario;
    private String correo;
    private String contrasenia = "i";
    private String nombreUsuario;
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static List<Usuario> informadores = new ArrayList();
    
    public List<Usuario> getInformadores() {
        return informadores;
    }
    
    public int getIdUsuario(){
        return this.idUsuario;
        
    }
    
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

    public String agregarInformador() {
        UsuarioDAO udb = new UsuarioDAO();
        if (correo.compareTo("") == 0 || nombreUsuario.compareTo("") == 0) {
            CampoVacioIH esVacio = new CampoVacioIH();
            esVacio.mostrarMensaje();
        } else if(udb.existeCorreo(correo)){
            CorreoExistenteIH existeC = new CorreoExistenteIH();
            existeC.mostrarMensaje();
        } else if(udb.existeNombre(nombreUsuario)){
            NombreExistenteIH existeN = new NombreExistenteIH();
            existeN.mostrarMensaje();
        } else {
            for (int i = 0; i < 10; i++) {
                contrasenia += ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
            }
            
            Usuario u = new Usuario();
            
            u.setNombreUsuario(nombreUsuario);
            u.setCorreo(correo);
            u.setContrasenia(contrasenia);
            u.setRol(2);
            
            udb.agregar(u);
            
            InformadorAgregadoIH exito = new InformadorAgregadoIH();
            exito.mostrarMensaje();
            return "/administrador/perfil?faces-redirect=false";
        }
        return "/administrador/agregarInformadorFallido?faces-redirect=false";
    }

    public String buscarInformador(){
        UsuarioDAO udb = new UsuarioDAO();
        List<Usuario> u = udb.buscaInformadores();
        informadores = u;
        return "/administrador/eliminarInformador?faces-redirect=true";
        
    }
    public void eliminarInformador(int id) {
        UsuarioDAO udb = new UsuarioDAO();
        Usuario usuario = udb.consultarPorId(id);
        udb.borrar(usuario);
        buscarInformador();
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

    public void agregarCuenta() {
    }

    public void actualizarCuenta() {
    }

    public void eliminarCuenta() {
    }

}
