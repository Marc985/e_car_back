package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.response.CarPicResponseDTO;
import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.CarPicRepository;
import com.codinftitans.backend.service.CarPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController

public class CarPicController {
    @Autowired
    CarPicService carPicService;
    @GetMapping("/pics")
List<CarPicResponseDTO> findPicsByIdCar(@RequestParam(name = "idCar") UUID idCar){
    return carPicService.findPicByIdCar(idCar);
}
}
