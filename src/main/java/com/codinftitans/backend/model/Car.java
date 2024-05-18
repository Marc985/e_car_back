package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.UUID)
    UUID idCar;
    String description;
    String brand;
    String model;
    double price;
    String color;
    String motorType;
    int power;
    int placeNumber;
    String status;
    @OneToMany(mappedBy = "car")
    Set<CarPic> pics;

}
