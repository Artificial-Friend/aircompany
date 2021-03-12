package com.management.system.aircompany.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.management.system.aircompany.model.Flight;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class FlightRequest {
    @JsonIgnore
    private final Flight.FlightStatus status = Flight.FlightStatus.PENDING;
    @NotNull
    private Long companyId;
    @NotNull
    private Long airplaneId;
    @NotNull
    private String departureCountry;
    @NotNull
    private String destinationCountry;
    @Positive
    private short distance;
    @NotNull
    private LocalTime estimatedFlightTime;
}
