package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
        Tema t = new Tema();
        Usuario u = new Usuario();
        UsuarioDAO udb = new UsuarioDAO();
        TemaDAO tdb = new TemaDAO();
        SessionCtrl.UsuarioLogged us = (SessionCtrl.UsuarioLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        u = udb.buscaPorCorreo(us.getCorreo());
        t.setTipoTema(tipoTema);
        t.setColor(color);
        t.setUsuario(u);
        tdb.agregar(t);
    }

    public void consultarTemas() {
    }

}
