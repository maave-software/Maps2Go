/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maave.maps2go.controlador;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author vale
 */
public class Mensaje {
    
    public void mandarCorreo(){
        
        //correo gmail de envío
        String correoEnvia = "vale.garcia.landa@gmail.com";
        String claveCorreo = "jolubreva1998";
         
        //configuración para enviar correo
        Properties p = new Properties();
        p.put("mail.smtp.host", "stmp.gmail,com");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.user", correoEnvia);
        p.put("mail.password", claveCorreo);
        
        //obtener la sesion
        Session session = Session.getInstance(p, null);
        
        try{
            //cuerpo del mensaje
            MimeMessage mensaje = new MimeMessage(session);
            
            //agregar quien envia el correo
            mensaje.setFrom(new InternetAddress(correoEnvia, "Dato Java"));
            
            //asunto al correo
            mensaje.setSubject("Dato Java enviando correo.");
            
            //parte del mensaje
            MimeBodyPart mensajePart = new MimeBodyPart();
            mensajePart.setText("Hola");
            
            //agregar parte del mensaje anterior
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mensajePart);
            
            mensaje.setContent(multipart);
            
            //Enviar mensaje
            Transport transport = session.getTransport("smtp");
            transport.connect(correoEnvia, claveCorreo);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Correo Enviado");
    }
    
}