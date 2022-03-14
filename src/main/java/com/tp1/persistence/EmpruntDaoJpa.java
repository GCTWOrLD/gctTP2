package com.tp1.persistence;

import com.tp1.model.Client;
import com.tp1.model.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

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

    // IllegalArgumentException (à fixer)
    @Override
    public List<Emprunt> showEmprunts(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Emprunt> query = em.createQuery("select e.id, d.titre, e.dateRetour from Emprunt e inner join Document d on e.document.id = d.id where e.client.id = :idToSearch",  Emprunt.class);
        query.setParameter("idToSearch", "%" + id + "%");
        final List<Emprunt> emprunts = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return emprunts;
    }
}
