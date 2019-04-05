package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
<<<<<<< HEAD
import com.maave.maps2go.vista.CamposSinLlenarIH;
import com.maave.maps2go.vista.CorreoExistenteIH;
import com.maave.maps2go.vista.NombreExistenteIH;
import com.maave.maps2go.vista.CuentaActualizadaIH;
import com.maave.maps2go.vista.CorreoIncorrectoIH;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
=======
import com.maave.maps2go.vista.CampoVacioIH;
import com.maave.maps2go.vista.CorreoExistenteIH;
import com.maave.maps2go.vista.InformadorAgregadoIH;
import com.maave.maps2go.vista.NombreExistenteIH;
>>>>>>> e30e5c1e20b3dbdd7e2be3ded93e73465646d9df
import javax.faces.bean.ManagedBean;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ManagedBean
public class UsuarioCtrl {
<<<<<<< HEAD
    
    private int idUsuario;
=======

>>>>>>> e30e5c1e20b3dbdd7e2be3ded93e73465646d9df
    private int rol;
    private int idUsuario;
    private String correo;
    private String contrasenia = "i";
    private String nombreUsuario;
<<<<<<< HEAD

    public int getIdUsuario() {
        // Automatically generated method. Please do not modify this code.
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        // Automatically generated method. Please do not modify this code.
        this.idUsuario = idUsuario;
=======
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static List<Usuario> informadores = new ArrayList();
    
    public List<Usuario> getInformadores() {
        return informadores;
    }
    
    public int getIdUsuario(){
        return this.idUsuario;
        
>>>>>>> e30e5c1e20b3dbdd7e2be3ded93e73465646d9df
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
<<<<<<< HEAD
    
    public void agregarCuenta(){
=======

    public void agregarCuenta() {
>>>>>>> e30e5c1e20b3dbdd7e2be3ded93e73465646d9df
    }

    public void actualizarCuenta() {
        UsuarioDAO udb = new UsuarioDAO();
        Usuario usuario = udb.consultarId(idUsuario);
        if (usuario != null){
            //Validaciones para el nombre de usuario
            if(nombreUsuario != null && !nombreUsuario.isEmpty()){
                if(!udb.existeNombre(nombreUsuario)){
                    usuario.setNombreUsuario(nombreUsuario);
                }else{
                    NombreExistenteIH mensaje = new NombreExistenteIH();
                    mensaje.mostrarMensaje();
                }
            }
            //Actualización de contrseña
            if (contrasenia != null && !contrasenia.isEmpty()) {
                usuario.setContrasenia(contrasenia);
            }
            //Validaciones para el correo
            if (correo != null && !correo.isEmpty()) {
                if (!validarCorreo(correo)){
                    CorreoIncorrectoIH mensaje = new CorreoIncorrectoIH();
                    mensaje.mostrarMensaje();  
                } 
                if(!udb.existeCorreo(correo)){
                    usuario.setCorreo(correo);
                }else{
                    CorreoExistenteIH mensaje = new CorreoExistenteIH();
                    mensaje.mostrarMensaje();
                }
            }
        
            udb.actualizar(usuario);
        }
    }
    
    public static boolean validarCorreo(String correo){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                       "[a-zA-Z0-9_+&*-]+)*@" + 
                       "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                       "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(regex);
        return pat.matcher(correo).matches(); 
    }

    public void borrarCuenta(){
        UsuarioDAO udb = new UsuarioDAO();
        Usuario cv = udb.consultarId(idUsuario);
        udb.borrar(cv);
    }

}
