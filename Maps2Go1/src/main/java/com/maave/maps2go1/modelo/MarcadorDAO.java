package com.maave.maps2go1.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class MarcadorDAO extends AbstractDAO<Marcador>{
    
    public MarcadorDAO() {
        super();
    }
    
    @Override
    public void agregar(Marcador marcador) {
        super.agregar(marcador);
    }

    @Override
    public void actualizar(Marcador marcador) {
        super.actualizar(marcador);
    }

    @Override
    public void borrar(Marcador marcador) {
        super.borrar(marcador);
    }

    public Marcador consultar(int id) {
        return super.consultarInt(Marcador.class, id);
    }

    public List<Marcador> consultarTodos() {
        return super.consultarTodos(Marcador.class);
    }

}
