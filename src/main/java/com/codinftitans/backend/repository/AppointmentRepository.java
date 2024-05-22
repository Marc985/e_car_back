package com.codinftitans.backend.repository;

import com.codinftitans.backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    @Query(value = "update appointment set status=:status where id_appointment=:id",nativeQuery = true)
    public void updateStatusById(@Param("status")String status,@Param("id") UUID id);
}
