package com.maave.maps2go1.modelo;

import java.util.List;

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

}
