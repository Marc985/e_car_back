package com.codinftitans.backend.controller;

import com.codinftitans.backend.repository.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
@GetMapping("/clients")
    public List<Client> getClientlist(){
    return  clientRepository.findAllClient();
}
}
