package com.tp1.service;

import com.tp1.model.*;
import com.tp1.persistence.EmpruntDao;

import java.time.temporal.ChronoUnit;
import java.util.List;

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

    public List<Emprunt> showEmprunts (int id) {
        return empruntDao.showEmprunts(id);
    }
}
