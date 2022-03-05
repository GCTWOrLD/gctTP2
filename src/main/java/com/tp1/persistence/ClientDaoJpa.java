package com.tp1.persistence;

import com.tp1.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDaoJpa implements ClientDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gctTP2");

    @Override
    public void save(Client client) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(client);

        em.getTransaction().commit();
        em.close();
    }
}
