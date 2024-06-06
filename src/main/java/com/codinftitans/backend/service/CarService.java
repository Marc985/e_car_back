package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.request.CarRequestDTO;
import com.codinftitans.backend.dto.response.CarResponseDTO;
import com.codinftitans.backend.dto.response.CarWithPicDTO;
import com.codinftitans.backend.model.Brand;
import com.codinftitans.backend.model.Car;
import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.BrandRepository;
import com.codinftitans.backend.repository.CarPicRepository;
import com.codinftitans.backend.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
   private CarRepository carRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CarPicRepository carPicRepository;

    @Autowired
    private ModelMapper mapper;
    public List<CarWithPicDTO> findAllByPage(int pageNumber){
        Pageable pageable=PageRequest.of(pageNumber,6);

        return   carRepository.findAll(pageable).stream().map(
              car -> addPicsToCar(car)
      ).toList();
    }

    public CarRequestDTO saveNewCar(CarRequestDTO car){

        Car newCar=this.mapper.map(car,Car.class);
        carRepository.save(newCar);
        return  car;
    }
    public List<CarWithPicDTO> findAllCar(){
        List<CarWithPicDTO> cars=carRepository.findAll().stream()
                .map(this::addPicsToCar).toList();
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
    public List<Brand> findALlBrand(int pageNumber){
        Pageable pageable=PageRequest.of(pageNumber,6);

       return brandRepository.findAllBrand(pageable).stream()
               .map(car->mapper.map(car,Brand.class)).toList();
    }
    public List<CarResponseDTO> findCarsByBrand(String brand,int pageNumber){
        Pageable pageable= PageRequest.of(pageNumber,6);

        return carRepository.findCarsByBrand(brand,pageable)

                .map(car -> mapper.map(car,CarResponseDTO.class)).toList();
    }
    public List<CarResponseDTO> pinnedCars(){
        return carRepository.findPinnedCars().stream().map(
                car -> mapper.map(car,CarResponseDTO.class)
        ).toList();
    }
    public  String  pinCar(boolean condition,UUID idCar){
         carRepository.updateCarStatus(condition,idCar);
        return  "updated successfully";
    }
    public List<CarWithPicDTO> findNonDetailedCars(String brand,int pageNumber){
        Pageable pageable= PageRequest.of(pageNumber,6);
        List<Car> cars=carRepository.findCarsByBrand(brand,pageable).toList();

        return carRepository.findCarsByBrand(brand,pageable)

                .map(car ->{
                   CarWithPicDTO carWithPic=addPicsToCar(car);
                    return carWithPic;


                }).toList();
    }
    private CarWithPicDTO addPicsToCar(Car car){
        List<String> pics=carPicRepository.findPicsByIdCar(car.getId()).stream()
                .map(CarPic::getUrl).toList();
        CarWithPicDTO carWithPic= mapper.map(car,CarWithPicDTO.class);
        carWithPic.setPics(pics);
        return carWithPic;
    }
}
