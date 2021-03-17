package com.management.system.aircompany.dto;

import com.management.system.aircompany.annotation.ValueOfEnum;
import com.management.system.aircompany.model.Airplane;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class AirplaneRequest {
    @NotNull
    private String name;
    @NotNull
    private String serialNumber;
    private String company;
    @PositiveOrZero
    private int numberOfFlights;
    @PositiveOrZero
    private long flightDistance;
    @PositiveOrZero
    private int fuelCapacity;
    @ValueOfEnum(enumClass = Airplane.AirplaneType.class)
    private String airplaneType;
    @PastOrPresent
    private LocalDate createdAt;
}
