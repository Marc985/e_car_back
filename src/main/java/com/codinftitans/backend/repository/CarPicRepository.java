package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.CarPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface CarPicRepository extends JpaRepository<CarPic,Integer> {
    @Query(value = "SELECT * FROM car_pic WHERE id_car = ?", nativeQuery = true)
   public List<CarPic> findPicsByIdCar(@Param("idCar") UUID idCar);

}
