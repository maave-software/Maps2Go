package com.maave.maps2go1.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ComentarioDAO extends AbstractDAO<Comentario>{
    
    public ComentarioDAO() {
        super();
    }
    
    @Override
    public void agregar(Comentario comentario) {
        super.agregar(comentario);
    }

    @Override
    public void actualizar(Comentario comentario) {
        super.actualizar(comentario);
    }

    @Override
    public void borrar(Comentario comentario) {
        super.borrar(comentario);
    }

    public Comentario consultar(int id) {
        return super.consultarInt(Comentario.class, id);
    }

    public List<Comentario> consultarTodos() {
        return super.consultarTodos(Comentario.class);
    }    

}
