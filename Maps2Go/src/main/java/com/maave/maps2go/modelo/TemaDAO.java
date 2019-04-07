package com.maave.maps2go.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TemaDAO extends AbstractDAO<Tema>{
    
    public TemaDAO() {
        super();
    }

    @Override
    public void agregar(Tema tema) {
        super.agregar(tema);
    }

    @Override
    public void actualizar(Tema tema) {
        super.actualizar(tema);
    }

    @Override
    public void borrar(Tema tema) {
        super.borrar(tema);
    }

    public Tema consultar(String id) {
        return super.consultarString(Tema.class, id);
    }

    public List<Tema> consultarTodos() {
        return super.consultarTodos(Tema.class);
    }
    
    public Tema buscaTema(String tema){
        Tema t = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from Tema where tipoTema = :tema";
            Query query = session.createQuery(hql);
            query.setParameter("tema", tema);
            t = (Tema)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return t;
    }

}
