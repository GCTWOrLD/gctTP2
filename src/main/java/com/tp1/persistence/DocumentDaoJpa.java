package com.tp1.persistence;

import com.tp1.model.Document;
import com.tp1.model.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Document> findByTitre(String titre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select d from Document d where titre like :titreToSearch", Document.class);
        query.setParameter("titreToSearch", "%" + titre + "%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return documents;
    }

    @Override
    public List<Document> findByAuteur(String auteur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select d from Document d where auteur like :auteurToSearch", Document.class);
        query.setParameter("auteurToSearch", "%" + auteur + "%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return documents;
    }

    @Override
    public List<Document> findByAnnee(int annee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select d from Document d where cast(annee as string) like :anneeToSearch", Document.class);
        query.setParameter("anneeToSearch", "%" + annee + "%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return documents;
    }

    @Override
    public List<Livre> findLivreByGenre(String genre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Livre> query = em.createQuery("select l from Livre l where genre like :genreToSearch", Livre.class);
        query.setParameter("genreToSearch", "%" + genre + "%");
        final List<Livre> livres = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return livres;
    }
}
