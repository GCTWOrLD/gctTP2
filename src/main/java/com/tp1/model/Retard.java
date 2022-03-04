package com.tp1.model;

import java.math.BigDecimal;

public class Retard {
    private int id;
    private BigDecimal amende;
    private Emprunt emprunt;

    public Retard() {

    }

    public Retard(int id, BigDecimal amende, Emprunt emprunt) {
        this.id = id;
        this.amende = amende;
        this.emprunt = emprunt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmende() {
        return amende;
    }

    public void setAmende(BigDecimal amende) {
        this.amende = amende;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }
}
