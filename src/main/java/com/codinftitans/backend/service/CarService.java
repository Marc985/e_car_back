package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.request.CarRequestDTO;
import com.codinftitans.backend.dto.response.CarResponseDTO;
import com.codinftitans.backend.dto.response.NonDetailedCarDTO;
import com.codinftitans.backend.model.Brand;
import com.codinftitans.backend.model.Car;
import com.codinftitans.backend.model.CarPic;
import com.codinftitans.backend.repository.AppointmentRepository;
import com.codinftitans.backend.repository.BrandRepository;
import com.codinftitans.backend.repository.CarPicRepository;
import com.codinftitans.backend.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ModelMapper mapper;
    public Optional<CarResponseDTO> findCarById(UUID id){
        return  carRepository.findById(id).map(
                car -> {
                   List<String> pics= carPicRepository.findPicsByIdCar(car.getId()).stream()
                           .map(CarPic::getUrl).toList();
                   CarResponseDTO carResponseDTO=mapper.map(car,CarResponseDTO.class);
                   carResponseDTO.setPics(pics);
                   return carResponseDTO;
                }
        );
    }
    public List<NonDetailedCarDTO> findAllByPage(int pageNumber){
        Pageable pageable=PageRequest.of(pageNumber,6);

        return   carRepository.findAll(pageable).stream().map(
              car -> addPicsToCar(car)
      ).toList();
    }
    public List<NonDetailedCarDTO> filterCar(String query){
        if(query==null){
            return carRepository.findAll().stream().map(
                    this::addPicsToCar
            ).toList();
        }
        else{
        return  carRepository.filterCar(query).stream().map(
                this::addPicsToCar
        ).toList();}
    }

    public CarResponseDTO saveNewCar(CarRequestDTO car){

        Car newCar=this.mapper.map(car,Car.class);
        carRepository.save(newCar);
        return  mapper.map(newCar,CarResponseDTO.class);
    }
    public List<NonDetailedCarDTO> findAllCar(){
        List<NonDetailedCarDTO> cars=carRepository.findAll().stream()
                .map(this::addPicsToCar).toList();
        return cars;
    }
    @Transactional
    public String deleteById(UUID idCar){
        carPicRepository.deletePicByCar(idCar);
        appointmentRepository.deleteAppointmentByCar(idCar);
        carRepository.deleteById(idCar);
        return "deleted successfullly";
    }

   /* public List<ProductDTO> filterByName(String nameChar){
        List<ProductDTO> products=findAllProduct().stream().filter(product ->
                product.getName().toLowerCase().contains(nameChar)
                ).toList();
        return products;
    }*/
    public List<Brand> findALlBrand(){

       return brandRepository.findAllBrand().stream()
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
    public List<NonDetailedCarDTO> findNonDetailedCars(String brand, int pageNumber){
        Pageable pageable= PageRequest.of(pageNumber,6);
        List<Car> cars=carRepository.findCarsByBrand(brand,pageable).toList();

        return carRepository.findCarsByBrand(brand,pageable)

                .map(car ->{
                   NonDetailedCarDTO carWithPic=addPicsToCar(car);
                    return carWithPic;


                }).toList();
    }
    private NonDetailedCarDTO addPicsToCar(Car car){
        List<String> pics=carPicRepository.findPicsByIdCar(car.getId()).stream()
                .map(CarPic::getUrl).toList();
        NonDetailedCarDTO carWithPic= mapper.map(car, NonDetailedCarDTO.class);
        carWithPic.setPics(pics);
        return carWithPic;
    }
}
