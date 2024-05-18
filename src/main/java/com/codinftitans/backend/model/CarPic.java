package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class CarPic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPic;
    private String url;
    @ManyToOne
    @JoinColumn(name = "id_car",updatable = false,insertable = false)
    private Car car;
    @Column(name = "id_car")
    private int idCar;
}
