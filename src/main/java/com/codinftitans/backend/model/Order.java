package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrder;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_customer",nullable = false)
    private Customer customer;
    @ManyToMany(mappedBy = "orders")
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> ordered_products;


    private LocalDate orderDate;
    private LocalDate effectiveDate;





}
