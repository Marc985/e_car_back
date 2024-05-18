package com.codinftitans.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO implements Serializable {

    private int idCategory;

    private String name;

}
