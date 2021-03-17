package com.management.system.aircompany.service;

import com.management.system.aircompany.model.AirCompany;

public interface AirCompanyService {
    AirCompany save(AirCompany airCompany);

    AirCompany get(Long id);

    void delete(Long id);

    AirCompany getByName(String name);
}
