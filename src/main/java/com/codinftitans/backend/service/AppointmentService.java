package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.request.AppointmentRequestDTO;
import com.codinftitans.backend.dto.response.AppointmentResponseDTO;
import com.codinftitans.backend.dto.response.CarResponseDTO;
import com.codinftitans.backend.model.Appointment;
import com.codinftitans.backend.model.Car;
import com.codinftitans.backend.repository.AppointmentRepository;
import com.codinftitans.backend.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    MailService mailService;
    @Autowired
    CarRepository carRepository;
    public List<AppointmentResponseDTO> findAll(){
        List<AppointmentResponseDTO> appointments=appointmentRepository.findAll()
                .stream().map(appointment ->{
                    AppointmentResponseDTO appointmentResponse=mapper.map(appointment,AppointmentResponseDTO.class);
                  appointmentResponse.setCarName(appointment.getCar().getModel());
                    return appointmentResponse;
                        }
                ).toList();
       return  appointments;
    }
    public Appointment newAppointment(AppointmentRequestDTO appointment){
        Appointment newApp=mapper.map(appointment,Appointment.class);
        return appointmentRepository.save(newApp);

    }
    @Transactional
    public String updateStatus(String value, UUID id){
        Optional<Appointment> appointment=appointmentRepository.findById(id);
        String email=appointment.get().getEmail();
        String textToSend="Chere "+appointment.get().getName()+"\n," +
                "Nous avons le plaisir de vous informé que le rendez-vous avec la voiture "+
                appointment.get().getCar().getModel()+" " +
                "prevu pour la " +
                "date de "+appointment.get().getAppointmentDate()+" a été validé ";
        if(value.equals("valide")){
            mailService.sendMessage(email,textToSend);
        }
        appointmentRepository.updateStatusById(value,id);
        return "updated successfully";
    }
}
