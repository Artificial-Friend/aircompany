package com.management.system.aircompany.service.implementation;

import com.management.system.aircompany.model.Airplane;
import com.management.system.aircompany.repository.AirplaneRepository;
import com.management.system.aircompany.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    @Override
    public Airplane getBySerial(String serialNumber) {
        return airplaneRepository.findBySerialNumber(serialNumber).orElseThrow(()
                -> new RuntimeException("ERROR: no airplane with serial number:" + serialNumber));
    }

    @Override
    public void update(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public void create(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public Airplane getById(Long id) {
        return airplaneRepository.getOne(id);
    }
}
