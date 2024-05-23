package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.request.CarRequestDTO;
import com.codinftitans.backend.dto.response.CarResponseDTO;
import com.codinftitans.backend.model.Brand;
import com.codinftitans.backend.model.Car;
import com.codinftitans.backend.repository.CarRepository;
import com.codinftitans.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @GetMapping("/cars/{brand}")
    public List<CarResponseDTO> findCarsByBrand(@PathVariable String brand,@RequestParam int pageNumber){
        return carService.findCarsByBrand(brand,pageNumber);
    }
    @GetMapping("/brands")
    public List<Brand> findAllBrand(){
        return carService.findALlBrand();
    }
    @GetMapping("/cars/pinned")
    public List<CarResponseDTO> pinnedCars(){
        return carService.pinnedCars();
    }

    @PostMapping("car/new")
    public CarRequestDTO newCar(@RequestBody CarRequestDTO carDTO){
        return carService.saveNewCar(carDTO);
    }
    @DeleteMapping("car/delete")
    public String deleteCar(@RequestParam("id") UUID carId){
        return carService.deleteById(carId);
    }

}
