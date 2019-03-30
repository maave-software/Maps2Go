package com.maave.maps2go1.controlador;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class  ComentarioCtrl {
    
    private int dislike;
    private int like;
    private int numComentario;
    private String contenido;
    private double longitud;
    private double latitud;
    
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
    }

    public void actualizarComentario() {      
    }        
}
