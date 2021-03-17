package com.management.system.aircompany.repository;

import com.management.system.aircompany.model.Airplane;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Optional<Airplane> findBySerialNumber(String serialNumber);
}
