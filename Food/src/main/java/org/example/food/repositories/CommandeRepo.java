package org.example.food.repositories;

import org.example.food.entities.Commande;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande,Long> {
    List<Commande> findCommandeByDateContaining(String str);
}
