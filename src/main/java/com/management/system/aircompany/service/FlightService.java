package com.management.system.aircompany.service;

import com.management.system.aircompany.model.Flight;
import java.util.List;

public interface FlightService {
    List<Flight> findAllByCompanyAndStatus(String companyName, Flight.FlightStatus status);

    void create(Flight flight);

    void updateFlightStatus(Long id, Flight.FlightStatus status);

    List<Flight> findAllActiveFlightsWithFlightDurationMoreThanDay();
}
