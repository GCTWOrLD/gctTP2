package com.tp1.model;

import java.util.List;

public class Client extends Personne {
    private List<Emprunt> emprunts;

    public Client() {

    }

    public Client(int id, String prenom, String nom, String username, String password, String email, String telephone, Adresse adresse, List<Emprunt> emprunts) {
        super(id, prenom, nom, username, password, email, telephone, adresse);
        this.emprunts = emprunts;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "emprunts=" + emprunts +
                "} " + super.toString();
    }
}
