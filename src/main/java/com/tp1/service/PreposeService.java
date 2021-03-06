package com.tp1.service;

import com.tp1.model.Client;
import com.tp1.model.Document;
import com.tp1.model.Livre;
import com.tp1.persistence.ClientDao;
import com.tp1.persistence.DocumentDao;

import java.util.List;

public class PreposeService {

    private ClientDao clientDao;
    private DocumentDao documentDao;

    public PreposeService(ClientDao clientDao) {
        this.clientDao = clientDao;
        this.documentDao = documentDao;
    }

    public void createClient(Client client) {

        clientDao.save(client);
    }

    public void createDocument(Document document) {

        documentDao.save(document);
    }

    public List<Document> searchByTitre(String titre) {
        return documentDao.findByTitre(titre);
    }

    public List<Document> searchDocByAuteur(String auteur) {
        return documentDao.findByAuteur(auteur);
    }

    public List<Document> searchDocByAnnee(int annee) {
        return documentDao.findByAnnee(annee);
    }

    public List<Livre> searchLivreByGenre(String genre) {
        return documentDao.findLivreByGenre(genre);
    }
}
