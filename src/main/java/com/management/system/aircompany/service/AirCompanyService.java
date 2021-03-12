package com.management.system.aircompany.service;

import com.management.system.aircompany.dto.AirCompanyRequest;
import com.management.system.aircompany.model.AirCompany;
import java.util.Optional;

public interface AirCompanyService {
    AirCompany create(AirCompanyRequest airCompanyRequest);

    Optional<AirCompany> get(Long id);

    AirCompany update(AirCompany airCompany);

    void delete(AirCompany airCompany);
}
