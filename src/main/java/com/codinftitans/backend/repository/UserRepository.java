package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "select * from \"user\" where email=:email",nativeQuery = true)
    User findByEmail(@Param("email") String email);
}