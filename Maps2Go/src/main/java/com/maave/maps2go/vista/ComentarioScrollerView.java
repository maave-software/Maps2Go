/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maave.maps2go.vista;

import com.maave.maps2go.modelo.Comentario;
import com.maave.maps2go.modelo.ComentarioDAO;
import com.maave.maps2go.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author mauricio07
 */
@ManagedBean
@ViewScoped
public class ComentarioScrollerView implements Serializable{
    
    private List<Comentario> comentarios;
    private List<String> usuarios;

    public List<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<String> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
          
    
    @PostConstruct
    public void init() {
        ComentarioDAO cmdb = new ComentarioDAO();
        comentarios = cmdb.consultarOrden();
        
    }
    
    public void load(){
        init();
    }
    
    public String getNombre(Comentario comment){
        Usuario u = comment.getUsuario();
        return u.getNombreUsuario();
    }
}
