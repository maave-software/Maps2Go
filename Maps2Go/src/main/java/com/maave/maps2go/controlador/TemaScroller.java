/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maave.maps2go.controlador;

import com.maave.maps2go.controlador.TemaCtrl;
import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
//import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author erick
 */
@ManagedBean
@ViewScoped
public class TemaScroller  {
    private List<Tema> temas;
    private Tema selectedTema;
    
    @PostConstruct
    public void init() {
        TemaDAO tm= new TemaDAO();
        temas= tm.consultarTodos();
    }
    
     public List<Tema> getTemas() {
        return temas;
    }
     
    public Tema getSelectedTema(){
        return selectedTema;
    }
    
    public void setSelectedCar(Tema selectedTema) {
        this.selectedTema = selectedTema;
    }
     
     public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Tema Selected", ((Tema) event.getObject()).getTipoTema());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Tema) event.getObject()).getTipoTema());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
