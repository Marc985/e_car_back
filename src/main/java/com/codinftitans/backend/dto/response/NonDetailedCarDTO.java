package com.codinftitans.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NonDetailedCarDTO {
    private UUID id;
    private String model;
    private double price;
    private String motorType;
    private int power;
    private List<String> pics;
}
