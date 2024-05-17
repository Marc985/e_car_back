package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.CategoryDTO;
import com.codinftitans.backend.model.Category;

import com.codinftitans.backend.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
 CategoryRepository categoryRepository;
    @Autowired
private ModelMapper modelMapper;
    public Category createCategory(CategoryDTO category){
        if (category == null) {
            throw new IllegalArgumentException("CategoryDTO cannot be null");
        }




        Category newCategory = modelMapper.map(category,Category.class);
        System.out.println(newCategory.getName()+" "+category.getName());


        // Check for successful saving after using categoryRepository.save
        Category savedCategory = categoryRepository.save(newCategory);


        return savedCategory;
    }
}
