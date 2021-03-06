package com.tp1.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dvd")
public class Dvd extends Document {
    private String duree;
    private String genre;
    private String studio;

    public Dvd() {

    }

    public Dvd(int id, String titre, String auteur, int annee, Emprunt emprunt, String duree, String genre, String studio) {
        super(id, titre, auteur, annee, emprunt);
        this.duree = duree;
        this.genre = genre;
        this.studio = studio;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "duree='" + duree + '\'' +
                ", genre='" + genre + '\'' +
                ", studio='" + studio + '\'' +
                "} " + super.toString();
    }
}
