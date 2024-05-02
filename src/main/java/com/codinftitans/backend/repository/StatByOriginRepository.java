package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.StatByOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatByOriginRepository extends JpaRepository<StatByOrigin,Integer> {
    @Query(value = "select c.origine, sum(c.prix) from \"chocolates\" as c inner join \"order\" as o on c.chocolat_id=o.id_product group by c.origine, c.prix", nativeQuery = true)
    public List<StatByOrigin> findStatByOrigin();
}
