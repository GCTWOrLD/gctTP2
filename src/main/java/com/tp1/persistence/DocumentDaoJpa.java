package com.tp1.persistence;

import com.tp1.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DocumentDaoJpa implements DocumentDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gctTP2");

    @Override
    public void save(Document document) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(document);

        em.getTransaction().commit();
        em.close();
    }
}
