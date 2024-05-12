package org.example.food.services;

import org.example.food.entities.Client;
import org.example.food.entities.Commande;

import java.util.List;

public interface ClientService {
    Client add(Client client);
    List<Client> getAllCLient();
    Client updateClient(Long idClient,Long idcommande,Client newClient);
    void deleteClient(Long id,Long idc);
    List<Client> findName(String str);
    Client createClientWithCommande(Client client, Commande commande);
}
