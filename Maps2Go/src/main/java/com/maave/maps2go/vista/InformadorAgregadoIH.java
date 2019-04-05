package com.maave.maps2go.vista;

import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

public class InformadorAgregadoIH {
    private String mensaje;

    public String getMensaje() {
        // Automatically generated method. Please do not modify this code.
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        // Automatically generated method. Please do not modify this code.
        this.mensaje = mensaje;
    }

    public void mostrarMensaje() {
         this.mensaje = "El informador se ha agrado con exito \n Le llegara un correo de confirmación";
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"¡Exito!", mensaje));
    }

}
