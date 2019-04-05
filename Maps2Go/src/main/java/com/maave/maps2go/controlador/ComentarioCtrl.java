package com.maave.maps2go.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class  ComentarioCtrl {
    
    private int dislike;
    private int like;
    private int numComentario;
    private String contenido;
    private double longitud;
    private double latitud;
    private Usuario usuario;

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public int getNumComentario() {
        // Automatically generated method. Please do not modify this code.
        return this.numComentario;
    }

    public void setNumComentario(int numComentario) {
        // Automatically generated method. Please do not modify this code.
        this.numComentario = numComentario;
    }

    public String getContenido() {
        // Automatically generated method. Please do not modify this code.
        return this.contenido;
    }

    public void setContenido(String contenido) {
        // Automatically generated method. Please do not modify this code.
        this.contenido = contenido;
    }

    public int getLike() {
        // Automatically generated method. Please do not modify this code.
        return this.like;
    }

    public void setLike(int like) {
        // Automatically generated method. Please do not modify this code.
        this.like = like;
    }

    public int getDislike() {
        // Automatically generated method. Please do not modify this code.
        return this.dislike;
    }

    public void setDislike(int dislike) {
        // Automatically generated method. Please do not modify this code.
        this.dislike = dislike;
    }

    public void agregarComentario() {        
<<<<<<< HEAD
=======
        if(contenido.compareTo("") != 0){
            ComentarioDAO cmdb = new ComentarioDAO();
            UsuarioDAO udb = new UsuarioDAO();
            MarcadorDAO mdb = new MarcadorDAO();         
            Comentario coment = new Comentario();
            // implementacio con login       
            SessionCtrl.UsuarioLogged us= (SessionCtrl.UsuarioLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            Usuario u = udb.buscaPorCorreo(us.getCorreo());
            //Implementacion sin login Usuario u = udb.buscaPorCorreo("qwerty");
            Marcador m = mdb.buscaMarcador(1); //Pendiente 
            coment.setMarcador(m);
            coment.setLikes(0);
            coment.setDislikes(0);
            coment.setContenido(contenido);
            coment.setUsuario(u);
            try{
                cmdb.agregar(coment);
            } catch (Exception e) {
                ErrorServidorIH error = new ErrorServidorIH();
                error.mostrarMensaje();
            }
        } else {
            ComentarioVacioIH warn = new ComentarioVacioIH();
            warn.mostrarMensaje();
        }
>>>>>>> e30e5c1e20b3dbdd7e2be3ded93e73465646d9df
    }

    public void actualizarComentario(int id) {      
        if(contenido.compareTo("") != 0){
            ComentarioDAO cmdb = new ComentarioDAO();
            Comentario com = cmdb.buscaId(id);
            com.setContenido(contenido);            
            try{
                cmdb.actualizar(com);
            } catch (Exception e) {
                ErrorServidorIH error = new ErrorServidorIH();
                error.mostrarMensaje();
            }
        } else {
            ComentarioVacioIH warn = new ComentarioVacioIH();
            warn.mostrarMensaje();            
        }
    }        
    
    public boolean esComentarioPropio(int id){
        UsuarioDAO udb = new UsuarioDAO();
        SessionCtrl.UsuarioLogged us= (SessionCtrl.UsuarioLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        Usuario u = udb.buscaPorCorreo(us.getCorreo());
        ComentarioDAO cmdb = new ComentarioDAO();
        Comentario com = cmdb.esPropio(id, u.getIdUsuario());        
        System.out.println(com == null);
        if(com == null)
            return false;
        else
            return true;
    }
}
