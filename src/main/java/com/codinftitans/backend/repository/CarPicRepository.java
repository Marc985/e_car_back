package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.CarPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarPicRepository extends JpaRepository<CarPic,Integer> {
    @Query(value = "SELECT * FROM car_pic WHERE id_car = ?", nativeQuery = true)
    List<CarPic> findPicsByIdCar(@Param("idCar") UUID idCar);
    @Modifying
    @Query(value = "delete from car_pic where id_car=?",nativeQuery = true)
    void deletePicByCar(@Param("idCar") UUID idCar);

}
