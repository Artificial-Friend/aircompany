package com.management.system.aircompany.service.implementation;

import com.management.system.aircompany.dto.AirCompanyRequest;
import com.management.system.aircompany.model.AirCompany;
import com.management.system.aircompany.repository.AirCompanyRepository;
import com.management.system.aircompany.service.AirCompanyService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private final ModelMapper mapper;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public AirCompany create(AirCompanyRequest airCompanyRequest) {
        return airCompanyRepository.save(mapper.map(airCompanyRequest, AirCompany.class));
    }

    @Override
    public Optional<AirCompany> get(Long id) {
        return airCompanyRepository.findById(id);
    }

    @Override
    public AirCompany update(AirCompany airCompany) {
        return airCompanyRepository.save(airCompany);
    }

    @Override
    public void delete(AirCompany airCompany) {
        airCompanyRepository.delete(airCompany);
    }
}
