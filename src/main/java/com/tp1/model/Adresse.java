package com.tp1.model;

import java.util.List;

public class Adresse {
    private String rue;
    private final String VILLE = "Javatown";
    private final String PROVINCE = "QC";
    private String codePostal;
    private String numeroCivique;
    private List<Personne> personnes;

    public Adresse() {

    }

    public Adresse(String rue, String codePostal, String numeroCivique, List<Personne> personnes) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.numeroCivique = numeroCivique;
        this.personnes = personnes;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNumeroCivique() {
        return numeroCivique;
    }

    public void setNumeroCivique(String numeroCivique) {
        this.numeroCivique = numeroCivique;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
}
