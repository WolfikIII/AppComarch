package com.comarch.appcomarch.services.impl;

import com.comarch.appcomarch.model.Client;
import com.comarch.appcomarch.repositories.ClientRepo;
import com.comarch.appcomarch.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepo.getClientById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

}
