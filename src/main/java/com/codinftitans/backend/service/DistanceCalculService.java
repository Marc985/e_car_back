package com.codinftitans.backend.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculService {
    private static final double EARTH_RADIUS = 6371.0;

    public static double calculateDistance(
                                           double lat2,
                                           double lon2){
        double lat1Rad = Math.toRadians(-18.892303719425332);
        double lon1Rad = Math.toRadians( 47.548416850034336);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS*c;
    }

}
