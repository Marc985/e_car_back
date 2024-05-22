package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.request.AppointmentRequestDTO;
import com.codinftitans.backend.dto.response.AppointmentResponseDTO;
import com.codinftitans.backend.model.Appointment;
import com.codinftitans.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<AppointmentResponseDTO> findAll(){
        return appointmentService.findAll();
    }
    @PostMapping("/appointment/new")
    public Appointment newAppointment(AppointmentRequestDTO appointment){
        return appointmentService.newAppointment(appointment);
    }
    @PutMapping("/appointment/update/{id}")
    public String updateStatus(@PathVariable UUID id,@RequestParam String status){
        return appointmentService.updateStatus(status,id);
    }
}
