package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class CarPic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String url;
    @ManyToOne
    @JoinColumn(name = "id_car", referencedColumnName = "id",insertable = false,updatable = false)
    private Car car;
    @Column(name = "id_car")
    private UUID idCar;
}
