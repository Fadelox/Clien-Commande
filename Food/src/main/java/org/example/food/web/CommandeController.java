package org.example.food.web;

import org.example.food.entities.Commande;
import org.example.food.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @CrossOrigin
    @PostMapping("/add")
    public Commande add(@RequestBody Commande commande){
        return commandeService.add(commande);
    }
    @CrossOrigin
    @GetMapping("/commande")
    public List<Commande> getCommande(){
        return  commandeService.getAllCommandes();
    }
 @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void delet(@PathVariable Long id){
        commandeService.deleteCommande(id);
    }
 @CrossOrigin
    @GetMapping("/findCommande/{str}")
    public List<Commande> find(@PathVariable String str){
        return commandeService.findCommande(str);
    }


}
