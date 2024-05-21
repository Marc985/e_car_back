package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.AppointmentDTO;
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
    public List<AppointmentDTO> findAll(){
        return appointmentService.findAll();
    }
    @PostMapping("/appointment/new")
    public Appointment newAppointment(AppointmentDTO appointment){
        return appointmentService.newAppointment(appointment);
    }
}
