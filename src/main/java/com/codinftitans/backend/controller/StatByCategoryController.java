package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.StatByCategory;
import com.codinftitans.backend.repository.StatByCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatByCategoryController {
    private final StatByCategoryRepository statByCategoryRepository;

    public StatByCategoryController(StatByCategoryRepository statByCategoryRepository) {
        this.statByCategoryRepository = statByCategoryRepository;
    }

    @GetMapping("/stat/category")
    public List<StatByCategory> getStatByCategory(){
        return statByCategoryRepository.findStatByCategory();
    }
}
