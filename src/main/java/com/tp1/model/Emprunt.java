package com.tp1.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="Emprunt")
public class Emprunt {

    @Id
    private int id;
    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRetour;

    @ManyToOne
    @JoinColumn(name="Client_ID")
    private Client client;

    @OneToOne
    @JoinColumn(name = "Document_ID")
    private Document document;

    public Emprunt() {

    }

    public Emprunt(int id, LocalDateTime dateEmprunt, LocalDateTime dateRetour, Client client, Document document) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.client = client;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDateTime dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDateTime getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDateTime dateRetour) {
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

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                ", client=" + client +
                ", document=" + document +
                '}';
    }
}
