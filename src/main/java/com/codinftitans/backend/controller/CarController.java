package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.CarDTO;
import com.codinftitans.backend.model.Car;
import com.codinftitans.backend.repository.CarRepository;
import com.codinftitans.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;
    @GetMapping("/cars")
    public List<Car> findAll(){
        return carRepository.findAll();

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
