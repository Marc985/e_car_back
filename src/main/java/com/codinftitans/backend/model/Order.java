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
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrder;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> orderedProducts;


    private LocalDate orderDate;
    private LocalDate effectiveDate;





}
