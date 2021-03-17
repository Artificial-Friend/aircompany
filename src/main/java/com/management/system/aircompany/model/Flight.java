package com.management.system.aircompany.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private FlightStatus status;
    @ManyToOne
    private AirCompany company;
    @ManyToOne
    private Airplane airplane;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    private short distance;
    @Column(name = "estimated_flight_time")
    private LocalTime estimatedFlightTime;
    private LocalDateTime endedAt;
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum FlightStatus {
        ACTIVE, COMPLETED, DELAYED, PENDING
    }
}
