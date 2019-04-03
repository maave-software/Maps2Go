package com.maave.maps2go.modelo;

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
    public List<Comentario> consultarOrden() {
        List<Comentario> obj = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Comentario c order by c.likes desc";
            System.out.println(hql);
            Query query = session.createQuery(hql);
            obj = (List<Comentario>) query.list();
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();

        }
        return obj;
    }

}
