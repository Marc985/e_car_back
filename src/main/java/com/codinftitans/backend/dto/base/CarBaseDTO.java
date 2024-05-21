package com.codinftitans.backend.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarBaseDTO {
    private String description;
    private String brand;
    private String model;
    private double price;
    private String color;
    private String motorType;
    private int power;
    private int placeNumber;
    private String status;
}
