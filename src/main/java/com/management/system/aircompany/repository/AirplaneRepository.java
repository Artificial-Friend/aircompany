package com.management.system.aircompany.repository;

import com.management.system.aircompany.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Airplane findBySerialNumber(String serialNumber);
}
