package dev.felippevaz.vzp_company_service.modules.company.domain;

import dev.felippevaz.vzp_company_service.common.domain.Address;
import dev.felippevaz.vzp_company_service.modules.department.domain.Department;
import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;

    @Embedded
    private Address address;

    private List<String> emails;
    private List<String> phones;

    @OneToMany(mappedBy = "company")
    private List<Department> departments;

    private LocalDate foundation;
    private LocalDateTime startedServiceAt;

    private ServiceStatus status;

    @PrePersist
    private void prePersist() {
        this.startedServiceAt = LocalDateTime.now();
        this.status = ServiceStatus.ACTIVE;
    }
}
