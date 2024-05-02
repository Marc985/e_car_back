package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateRepository extends JpaRepository<Product,Integer> {
}
