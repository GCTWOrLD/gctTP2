package com.tp1.presentation;

import com.tp1.model.Livre;
import com.tp1.persistence.JBDCLibrairie;

public class MainLibrairie {

    public static void main(String[] args) {

        Livre livre = new Livre();
        Livre nouveauLivre;

        livre.setId(1);
        livre.setTitre("Ignare, Un Lezard Tres Rare");
        livre.setAuteur("Paul Laroche");
        livre.setAnnee(1999);
        livre.setEditeur("Editions Lapierre");
        livre.setGenre("Roman");

        JBDCLibrairie.dropTable();
        JBDCLibrairie.createDatabase();

        JBDCLibrairie.insertLivre(livre);

        nouveauLivre = JBDCLibrairie.getLivre(1);
        System.out.println("nouveauLivre a ete hydrate avec les donnes suivantes...");
        System.out.println(nouveauLivre);
    }
}
