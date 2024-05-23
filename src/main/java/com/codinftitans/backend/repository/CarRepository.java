package com.codinftitans.backend.repository;

import com.codinftitans.backend.dto.response.CarResponseDTO;
import com.codinftitans.backend.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query(value = "select * from car where brand=:brand",nativeQuery = true)
    Page<Car> findCarsByBrand(@Param("brand") String brand, Pageable page);
    @Query(value = "select * from car where pinned",nativeQuery = true)
    List<Car> findPinnedCars();
}
