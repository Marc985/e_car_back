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
    private UUID idCar;
    private String description;
    private String brand;
    private String model;
    private double price;
    private String color;
    private String motorType;
    private int power;
    private int placeNumber;
    private boolean pinned;
    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    private Set<CarPic> pics;
    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    private Set<Appointment> appointments;

}
