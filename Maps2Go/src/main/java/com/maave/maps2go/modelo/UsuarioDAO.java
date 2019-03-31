package com.maave.maps2go.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO extends AbstractDAO<Usuario>{

    public UsuarioDAO() {
        super();
    }
    
    @Override
    public void agregar(Usuario usuario) {
        super.agregar(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        super.actualizar(usuario);
    }

    @Override
    public void borrar(Usuario usuario) {
        super.borrar(usuario);
    }

    public Usuario consultar(String id) {
        return super.consultarString(Usuario.class, id);
    }

    public List<Usuario> consultarTodos() {
        return super.consultarTodos(Usuario.class);
    }

    public Usuario buscaUsuario(String correo, String contrasenia) {
        Usuario u =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            String hql = "from Usuario where correo = :correo and contrasenia = :contrasenia";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia",contrasenia);
            u = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return u;
    }
    
    public Usuario buscaPorCorreo(String correo){
        Usuario u =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            String hql = "from Usuario where correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            u = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return u;
    }

    public Usuario buscaInformador(String nombre) {
        return null;
    }

}
