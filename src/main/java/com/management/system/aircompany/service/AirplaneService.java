package com.management.system.aircompany.service;

import com.management.system.aircompany.model.Airplane;

public interface AirplaneService {
    Airplane getBySerial(String serialNumber);

    void update(Airplane airplane);

    void create(Airplane airplane);

    Airplane getById(Long id);
}
