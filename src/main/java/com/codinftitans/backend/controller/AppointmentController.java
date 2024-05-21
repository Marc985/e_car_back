package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.request.AppointmentRequestDTO;
import com.codinftitans.backend.dto.response.AppointmentResponseDTO;
import com.codinftitans.backend.model.Appointment;
import com.codinftitans.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
