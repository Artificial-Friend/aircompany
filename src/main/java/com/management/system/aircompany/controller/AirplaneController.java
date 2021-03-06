package com.management.system.aircompany.controller;

import com.management.system.aircompany.dto.AirplaneRequest;
import com.management.system.aircompany.model.Airplane;
import com.management.system.aircompany.service.AirCompanyService;
import com.management.system.aircompany.service.AirplaneService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplanes")
@AllArgsConstructor
public class AirplaneController {
    private final ModelMapper mapper;
    private final AirplaneService airplaneService;
    private final AirCompanyService airCompanyService;

    @PatchMapping("/transfer")
    public void transferAirplaneToAnotherCompany(@RequestParam String planeSerialNumber,
                                                 @RequestParam Long companyId) {
        Airplane airplane = airplaneService.getBySerial(planeSerialNumber);
        airplane.setCompany(airCompanyService.get(companyId));
        airplaneService.update(airplane);
    }

    @PostMapping
    public void addAirplane(@RequestBody @Valid AirplaneRequest airplaneRequest) {
        Airplane airplane = mapper.map(airplaneRequest, Airplane.class);
        airplane.setCompany(airCompanyService.getByName(airplaneRequest.getCompany()));
        airplaneService.create(airplane);
    }
}
