package dev.felippevaz.vzp_company_service.modules.department.domain;

import dev.felippevaz.vzp_company_service.common.domain.BaseEntity;
import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Department extends BaseEntity {

    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
