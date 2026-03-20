package dev.felippevaz.vzp_company_service.modules.department.mapper;

import dev.felippevaz.vzp_company_service.modules.employee.domain.Employee;
import dev.felippevaz.vzp_company_service.modules.employee.service.EmployeeService;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperUtil {

    private final EmployeeService service;

    public DepartmentMapperUtil(EmployeeService service) {
        this.service = service;
    }

    @Named("getEntity")
    public Employee getEntity(Long id) {
        return this.service.getEmployee(id);
    }
}
