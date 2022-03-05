package com.tp1.service;

import com.tp1.model.Client;
import com.tp1.persistence.ClientDao;

public class AdminService {

    private ClientDao clientDao;

    public AdminService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void createClient(Client client) {

        clientDao.save(client);
    }
}
