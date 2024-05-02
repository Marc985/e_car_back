package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.FarProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFarRepository extends JpaRepository<FarProduct,String> {
    @Query(value = "select nom,count(nom) from \"order\" inner join chocolates on \"order\".id_product=chocolat_id  group by nom order by count desc limit 1",nativeQuery = true)
    FarProduct findFarProduct();
}
