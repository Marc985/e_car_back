package com.codinftitans.backend.service;

import org.springframework.stereotype.Service;

@Service

public class PriceByDistance {

    DistanceCalculService distanceCalculService;
    public double priceByDistance(   double lat2,
                                     double lon2){
        double distance=DistanceCalculService.calculateDistance(lat2,lon2);
        return distance*500;

    }
}
