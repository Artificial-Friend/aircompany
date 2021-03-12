package com.management.system.aircompany.controller;

import com.management.system.aircompany.annotation.ValueOfEnum;
import com.management.system.aircompany.dto.FlightRequest;
import com.management.system.aircompany.model.Flight;
import com.management.system.aircompany.service.AirplaneService;
import com.management.system.aircompany.service.FlightService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/flights")
public class FlightController {
    private final ModelMapper mapper;
    private final FlightService flightService;

    @GetMapping
    public List<Flight> allCompanyFlightsByStatus(@RequestParam String companyName,
                                                  @RequestParam Flight.FlightStatus status) {
        return flightService.findAllByCompanyAndStatus(companyName, status);
    }

    @GetMapping("/")
    public List<Flight> allActiveFlightsWithMoreThanDayDuration() {
        return flightService.findAllActiveFlightsWithFlightDurationMoreThanDay();
    }

    @PostMapping("/create")
    public void addFlight(@RequestBody @Valid FlightRequest flightRequest) {
        flightService.create(mapper.map(flightRequest, Flight.class));
    }

    @PostMapping
    public void updateFlightStatus(@RequestParam Long flightId,
                                   @RequestParam @ValueOfEnum(enumClass =
                                           Flight.FlightStatus.class) Flight.FlightStatus status) {
        flightService.updateFlightStatus(flightId, status);
    }
}
