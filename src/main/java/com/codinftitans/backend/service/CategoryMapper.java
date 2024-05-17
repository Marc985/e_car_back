package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.CategoryDTO;
import com.codinftitans.backend.model.Category;
import org.mapstruct.Mapper;

@Mapper()
public interface CategoryMapper {
    CategoryDTO entityToDto(Category category);
    Category dtoToEntity(CategoryDTO categoryDTO);
}
