package com.management.system.aircompany.controller;

import com.management.system.aircompany.dto.AirCompanyRequest;
import com.management.system.aircompany.dto.AirCompanyResponse;
import com.management.system.aircompany.model.AirCompany;
import com.management.system.aircompany.service.AirCompanyService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airCompanies")
@AllArgsConstructor
public class AirCompanyController {
    private final ModelMapper mapper;
    private final AirCompanyService airCompanyService;

    @GetMapping
    public AirCompanyResponse get(@RequestParam Long id) {
        return mapper.map(airCompanyService.get(id), AirCompanyResponse.class);
    }

    @PostMapping
    public void create(@RequestBody @Valid AirCompanyRequest airCompanyRequest) {
        airCompanyService.save(mapper.map(airCompanyRequest, AirCompany.class));
    }

    @PatchMapping
    public void update(@RequestParam Long id,
                       @RequestBody @Valid AirCompanyRequest airCompanyRequest) {
        AirCompany airCompany = mapper.map(airCompanyRequest, AirCompany.class);
        airCompany.setId(id);
        airCompanyService.save(airCompany);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        airCompanyService.delete(id);
    }
}
