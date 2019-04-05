package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import com.maave.maps2go.vista.CamposSinLlenarIH;
import com.maave.maps2go.vista.CorreoExistenteIH;
import com.maave.maps2go.vista.NombreExistenteIH;
import com.maave.maps2go.vista.CuentaActualizadaIH;
import com.maave.maps2go.vista.CorreoIncorrectoIH;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioCtrl {
    
    private int idUsuario;
    private int rol;
    private String correo;
    private String contrasenia;
    private String nombreUsuario;

    public int getIdUsuario() {
        // Automatically generated method. Please do not modify this code.
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        // Automatically generated method. Please do not modify this code.
        this.idUsuario = idUsuario;
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

    public void agregarInformador() {
    }

    public void eliminarInformador() {
    }
    
    public void agregarCuenta(){
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
            
            if(nombreUsuario.isEmpty() && contrasenia.isEmpty() && correo.isEmpty()){
                CamposSinLlenarIH mensaje = new CamposSinLlenarIH();
                mensaje.mostrarMensaje();
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
