package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.StatByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatByCategoryRepository extends JpaRepository<StatByCategory,Integer> {
    @Query(value = "select c.categorie, sum(c.prix) from \"chocolates\" as c inner join \"order\" as o on c.chocolat_id=o.id_product group by c.categorie, c.prix", nativeQuery = true)
    public List<StatByCategory> findStatByCategory();
}
