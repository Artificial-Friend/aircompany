package com.management.system.aircompany.dto;

import com.management.system.aircompany.annotation.ValueOfEnum;
import com.management.system.aircompany.model.AirCompany;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
public class AirCompanyRequest {
    @NotNull
    private String name;
    @ValueOfEnum(enumClass = AirCompany.CompanyType.class)
    private String type;
    @PastOrPresent
    private LocalDate foundedAt;
}
