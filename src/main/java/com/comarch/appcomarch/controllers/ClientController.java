package com.comarch.appcomarch.controllers;

import com.comarch.appcomarch.model.Client;
import com.comarch.appcomarch.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<Client> add(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @GetMapping("/byId")
    public Client getClientById(@RequestParam Long clientId) {
        return clientService.getClientById(clientId);
    }

}
