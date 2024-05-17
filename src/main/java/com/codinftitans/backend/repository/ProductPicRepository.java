package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.ProductPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPicRepository extends JpaRepository< ProductPic,Integer> {
}
