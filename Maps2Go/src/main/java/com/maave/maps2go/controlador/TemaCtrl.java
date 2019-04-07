package com.maave.maps2go.controlador;

import javax.faces.bean.ManagedBean;
import com.maave.maps2go.modelo.TemaDAO;
import com.maave.maps2go.modelo.Tema;
import java.util.List;

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

    public List<Tema> consultarTemas() {
        TemaDAO tma= new TemaDAO();
        return tma.consultarTodos();
    }
    

}
