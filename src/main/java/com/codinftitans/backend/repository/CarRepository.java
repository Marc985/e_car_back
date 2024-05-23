package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query(value = "select distinct brand from car",nativeQuery = true)
    List<Car> findAllBrand();

}
