package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
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
    private int idProduct;
    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Customer customer;
    private LocalDate orderDate;
    private LocalDate effectiveDate;





}
