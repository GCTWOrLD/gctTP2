package com.tp1.model;

import java.util.Date;

public class Emprunt {
    private int id;
    private Date dateEmprunt;
    private Date dateRetour;
    private Client client;
    private Document document;
    private Retard retard;

    public Emprunt() {

    }

    public Emprunt(int id, Date dateEmprunt, Date dateRetour, Client client, Document document, Retard retard) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.client = client;
        this.document = document;
        this.retard = retard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Retard getRetard() {
        return retard;
    }

    public void setRetard(Retard retard) {
        this.retard = retard;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                ", client=" + client +
                ", document=" + document +
                ", retard=" + retard +
                '}';
    }
}
