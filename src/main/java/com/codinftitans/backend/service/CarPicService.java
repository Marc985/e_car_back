package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.response.CarPicResponseDTO;
import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.CarPicRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarPicService {
@Autowired
    private CarPicRepository carPicRepository;
@Autowired
ModelMapper mapper;
public List<CarPicResponseDTO> findPicByIdCar(UUID idCar){
   List<CarPicResponseDTO> pics=carPicRepository.findPicsByIdCar(idCar)
           .stream().map(carPic -> mapper.map(carPic,CarPicResponseDTO.class)).toList();
   return pics;
}

}
