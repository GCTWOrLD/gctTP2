package com.tp1.persistence;

import com.tp1.model.Client;
import com.tp1.model.Emprunt;

import java.util.List;

public interface EmpruntDao {

    void save(Emprunt emprunt);

    List<Emprunt> showEmprunts(int id);
}
