package com.comarch.appcomarch.services;

import com.comarch.appcomarch.model.Client;

import java.util.Optional;

public interface ClientService {

    Client addClient(Client client);

    Client getClientById(Long id);

}
