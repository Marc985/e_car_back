package com.codinftitans.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

    @Query(value = "SELECT DISTINCT o.client_email,o.client_image_url, o.client_name FROM \"order\" o",nativeQuery = true)
    public List<Client> findAllClient();


}
