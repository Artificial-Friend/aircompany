package com.management.system.aircompany.service.implementation;

import com.management.system.aircompany.model.Airplane;
import com.management.system.aircompany.repository.AirCompanyRepository;
import com.management.system.aircompany.repository.AirplaneRepository;
import com.management.system.aircompany.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public void changeCompany(Long companyId, String serialNumber) {
        Airplane airplane = airplaneRepository.findBySerialNumber(serialNumber);
        airplane.setCompany(airCompanyRepository.getOne(companyId));
        airplaneRepository.save(airplane);
    }

    @Override
    public void create(Airplane airplane) {
        airplaneRepository.save(airplane);
    }
}
