package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.StatByOrigin;
import com.codinftitans.backend.repository.StatByOriginRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatByOriginController {
    private final StatByOriginRepository statByOriginRepository;

    public StatByOriginController(StatByOriginRepository statByOriginRepository) {
        this.statByOriginRepository = statByOriginRepository;
    }

    @GetMapping("/stat/origin")
    public List<StatByOrigin> getStatByOrigin(){
        return statByOriginRepository.findStatByOrigin();
    }
}
