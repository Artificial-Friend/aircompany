package com.management.system.aircompany.service.implementation;

import com.management.system.aircompany.model.AirCompany;
import com.management.system.aircompany.repository.AirCompanyRepository;
import com.management.system.aircompany.service.AirCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public AirCompany save(AirCompany airCompany) {
        return airCompanyRepository.save(airCompany);
    }

    @Override
    public AirCompany get(Long id) {
        return airCompanyRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no air company with id " + id));
    }

    @Override
    public void delete(Long id) {
        airCompanyRepository.deleteById(id);
    }

    @Override
    public AirCompany getByName(String name) {
        return airCompanyRepository.getByName(name).orElseThrow(() ->
                new RuntimeException("ERROR: no such company with name: " + name));
    }
}
