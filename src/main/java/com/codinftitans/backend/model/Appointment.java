package com.codinftitans.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
            @GeneratedValue(strategy = GenerationType.UUID)
    UUID idAppointment;

    String name;
    String firstName;
    String email;
    String message;
    String contact;
    Instant appointmentDate;
    String Status;
    @ManyToOne
    @JoinColumn(name = "id_car",insertable = false,updatable = false)
    Car car;
    @Column(name = "id_car")
    UUID idCar;

}
