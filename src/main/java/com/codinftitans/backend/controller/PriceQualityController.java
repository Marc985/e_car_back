package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.PriceQuality;
import com.codinftitans.backend.repository.PriceQualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceQualityController {
    @Autowired
    PriceQualityRepository priceQualityRepository;
    @GetMapping("/qualityPrice/ratio")
    public PriceQuality getPriceQualityRapport(){
        return priceQualityRepository.getPriceQualityRapport();
    }
}
