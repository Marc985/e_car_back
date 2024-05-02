package com.codinftitans.backend.controller;

import ch.qos.logback.core.net.server.Client;
import com.codinftitans.backend.model.Customer;
import com.codinftitans.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
  private   ClientRepository clientRepository;
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
       return clientRepository.findAll();
    }
    @PostMapping("/customer/create")
    public Customer saveCustomer(@RequestBody  Customer customer){
        return clientRepository.save(customer);
    }
}
