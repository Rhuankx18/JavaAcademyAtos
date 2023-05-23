package com.pacote.hibernatetest.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class connect {

    private static EntityManagerFactory entidade = Persistence.createEntityManagerFactory("hibernateteste");
    public static EntityManager getEntidade() {return entidade.createEntityManager();}
}
