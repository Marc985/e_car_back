package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.CarPicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController

public class CarPicController {
    @Autowired
    CarPicRepository carPicRepository;
    @GetMapping("/pics")
List<String> findPicsByIdCar(@RequestParam(name = "idCar") UUID idCar){
    return carPicRepository.findPicsByIdCar(idCar).stream().map(
            CarPic::getUrl
    ).toList();
}
}
