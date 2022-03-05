package com.tp1.presentation;

import com.tp1.model.Cd;
import com.tp1.model.Client;
import com.tp1.model.Emprunt;
import com.tp1.model.Livre;
import com.tp1.persistence.ClientDaoJpa;
import com.tp1.persistence.DocumentDaoJpa;
import com.tp1.persistence.EmpruntDaoJpa;
import com.tp1.service.AdminService;
import com.tp1.service.ClientService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MainLibrairie {

    public static void main(String[] args) {

        AdminService adminService = new AdminService(new ClientDaoJpa(), new DocumentDaoJpa());
        ClientService clientService = new ClientService(new EmpruntDaoJpa());

        Client client = new Client(1, "Gabriel", "Caron-Tawil", "gct", "pass123", "gct@gmail.com",
                "(514) 704-1694", "Alexis-Carrel", "J6K 4L5", "104", null);

        Cd cd = new Cd(1, "Monday", "deadmau5", 2014, null, "3:45", "Electronique", "mau5trap");

        Cd cd2 = new Cd(2, "Tuesday", "deadmau5", 2015, null, "3:50", "Electronique", "mau5trap");

        Cd cd3 = new Cd(3, "Wednesday", "deadmau5", 2016, null, "3:55", "Electronique", "mau5trap");

        Livre livre = new Livre(4, "Le Lezard", "Paul Lamarche", 1999, null, "Editions Soleil", "Roman");

        Livre livre2 = new Livre(5, "Showbiz", "Denis Lachance", 2010, null, "Editions Royal", "Magazine");

        Livre livre3 = new Livre(6, "Math 101", "Jean Laroux", 2010, null, "Editions School", "Manuel Scolaire");

        Livre livre4 = new Livre(7, "English 101", "Joe Knox", 2012, null, "Editions School", "Manuel Scolaire");

        adminService.createDocument(cd);
        adminService.createDocument(cd2);
        adminService.createDocument(cd3);

        System.out.println(adminService.searchDocByAuteur("deadmau5"));

        System.out.println(adminService.searchDocByAnnee(2014));

        adminService.createDocument(livre2);
        adminService.createDocument(livre3);
        adminService.createDocument(livre4);

        System.out.println(adminService.searchLivreByGenre("Roman"));

        System.out.println(adminService.searchByTitre("101"));

        Emprunt emprunt = new Emprunt(1, LocalDateTime.now(), null, client, livre);

        adminService.createClient(client);

        clientService.createEmprunt(emprunt);
    }
}
