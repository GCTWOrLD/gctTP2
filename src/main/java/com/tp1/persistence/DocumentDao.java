package com.tp1.persistence;

import com.tp1.model.Document;

import java.util.List;

public interface DocumentDao {

    void save(Document document);

    List<Document> findByTitre(String titre);

    List<Document> findByAuteur(String auteur);

    List<Document> findByAnnee(int annee);

    List<Document> findByCategorie(String categorie);
}
