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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author vale
 */

@ManagedBean
@ViewScoped
public class MapCtrl {
    private Marker marcador;
    private Marker marker;
    private MapModel simpleModel;
    private String datosUtiles;
    private String descripcion;
    private double latitud;
    private double longitud;
    private int numMarcador;
    private Tema tema;

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
    
    
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
        marcador = new Marker(new LatLng(23.382390, -102.291477));
        marcador.setDraggable(true);
        simpleModel.addOverlay(marcador);
        this.latitud = marcador.getLatlng().getLat();
        this.longitud = marcador.getLatlng().getLng();
    }

    public Marker getMarcador() {
        return marcador;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
       marker =(Marker) event.getOverlay(); 
    }
    public void onMarkerDrag(MarkerDragEvent event){
        marcador = event.getMarker();
        this.latitud = marcador.getLatlng().getLat();
        this.longitud = marcador.getLatlng().getLng();
    }

    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        marcador = simpleModel.getMarkers().get(0);
        marcador.setLatlng(latlng);
        this.latitud = latlng.getLat();
        this.longitud = latlng.getLng();
        
    }
    
     public void agregarMarcador() {
        MarcadorDAO mdb = new MarcadorDAO();
        Marcador m = new Marcador();
        TemaDAO tdb = new TemaDAO();
        Tema t = new Tema();
        t = tdb.buscaTema(tema.getTipoTema());
        m.setDescripcion(descripcion);
        m.setDatosUtiles(datosUtiles);
        m.setLatitud(latitud);
        m.setLongitud(longitud);
        m.setTema(t);
        mdb.agregar(m);
    }
  
}