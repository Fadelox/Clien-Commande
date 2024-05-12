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
public class CommandeServiceImp implements CommandeService{
    @Autowired
   CommandeRepo commandeRepo;
    @Autowired
    ClientRepo clientRepo;
    @Override
    public Commande add(Commande commande) {
        return commandeRepo.save(commande);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepo.findAll();
    }



    @Override
    public void deleteCommande(Long id) {
        Optional<Commande> optionalCommande=commandeRepo.findById(id);
        if (optionalCommande.isPresent()){
            Commande commande=optionalCommande.get();
            List<Client> clients= clientRepo.findClientByCommande(commande);
            if(clients.size()>0){
                for (Client client:clients){
                    clientRepo.delete(client);
                }
            }

            commandeRepo.delete(commande);
        }else{
            throw new EntityNotFoundException("No commande found");
        }

    }

    @Override
    public List<Commande> findCommande(String str) {
        return commandeRepo.findCommandeByDateContaining(str);
    }


}
