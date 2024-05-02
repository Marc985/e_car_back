package com.codinftitans.backend.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class ProductPic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPic;
    private String url;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
