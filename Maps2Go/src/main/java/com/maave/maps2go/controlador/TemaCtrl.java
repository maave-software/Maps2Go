package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Marcador;
import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@ViewScoped
public class TemaCtrl {
    
    private String color;
    private String tipoTema;
    private Tema selectedTema;
    private List<Tema> temas;
    
    @PostConstruct
    public void init() {
        TemaDAO tm= new TemaDAO();
        temas= tm.consultarTodos();
    }
        
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
    
    public List<Tema> getTemas() {
        return temas;
    }
    
     
    public Tema getSelectedTema(){
        return selectedTema;
    }
    
    public void setSelectedTema(Tema selectedTema) {
        this.selectedTema = selectedTema;
    }

    public String agregarTema() {
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
        
        return "/informador/agregaMarcador?faces-redirect=true";
    }

    public void consultarTemas() {
    }
    
    /*los siguientes metodos son lolo temporales para probar el listener de temas*/
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Tema Selected", ((Tema) event.getObject()).getTipoTema());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Tema Unselected", ((Tema) event.getObject()).getTipoTema());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
