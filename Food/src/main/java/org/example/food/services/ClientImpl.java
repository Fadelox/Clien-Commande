package org.example.food.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.food.entities.Client;
import org.example.food.entities.Commande;
import org.example.food.repositories.ClientRepo;
import org.example.food.repositories.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientImpl implements ClientService{
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    CommandeRepo commandeRepo;
    @Override

    public Client createClientWithCommande(Client client, Commande commande) {

        Commande savedCommande = commandeRepo.save(commande);


        client.setCommande(savedCommande);


        return clientRepo.save(client);
    }



   public Client add(Client client) {
        return clientRepo.save(client);
    }




    @Override
    public List<Client> getAllCLient() {
        return clientRepo.findAll();
    }

    @Override
    public Client updateClient(Long idClient,Long idcommande, Client newClient) {
        Optional<Client> optionalClient=clientRepo.findById(idClient);
        Optional<Commande> optionalCommande=commandeRepo.findById(idcommande);
        if (optionalClient.isPresent() && optionalCommande.isPresent()){
            Client client=optionalClient.get();
            Commande commande=optionalCommande.get();
            client.setAdress(newClient.getAdress());
            client.setName(newClient.getName());
            client.setVille(newClient.getVille());
            client.setCommande(commande);
             clientRepo.save(client);
        }else {
            throw new EntityNotFoundException("Client not Found");


        }
        return null;

    }

    @Override
    public void deleteClient(Long id,Long idc) {
        Optional<Client> optionalClient=clientRepo.findById(id);
        Optional<Commande> optionalCommande=commandeRepo.findById(idc);
        if (optionalClient.isPresent() && optionalCommande.isPresent()){
            Client client=optionalClient.get();
            Commande commande=optionalCommande.get();
            clientRepo.delete(client);
            commandeRepo.delete(commande);

        }else {
            throw  new EntityNotFoundException("Not found");
        }
    }

    @Override
    public List<Client> findName(String str) {

        return clientRepo.findClientByNameContaining(str);
    }

}
