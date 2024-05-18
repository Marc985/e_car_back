package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.CarDTO;
import com.codinftitans.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/cars")
    public List<CarDTO> findAll(){
        return carService.findAllCar();

    }
    @PostMapping("car/new")
    public CarDTO newCar(@RequestBody CarDTO carDTO){
        return carService.saveNewCar(carDTO);
    }
    @DeleteMapping("car/delete")
    public String deleteCar(@RequestParam("id") UUID carId){
        return carService.deleteById(carId);
    }
}
