package dev.felippevaz.vzp_company_service.modules.employee.domain;

import dev.felippevaz.vzp_company_service.common.domain.Address;
import dev.felippevaz.vzp_company_service.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends BaseEntity {

    private String name;
    private String email;

    @Embedded
    private Address address;

    private Long department; //todo: instantiate object Department later
}
