package com.example.test_service.repo;

import com.example.test_service.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface ConfigRepo extends JpaRepository<Config, Integer> {
    @Modifying
    @Query("UPDATE Config c SET c.params = :params WHERE c.configUUID = :uuid")
    int updateByUUID(String params,UUID uuid);

    void deleteByConfigUUID(UUID configUUID);

    Optional<Config> findByConfigUUID(UUID uuid);
}
