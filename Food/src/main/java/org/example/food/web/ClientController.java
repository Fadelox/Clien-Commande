package org.example.food.web;

import org.example.food.entities.Client;
import org.example.food.entities.Commande;
import org.example.food.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @CrossOrigin
    @PostMapping("/clients")
    public ResponseEntity<Client> createClientWithCommande(  @RequestParam String name,
                                                             @RequestParam String adress,
                                                             @RequestParam String ville,
                                                             @RequestParam String date,
                                                             @RequestParam String adressLivraison) {

        Commande commande = new Commande();
        commande.setDate(date);
        commande.setAdress_livraison(adressLivraison);

        Client client = new Client();
        client.setName(name);
        client.setAdress(adress);
        client.setVille(ville);

        Client savedClient = clientService.createClientWithCommande(client, commande);
        return ResponseEntity.ok(savedClient);
    }


    @CrossOrigin

    @PostMapping("/add")
    public Client ajouter(@RequestBody Client client){
        return clientService.add(client);
    }
    @CrossOrigin
    @GetMapping("/clients")
    public List<Client> getClient(){
        return clientService.getAllCLient();
    }
    @CrossOrigin
    @PutMapping("/update/{idclient}/{idcommande}")
    public Client update(@PathVariable Long idclient,@PathVariable Long idcommande,@RequestBody Client client){
        return clientService.updateClient(idclient,idcommande,client);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}/{idc}")
    public void delet(@PathVariable Long id,@PathVariable Long idc){
        clientService.deleteClient(id,idc);
    }
    @CrossOrigin
    @GetMapping("/findClient/{str}")
    public List<Client> find(@PathVariable String str){
        return clientService.findName(str);
    }

}
