package com.management.system.aircompany.repository;

import com.management.system.aircompany.model.Flight;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("FROM Flight f JOIN FETCH f.company c WHERE c.name = ?1 AND f.status = ?2")
    List<Flight> findAllByCompanyAndStatus(String companyName, Flight.FlightStatus status);

    @Query("FROM Flight f WHERE f.createdAt <= :date AND f.status = 'ACTIVE'")
    List<Flight> findAllActiveFlightsWithFlightDurationMoreThan(
            @Param(value = "date") LocalDateTime localDateTime);
}
