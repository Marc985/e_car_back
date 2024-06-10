package com.codinftitans.backend.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentBaseDTO {
    private String name;
    private String email;
    private String message;
    private String contact;
    private Instant appointmentDate;
    private String Status;
    private UUID idCar;
}
