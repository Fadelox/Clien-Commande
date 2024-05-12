package org.example.food.repositories;

import org.example.food.entities.Client;
import org.example.food.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client,Long> {
List<Client> findClientByCommande(Commande commande);
List<Client> findClientByNameContaining(String str);
List<Client> findClientByVilleContaining(String str);
}
