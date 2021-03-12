package com.management.system.aircompany.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "airplanes")
@Data
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, name = "serial_number")
    private String serialNumber;
    @ManyToOne
    private AirCompany company;
    @Column(name = "number_of_flights")
    private int numberOfFlights;
    @Column(name = "flight_distance")
    private long flightDistance;
    @Column(name = "fuel_capacity")
    private int fuelCapacity;
    @Enumerated
    private AirplaneTypes type;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public enum AirplaneTypes {
        LIGHT, MEDIUM, HEAVY
    }
}
