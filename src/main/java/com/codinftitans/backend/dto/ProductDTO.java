package com.codinftitans.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int idProduct;
    private String description;
    private String name;
    private double price;
    private  int idCategory;

}
