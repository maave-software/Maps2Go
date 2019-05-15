package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import com.maave.maps2go.modelo.Usuario;
import com.maave.maps2go.modelo.UsuarioDAO;
import com.maave.maps2go.modelo.Marcador;
import com.maave.maps2go.modelo.MarcadorDAO;
import com.maave.maps2go.vista.TemaAgregadoIH;
import com.maave.maps2go.vista.TemaExistenteIH;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class TemaCtrl {
    
    private String color;
    private String tipoTema;
    private Tema selectedTema;
    private List<Tema> temas;
    private String datosUtiles;
    private String descripcion;
    private double latitud;
    private double longitud;
    private int numMarcador;
    private Tema tema;
    private Marker marcador;
    private Marker marker;
    private MapModel simpleModel;

    
    @PostConstruct
    public void init() {
        TemaDAO tm= new TemaDAO();
        temas= tm.consultarTodos();
        simpleModel = new DefaultMapModel();
        marcador = new Marker(new LatLng(23.382390, -102.291477));
        marcador.setDraggable(true);
        simpleModel.addOverlay(marcador);
        this.latitud = marcador.getLatlng().getLat();
        this.longitud = marcador.getLatlng().getLng();
    }

    public String getDatosUtiles() {
        return datosUtiles;
    }

    public void setDatosUtiles(String datosUtiles) {
        this.datosUtiles = datosUtiles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
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
    
    public void agregarTema() {
        TemaDAO tdb = new TemaDAO();
        Tema tE= tdb.buscaTema(tipoTema);
        if(tE != null){
            TemaExistenteIH existeT = new TemaExistenteIH();
            existeT.mostrarMensaje();
            System.out.print("Error");
        }else{
            Tema t = new Tema();
            UsuarioDAO udb = new UsuarioDAO();
            SessionCtrl.UsuarioLogged us = (SessionCtrl.UsuarioLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            Usuario u = udb.buscaPorCorreo(us.getCorreo());
            MarcadorDAO mdb = new MarcadorDAO();
            Marcador m = new Marcador();
            t.setTipoTema(tipoTema);
            t.setColor(color);
            t.setUsuario(u);    
            tdb.agregar(t);
            m.setDescripcion(descripcion);
            m.setDatosUtiles(datosUtiles);
            m.setLatitud(latitud);
            m.setLongitud(longitud);
            m.setTema(t);
            mdb.agregar(m);

            TemaAgregadoIH exito = new TemaAgregadoIH();
            exito.mostrarMensaje();
        }

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
