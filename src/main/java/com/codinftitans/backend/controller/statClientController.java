package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.StatClient;
import com.codinftitans.backend.repository.StatByClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class statClientController {
    @Autowired
    StatByClientRepository statByClientController;
    @GetMapping("/stat/client")
    public List<StatClient> getSellByClient(){
       return statByClientController.findSellByClient();
    }
}
