package org.example.food.services;

import org.example.food.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CommandeService {
    Commande add(Commande commande);
    List<Commande> getAllCommandes();

    void deleteCommande(Long id);
    List<Commande> findCommande(String str);
}
