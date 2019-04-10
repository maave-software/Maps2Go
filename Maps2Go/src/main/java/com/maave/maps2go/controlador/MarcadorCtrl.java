package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Marcador;
import com.maave.maps2go.modelo.MarcadorDAO;
import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;



@ManagedBean
@ViewScoped
public class MarcadorCtrl implements Serializable {
    
    private String datosUtiles;
    private String descripcion;
    private double latitud;
    private double longitud;
    private int numMarcador;
    private MapModel  simpleModel;
    private Marker marker;
    private Marker marcador;
    private List<Marcador> marcadores;
    private Marcador mrkSelected;
    private Tema temas;
    

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Marker getMarcador() {
        return marcador;
    }

    public void setMarcador(Marker marcador) {
        this.marcador = marcador;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    private Tema tema;

    public int getNumMarcador() {
        // Automatically generated method. Please do not modify this code.
        return this.numMarcador;
    }

    public void setNumMarcador(int numMarcador) {
        // Automatically generated method. Please do not modify this code.
        this.numMarcador = numMarcador;
    }

    public double getLongitud() {
        // Automatically generated method. Please do not modify this code.
        return this.longitud;
    }

    public void setLongitud(double longitud) {
        // Automatically generated method. Please do not modify this code.
        this.longitud = longitud;
    }

    public double getLatitud() {
        // Automatically generated method. Please do not modify this code.
        return this.latitud;
    }

    public void setLatitud(double latitud) {
        // Automatically generated method. Please do not modify this code.
        this.latitud = latitud;
    }

    public String getDescripcion() {
        // Automatically generated method. Please do not modify this code.
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        // Automatically generated method. Please do not modify this code.
        this.descripcion = descripcion;
    }

    public String getDatosUtiles() {
        // Automatically generated method. Please do not modify this code.
        return this.datosUtiles;
    }

    public void setDatosUtiles(String datosUtiles) {
        // Automatically generated method. Please do not modify this code.
        this.datosUtiles = datosUtiles;
    }

    public List<Marcador> getMarcadores() {
        return marcadores;
    }    
     
    public void setMarcadores(List<Marcador> marcadores){
        this.marcadores=marcadores;
    }
    
    public Marcador getMarcadorSelected(){
        return mrkSelected;    
    }
    
    public void setMarcadorSelected(Marcador mrkSelected){
        this.mrkSelected=mrkSelected;
    }
    /*metodos para el manejo de eliminacion con confirmacion*/
    public void handleClose(CloseEvent event) {
        addMessage(event.getComponent().getId() + " closed", "So you don't like nature?");
    }
     
    public void handleMove(MoveEvent event) {
        addMessage(event.getComponent().getId() + " moved", "Left: " + event.getLeft() + ", Top: " + event.getTop());
    }
     
    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    public void eliminarMarcador(Marcador mrkSelected) {
        MarcadorDAO mrk = new MarcadorDAO();
        mrk.borrar(mrkSelected);
    }
    
@PostConstruct
    public void verMarcadores(){
        MarcadorDAO mrk = new MarcadorDAO();
        marcadores = mrk.consultarTodos();
        
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdb = new MarcadorDAO();
        List<Marcador> marcadores = mdb.consultarTodos();
        for(Marcador m :marcadores){
            Tema tema = mdb.consultarColor(m.getTema());
            String color = tema.getColor();
            LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
            Marker marcador = new Marker(cord,m.getDescripcion(),m.getDatosUtiles(), color);
            simpleModel.addOverlay(marcador);
        }    
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
       marker =(Marker) event.getOverlay(); 
    }
    

}
