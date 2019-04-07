package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Marcador;
import com.maave.maps2go.modelo.MarcadorDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.OverlaySelectEvent;
import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import com.maave.maps2go.modelo.UsuarioDAO;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class MarcadorCtrl implements Serializable{
    
     private String datosUtiles;
    private String descripcion;
    private double latitud;
    private double longitud;
    private int numMarcador;
    private MapModel simpleModel;
    private Marker marker;
    private Marker marcador;
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

    public void agregarMarcador() {
        MarcadorDAO mdb = new MarcadorDAO();
        UsuarioDAO udb = new UsuarioDAO();
        Marcador m = new Marcador();
        TemaDAO tdb = new TemaDAO();
        Tema t = new Tema();
        t = tdb.buscaTema("Mascota");
        m.setDescripcion(descripcion);
        m.setDatosUtiles(datosUtiles);
        m.setLatitud(latitud);
        m.setLongitud(longitud);
        m.setTema(t);
        mdb.agregar(m);
    }

    public void eliminarMarcador() {
    }

    @PostConstruct
    public void verMarcadores(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdb = new MarcadorDAO();
        List<Marcador> marcadores = mdb.consultarTodos();
        for(Marcador m :marcadores){
            LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
            Marker marcador = new Marker(cord,m.getDescripcion(),m.getDatosUtiles());
            simpleModel.addOverlay(marcador);
        }    
    }        
    
     //Métodos auxiliares para agregar marcador
    
    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
        marcador = new Marker(new LatLng(23.382390, -102.291477),"Arrastrame");
        marcador.setDraggable(true);
        marcador.setClickable(true);
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
    
    public Marker getMarker() {
        return marker;
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
