package com.maave.maps2go.vista;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

public class CorreoExistenteIH {
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
<<<<<<< HEAD
        this.mensaje = ("Este correo ya está registrado. Intenta nuevamente con uno distinto.");
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia", mensaje));
=======
        this.mensaje = "Este correo ya existe";
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"¡Ey!", mensaje));
    
>>>>>>> e30e5c1e20b3dbdd7e2be3ded93e73465646d9df
    }

}
