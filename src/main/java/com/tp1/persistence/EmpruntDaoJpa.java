package com.tp1.persistence;

import com.tp1.model.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpruntDaoJpa implements EmpruntDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gctTP2");

    @Override
    public void save(Emprunt emprunt) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(emprunt);

        em.getTransaction().commit();
        em.close();
    }
}
