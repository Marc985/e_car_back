package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.CategoryDTO;
import com.codinftitans.backend.model.Category;
import com.codinftitans.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/category/new")
    public Category createCategory(@RequestBody  CategoryDTO category){

      return   categoryService.createCategory(category);
    }

}
