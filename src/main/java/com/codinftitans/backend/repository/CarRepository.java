package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
 Page<Car> findAll(Pageable pageable);

    @Query(value = "select * from car where brand=:brand",nativeQuery = true)
    Page<Car> findCarsByBrand(@Param("brand") String brand, Pageable page);
    @Query(value = "select * from car where pinned",nativeQuery = true)
    List<Car> findPinnedCars();
    @Modifying
    @Transactional
    @Query(value = "update car set pinned=:condition where id_car=:id",nativeQuery = true)
    void updateCarStatus(@Param("condition") boolean condition,@Param("id") UUID idCar);
}
