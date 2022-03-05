package com.tp1.presentation;

import com.tp1.model.Client;
import com.tp1.persistence.ClientDaoJpa;
import com.tp1.service.AdminService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class MainLibrairie {

    public static void main(String[] args) {

        AdminService adminService = new AdminService(new ClientDaoJpa());

        Client client = new Client(1, "Gabriel", "Caron-Tawil", "gct", "pass123", "gct@gmail.com",
                "(514) 704-1694", "Alexis-Carrel", "J6K 4L5", "104", null);

        adminService.createClient(client);
    }
}
