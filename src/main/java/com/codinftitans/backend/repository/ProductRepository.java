package com.codinftitans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Chocolat,Integer>{
    @Query(value = "SELECT id_product, nom, SUM(prix) FROM \"order\" INNER JOIN chocolates ON \"order\".id_product = chocolates.chocolat_id WHERE \"order\".status = 'en cours' GROUP BY id_product, prix, nom", nativeQuery = true)
    List<Chocolat> findSumByChocolate();
  /*  @Query(value = " SELECT id_product, nom,description, SUM(prix)" +
            "FROM \"order\" " +
            "INNER JOIN chocolates ON \"order\".id_product = chocolates.chocolat_id" +
            "WHERE \"order\".\"status\" = 'en cours'" +
            "GROUP BY id_product, prix;",nativeQuery = true)
    List<Product> productList();*/


}
