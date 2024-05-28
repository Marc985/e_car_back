package com.codinftitans.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarWithPicDTO {
    private String model;
    private double price;
    private String motorType;
    private int power;
    private List<String> pics;
}
