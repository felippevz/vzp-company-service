package dev.felippevaz.vzp_company_service.modules.employee.domain;

import dev.felippevaz.vzp_company_service.common.domain.Address;
import dev.felippevaz.vzp_company_service.modules.company.domain.Company;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Embedded
    private Address address;

    private UUID departmentId;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Company enterprise;
}
