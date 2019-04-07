/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Marcador;
import com.maave.maps2go.modelo.MarcadorDAO;
import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author erick
 */
@ManagedBean
public class DelateMarkerCtrl {
    private List<Tema> temas;
    private List<Marcador> marcadores;
    private Set<Marcador> markrs;
    
    
    @PostConstruct
    public void init() {
        TemaDAO tm= new TemaDAO();
        temas= tm.consultarTodos();
        MarcadorDAO mrk = new MarcadorDAO();
        marcadores = mrk.consultarTodos();
        }
   
    public List<Marcador> getMarcadores() {
        return marcadores;
    }    
    public List<Tema> getTemas() {
        return temas;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("marcador Borrado", ((Tema) event.getObject()).getTipoTema());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    
}
