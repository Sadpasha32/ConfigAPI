package com.example.test_service.repo;

import com.example.test_service.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CalculationRepo extends JpaRepository<Calculation,Integer> {

    @Query("SELECT cal " +
            "FROM Calculation cal " +
            "JOIN Config con ON cal.configID = con.configID " +
            "WHERE con.configUUID = :configUUID")
    Calculation findByConfigUUID(UUID configUUID);
}
