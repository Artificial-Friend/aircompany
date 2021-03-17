package com.management.system.aircompany.controller;

import com.management.system.aircompany.annotation.ValueOfEnum;
import com.management.system.aircompany.dto.FlightRequest;
import com.management.system.aircompany.model.Flight;
import com.management.system.aircompany.service.AirCompanyService;
import com.management.system.aircompany.service.AirplaneService;
import com.management.system.aircompany.service.FlightService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;

    @GetMapping("/company/{companyName}")
    public List<Flight> allCompanyFlightsByStatus(@PathVariable String companyName,
                                                  @RequestParam Flight.FlightStatus status) {
        return flightService.findAllByCompanyAndStatus(companyName, status);
    }

    @GetMapping("/active/duration=24h")
    public List<Flight> allActiveFlightsWithMoreThanDayDuration() {
        return flightService.findAllActiveFlightsWithFlightDurationMoreThanDay();
    }

    @PostMapping
    public void addFlight(@RequestBody @Valid FlightRequest flightRequest) {
        Flight flight = new Flight();
        flight.setCompany(airCompanyService.get(flightRequest.getCompanyId()));
        flight.setAirplane(airplaneService.getById(flightRequest.getAirplaneId()));
        flight.setEstimatedFlightTime(flightRequest.getEstimatedFlightTime());
        flight.setDistance(flightRequest.getDistance());
        flight.setDepartureCountry(flightRequest.getDepartureCountry());
        flight.setDestinationCountry(flightRequest.getDestinationCountry());
        flight.setStatus(Flight.FlightStatus.PENDING);
        flightService.create(flight);
    }

    @PatchMapping("/{id}")
    public void updateFlightStatus(@PathVariable Long id,
                                   @RequestParam @ValueOfEnum(enumClass =
                                           Flight.FlightStatus.class) Flight.FlightStatus status) {
        flightService.updateFlightStatus(id, status);
    }
}
