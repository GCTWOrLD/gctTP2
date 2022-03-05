package com.tp1.service;

import com.tp1.model.Cd;
import com.tp1.model.Dvd;
import com.tp1.model.Emprunt;
import com.tp1.model.Livre;
import com.tp1.persistence.EmpruntDao;

import java.time.temporal.ChronoUnit;

public class ClientService {

    private EmpruntDao empruntDao;

    public ClientService(EmpruntDao empruntDao) {
        this.empruntDao = empruntDao;
    }

    public void createEmprunt(Emprunt emprunt) {
        if (emprunt.getDocument().getClass().equals(Livre.class)) {
            emprunt.setDateRetour(emprunt.getDateEmprunt().plus(3, ChronoUnit.WEEKS));
        } else if (emprunt.getDocument().getClass().equals(Cd.class)) {
            emprunt.setDateRetour(emprunt.getDateEmprunt().plus(2, ChronoUnit.WEEKS));
        } else if (emprunt.getDocument().getClass().equals(Dvd.class)) {
            emprunt.setDateRetour(emprunt.getDateEmprunt().plus(1, ChronoUnit.WEEKS));
        }
        empruntDao.save(emprunt);
    }
}
