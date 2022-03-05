package com.tp1.presentation;

import com.tp1.model.Cd;
import com.tp1.model.Client;
import com.tp1.persistence.ClientDaoJpa;
import com.tp1.persistence.DocumentDaoJpa;
import com.tp1.service.AdminService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class MainLibrairie {

    public static void main(String[] args) {

        AdminService adminService = new AdminService(new ClientDaoJpa(), new DocumentDaoJpa());

        Client client = new Client(1, "Gabriel", "Caron-Tawil", "gct", "pass123", "gct@gmail.com",
                "(514) 704-1694", "Alexis-Carrel", "J6K 4L5", "104", null);

        adminService.createClient(client);

        Cd cd = new Cd(1, "Monday", "deadmau5", 2014, null, "3:45", "Electronique", "mau5trap");

        Cd cd2 = new Cd(2, "Tuesday", "deadmau5", 2015, null, "3:50", "Electronique", "mau5trap");

        Cd cd3 = new Cd(3, "Wednesday", "deadmau5", 2016, null, "3:55", "Electronique", "mau5trap");

        adminService.createDocument(cd);
        adminService.createDocument(cd2);
        adminService.createDocument(cd3);

        System.out.println(adminService.searchDocByAuteur("deadmau5"));

        System.out.println(adminService.searchDocByAnnee(2014));
    }
}
