package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.request.AppointmentRequestDTO;
import com.codinftitans.backend.dto.response.AppointmentResponseDTO;
import com.codinftitans.backend.model.Appointment;
import com.codinftitans.backend.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    ModelMapper mapper;
    public List<AppointmentResponseDTO> findAll(){
       return appointmentRepository.findAll()
               .stream().map(appointment ->
                       mapper.map(appointment,AppointmentResponseDTO.class)
                       ).toList();
    }
    public Appointment newAppointment(AppointmentRequestDTO appointment){
        Appointment newApp=mapper.map(appointment,Appointment.class);
        return appointmentRepository.save(newApp);

    }
}
