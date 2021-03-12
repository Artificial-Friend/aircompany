package com.management.system.aircompany.controller;

import com.management.system.aircompany.dto.AirplaneRequest;
import com.management.system.aircompany.model.Airplane;
import com.management.system.aircompany.service.AirplaneService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplanes")
@AllArgsConstructor
public class AirplaneController {
    private final ModelMapper mapper;
    private final AirplaneService airplaneService;

    @GetMapping("/transfer")
    public void transferAirplaneToAnotherCompany(@RequestParam String planeSerialNumber,
                                                 @RequestParam Long companyId) {
        airplaneService.changeCompany(companyId, planeSerialNumber);
    }

    @PostMapping("/add")
    public void addAirplane(@Valid AirplaneRequest airplaneRequest) {
        airplaneService.create(mapper.map(airplaneRequest, Airplane.class));
    }
}
