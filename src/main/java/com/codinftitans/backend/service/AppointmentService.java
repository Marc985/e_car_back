package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.AppointmentDTO;
import com.codinftitans.backend.model.Appointment;
import com.codinftitans.backend.repository.AppointmentRepository;
import org.apache.catalina.mapper.Mapper;
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
    public List<AppointmentDTO> findAll(){
       return appointmentRepository.findAll()
               .stream().map(appointment ->
                       mapper.map(appointment,AppointmentDTO.class)
                       ).toList();
    }
    public Appointment newAppointment(AppointmentDTO appointment){
        Appointment newApp=mapper.map(appointment,Appointment.class);
        return appointmentRepository.save(newApp);

    }
}
