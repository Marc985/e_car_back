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
   private UUID id;

   private String name;
   private String email;
   private String message;
   private String contact;
   private Instant appointmentDate;
   private String Status;
    @ManyToOne
    @JoinColumn(name = "id_car",insertable = false,updatable = false,referencedColumnName = "id")
   private Car car;
    @Column(name = "id_car")
    private UUID idCar;

}
