package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.CarPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPicRepository extends JpaRepository<CarPic,Integer> {
}
