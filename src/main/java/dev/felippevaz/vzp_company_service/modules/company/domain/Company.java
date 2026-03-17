package dev.felippevaz.vzp_company_service.modules.company.domain;

import dev.felippevaz.vzp_company_service.common.domain.Address;
import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;

    @Embedded
    private Address address;

    private List<String> emails;
    private List<String> phoneNumbers;

    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employees;

    private LocalDate foundation;
    private LocalDate startedServiceAt;

    private ServiceStatus status;

}
