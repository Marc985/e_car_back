package com.codinftitans.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {
   private UUID idCar;
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
