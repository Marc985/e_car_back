package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.PriceQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceQualityRepository extends JpaRepository<PriceQuality,String> {
    @Query(value = " SELECT DISTINCT nom, SUM(\"order\".id_product)/prix AS rapport_qualite_prix FROM \"order\" INNER JOIN chocolates ON \"order\".id_product = chocolates.chocolat_id GROUP BY nom, chocolates.prix ORDER BY rapport_qualite_prix DESC limit 1",nativeQuery = true)
    PriceQuality getPriceQualityRapport();
}
