package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct;
    private String name;
    private String description;
    private double price;


    @ManyToMany(mappedBy = "orderedProducts")

    private Set<Order> orders;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<ProductPic> pics;
}
