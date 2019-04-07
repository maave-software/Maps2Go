/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maave.maps2go.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.MarkerDragEvent;
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
    private MapModel simpleModel;
    private double latitud;
    private double longitud;   
    
   
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
        marcador = new Marker(new LatLng(23.382390, -102.291477),"Arrastrame");
        marcador.setDraggable(true);
        //marcador.setClickable(true);
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
    
    public double getLongitud(){
        return this.longitud;
    }
    
    public void setLongitud(double longitud){
        this.longitud = longitud;
    }
    
    public double getLatitud(){
        return this.latitud;
    }
    
    public void setLatitud(double latitud){
        this.latitud = latitud;
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
}
