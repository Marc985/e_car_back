package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BrandRepository extends JpaRepository<Brand, String>{
    @Query(value = "select distinct brand as name from car",nativeQuery = true)
   public List<Brand> findAllBrand();

}
