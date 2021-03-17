package com.management.system.aircompany.repository;

import com.management.system.aircompany.model.AirCompany;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    Optional<AirCompany> getByName(String name);
}
