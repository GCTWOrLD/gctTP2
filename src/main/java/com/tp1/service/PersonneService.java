package com.tp1.service;

import com.tp1.model.Personne;

import java.util.ArrayList;
import java.util.List;

public class PersonneService {
    private static List<Personne> personnes = new ArrayList<>();

    public static List<Personne> getPersonnes() {
        return personnes;
    }

    public static void setPersonnes(List<Personne> liste) {
        PersonneService.personnes = liste;
    }

    public static boolean addPersonne(Personne personne) {
        return getPersonnes().add(personne);
    }

    public static boolean deletePersonne(Personne personne) {
        return getPersonnes().remove(personne);
    }

    public static Personne rechercherPersonne(int id) {
        for (Personne personne : getPersonnes()) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return null;
    }
}
