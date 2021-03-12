package com.management.system.aircompany.service.implementation;

import com.management.system.aircompany.model.Flight;
import com.management.system.aircompany.repository.FlightRepository;
import com.management.system.aircompany.service.FlightService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public List<Flight> findAllByCompanyAndStatus(String companyName, Flight.FlightStatus status) {
        return flightRepository.findAllByCompanyAndStatus(companyName, status);
    }

    @Override
    public void create(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void updateFlightStatus(Long id, Flight.FlightStatus status) {
        Flight flight = flightRepository.getOne(id);
        switch (status) {
            case DELAYED:
                flight.setDelayStartedAt(LocalDateTime.now());
                flight.setStatus(Flight.FlightStatus.DELAYED);
                flightRepository.save(flight);
                return;
            case ACTIVE:
                flight.setCreatedAt(LocalDateTime.now());
                flight.setStatus(Flight.FlightStatus.ACTIVE);
                flightRepository.save(flight);
                return;
            case COMPLETED:
                flight.setEndedAt(LocalDateTime.now());
                flight.setStatus(Flight.FlightStatus.COMPLETED);
                flightRepository.save(flight);
                return;
            default:
                throw new RuntimeException("ERROR: Can't update flight status, "
                        + "invalid flight id or status");
        }
    }

    @Override
    public List<Flight> findAllActiveFlightsWithFlightDurationMoreThanDay() {
        return flightRepository.findAllActiveFlightsWithFlightDurationMoreThan(
                LocalDateTime.now().minusHours(24));
    }
}
