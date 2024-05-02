package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.StatClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StatByClientRepository extends JpaRepository<StatClient,String> {
    @Query(value = "SELECT \"order\".client_email, \"order\".client_name, COALESCE(SUM(chocolates.prix), 0) AS total_prix FROM \"order\" INNER JOIN chocolates ON \"order\".id_product = chocolates.chocolat_id GROUP BY \"order\".client_email, \"order\".client_name",nativeQuery = true)
   public List<StatClient> findSellByClient();
}
