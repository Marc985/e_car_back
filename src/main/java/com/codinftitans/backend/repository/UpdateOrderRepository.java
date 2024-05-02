package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UpdateOrderRepository extends JpaRepository<Order,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update \"order\"  set status='validé' where client_email = ?1 and status='en cours'",nativeQuery = true)
    void updateOrderStatus(String  email);
}
