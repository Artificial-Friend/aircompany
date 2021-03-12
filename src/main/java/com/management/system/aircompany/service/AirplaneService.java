package com.management.system.aircompany.service;

import com.management.system.aircompany.model.Airplane;

public interface AirplaneService {
    void changeCompany(Long companyId, String planeSerialNumber);

    void create(Airplane airplane);
}
