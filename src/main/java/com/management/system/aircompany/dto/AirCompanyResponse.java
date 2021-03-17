package com.management.system.aircompany.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AirCompanyResponse {
    private Long id;
    private String name;
    private String type;
    private LocalDate foundedAt;
}
