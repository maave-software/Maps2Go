package com.maave.maps2go.controlador;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TemaCtrl {
    
    private String color;
    private String tipoTema;
        
    public String getTipoTema() {
        // Automatically generated method. Please do not modify this code.
        return this.tipoTema;
    }

    public void setTipoTema(String tipoTema) {
        // Automatically generated method. Please do not modify this code.
        this.tipoTema = tipoTema;
    }

    public String getColor() {
        // Automatically generated method. Please do not modify this code.
        return this.color;
    }

    public void setColor(String color) {
        // Automatically generated method. Please do not modify this code.
        this.color = color;
    }

    public void agregarTema() {
    }

    public void consultarTemas() {
    }

}
