package com.tp1.model;

public class Cd extends Document {
    private String duree;
    private String style;
    private String studio;

    public Cd() {

    }

    public Cd(int id, String titre, String auteur, int annee, Emprunt emprunt, String duree, String style, String studio) {
        super(id, titre, auteur, annee, emprunt);
        this.duree = duree;
        this.style = style;
        this.studio = studio;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "duree='" + duree + '\'' +
                ", style='" + style + '\'' +
                ", studio='" + studio + '\'' +
                "} " + super.toString();
    }
}
