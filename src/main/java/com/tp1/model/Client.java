package com.tp1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne {

    @OneToMany(mappedBy = "emprunt")
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "amendes")
    private List<Amende> amendes = new ArrayList<>();
    public Client() {

    }

    public Client(int id, String prenom, String nom, String username, String password, String email, String telephone,
                  String rue, String codePostal, String numeroCivique, List<Emprunt> emprunts) {
        super(id, prenom, nom, username, password, email, telephone, rue, codePostal, numeroCivique);
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
