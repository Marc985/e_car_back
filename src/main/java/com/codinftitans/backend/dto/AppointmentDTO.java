package com.codinftitans.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {
    private UUID idAppointment;
    private String name;
    private String firstName;
    private String email;
    private String message;
    private String contact;
    private Instant appointmentDate;
    private String Status;
    private UUID idCar;
}
