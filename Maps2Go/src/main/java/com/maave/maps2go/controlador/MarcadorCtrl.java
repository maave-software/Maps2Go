package com.maave.maps2go.controlador;

import com.maave.maps2go.modelo.Marcador;
import com.maave.maps2go.modelo.MarcadorDAO;
import com.maave.maps2go.modelo.Tema;
import com.maave.maps2go.modelo.TemaDAO;
import com.maave.maps2go.controlador.MapCtrl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class MarcadorCtrl {
    
    MapCtrl mp = new MapCtrl();
    private String datosUtiles;
    private String descripcion;
    private double latitud;
    private double longitud;
    private int numMarcador;
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
        Marcador m = new Marcador();
        TemaDAO tdb = new TemaDAO();
        Tema t = new Tema();
        t = tdb.buscaTema("Mascotas");
        m.setDescripcion(descripcion);
        m.setDatosUtiles(datosUtiles);
        m.setLatitud(mp.getLatitud());
        m.setLongitud(mp.getLongitud());
        m.setTema(t);
        mdb.agregar(m);
    }

    public void eliminarMarcador() {
    }


     //Métodos auxiliares para agregar marcador

}
