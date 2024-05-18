package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.CarDTO;
import com.codinftitans.backend.model.Car;
import com.codinftitans.backend.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
   private CarRepository carRepository;

    @Autowired
    private ModelMapper mapper;

    public CarDTO saveNewCar(CarDTO car){

        Car newCar=this.mapper.map(car,Car.class);
        carRepository.save(newCar);
        return  car;
    }
    public List<CarDTO> findAllCar(){
        List<CarDTO> cars=carRepository.findAll().stream()
                .map(car -> this.mapper.map(car,CarDTO.class)).toList();
        return cars;
    }
    public String deleteById(UUID idCar){
        carRepository.deleteById(idCar);
        return "deleted successfullly";
    }

   /* public List<ProductDTO> filterByName(String nameChar){
        List<ProductDTO> products=findAllProduct().stream().filter(product ->
                product.getName().toLowerCase().contains(nameChar)
                ).toList();
        return products;
    }*/

}
