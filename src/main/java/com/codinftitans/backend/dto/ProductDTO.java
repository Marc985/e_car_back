package com.codinftitans.backend.dto;

import com.codinftitans.backend.model.Category;
import com.codinftitans.backend.model.Order;
import com.codinftitans.backend.model.ProductPic;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int idProduct;
    private String name;
    private String description;
    private double price;
    private  int idCategory;

}
