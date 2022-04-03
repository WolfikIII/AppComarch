package com.comarch.appcomarch.repositories;

import com.comarch.appcomarch.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Optional<Client> getClientById(Long id);
}
