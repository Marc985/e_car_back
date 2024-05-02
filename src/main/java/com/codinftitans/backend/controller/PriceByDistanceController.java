package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.Coordonnee;
import com.codinftitans.backend.service.PriceByDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceByDistanceController {
    @Autowired
    PriceByDistance priceByDistance;
    @PostMapping("/distance/price")
    public Double priceByDistance(@RequestBody Coordonnee coordonnee){
    return priceByDistance.priceByDistance(coordonnee.getLagitude(),coordonnee.getLongitude());

    }
}
