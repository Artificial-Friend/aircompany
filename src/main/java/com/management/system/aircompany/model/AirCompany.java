package com.management.system.aircompany.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "air_companies")
@Data
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(value = EnumType.STRING)
    private CompanyType type;
    @Column(name = "founded_at")
    private LocalDate foundedAt;

    public enum CompanyType {
        NETWORK, LCC, ULCC
    }
}
